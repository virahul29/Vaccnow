package com.nagarro.vaccnow.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.vaccnow.dto.ScheduleTimeslotDto;
import com.nagarro.vaccnow.entity.ScheduleTimeslot;
import com.nagarro.vaccnow.repository.BranchRepository;
import com.nagarro.vaccnow.repository.BranchVaccineRepository;
import com.nagarro.vaccnow.repository.ScheduleTimeslotRepository;
import com.nagarro.vaccnow.repository.VaccineRepository;
import com.nagarro.vaccnow.utility.EmailServiceUtil;
import com.nagarro.vaccnow.utility.GlobalConstants;
import com.nagarro.vaccnow.utility.TransactionStatus;

@Service
public class BranchVaccinationService {

	@Autowired
	BranchRepository repository;

	@Autowired
	BranchVaccineRepository branchVaccineRepository;

	@Autowired
	VaccineRepository vaccineRepository;

	@Autowired
	ScheduleTimeslotRepository scheduleTimeslotRepository;

	public boolean slotAvailable(ScheduleTimeslotDto scheduleTimeslotDTO) {
		try {
			Date slotDate = new SimpleDateFormat(GlobalConstants.YYYY_MM_DD).parse(scheduleTimeslotDTO.getSlotDate());
			ScheduleTimeslot scheduleTimeslot = scheduleTimeslotRepository.slotAvailable(slotDate,
					Arrays.asList(TransactionStatus.INITIATED, TransactionStatus.SUCCESS));
			if (scheduleTimeslot == null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String scheduleVaccinationTimeslot(ScheduleTimeslotDto scheduleTimeslotDTO){

		String response = null;

		ScheduleTimeslot scheduleTimeslot = new ScheduleTimeslot();
		scheduleTimeslot.setBranch(repository.getBranchById(scheduleTimeslotDTO.getBranch().getId()));
		scheduleTimeslot.setVaccine(vaccineRepository.getVaccineById(scheduleTimeslotDTO.getVaccine().getId()));
		scheduleTimeslot.setEmail(scheduleTimeslotDTO.getEmail());
		scheduleTimeslot.setTransactionId(UUID.randomUUID().toString());
		scheduleTimeslot.setTransactionStatus(TransactionStatus.INITIATED);
		scheduleTimeslot.setVaccinactionDone((short) 0);
		Date slotDate = null;
		try {
			slotDate = new SimpleDateFormat(GlobalConstants.YYYY_MM_DD).parse(scheduleTimeslotDTO.getSlotDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduleTimeslot.setSlotDate(slotDate);
		scheduleTimeslotRepository.save(scheduleTimeslot);

		// Sending scheduled email
		EmailServiceUtil.sendScheduleMail(scheduleTimeslot);

		response = GlobalConstants.SUCCESS;
		return response;
	}

	public String confirmVaccination(String email) {
		ScheduleTimeslot scheduleTimeslot = scheduleTimeslotRepository.findByEmail(email);
		if (scheduleTimeslot != null) {
			scheduleTimeslot.setVaccinactionDone((short) 1);
			scheduleTimeslot.setTransactionStatus(TransactionStatus.SUCCESS);
			scheduleTimeslotRepository.save(scheduleTimeslot);
			return GlobalConstants.UPDATED;
		} else {
			return GlobalConstants.NOT_FOUND;
		}
	}

	public List<String> getScheduleVaccinationByBranch(Integer branchId) {

		List<String> vaccineName = null;
		List<ScheduleTimeslot> findAllByBranchId = scheduleTimeslotRepository.findAllByBranchId(branchId);
		if (findAllByBranchId != null) {
			vaccineName = findAllByBranchId.stream().map(i -> i.getVaccine().getVaccineName())
					.collect(Collectors.toList());
		}

		return vaccineName;
	}

	public List<String> getScheduleVaccinationPerDay(LocalDate start, LocalDate end, int branchId) {

		List<String> vaccineName = null;
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat(GlobalConstants.YYYY_MM_DD).parse(start.toString());
			endDate = new SimpleDateFormat(GlobalConstants.YYYY_MM_DD).parse(end.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<ScheduleTimeslot> scheduleTimeslotList = scheduleTimeslotRepository.findAllByDay(startDate, endDate,
				branchId);

		vaccineName = scheduleTimeslotList.stream().map(i -> i.getVaccine().getVaccineName())
				.collect(Collectors.toList());
		return vaccineName;
	}

	public List<String> confirmedVaccinations(LocalDate start, LocalDate end) {

		List<String> conformendVaccine = null;
		try {
			List<ScheduleTimeslot> findAllByBranchId;
			Date startDate = new SimpleDateFormat(GlobalConstants.YYYY_MM_DD).parse(start.toString());
			Date endDate = new SimpleDateFormat(GlobalConstants.YYYY_MM_DD).parse(end.toString());
			findAllByBranchId = scheduleTimeslotRepository.findAllConfirmedByDay(startDate, endDate);

			conformendVaccine = findAllByBranchId.stream().map(i -> i.getVaccine().getVaccineName())
					.collect(Collectors.toList());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return conformendVaccine;
	}

}
