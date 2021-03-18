package com.nagarro.vaccnow.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.vaccnow.dto.BranchDto;
import com.nagarro.vaccnow.entity.Branch;
import com.nagarro.vaccnow.modelmapper.ModelMapper;
import com.nagarro.vaccnow.repository.BranchRepository;
import com.nagarro.vaccnow.repository.BranchVaccineRepository;
import com.nagarro.vaccnow.utility.GlobalConstants;

@Service
public class BranchService {

	@Autowired
	BranchRepository repository;

	@Autowired
	BranchVaccineRepository branchVaccineRepository;

	public Branch saveBranch(Branch branch) {
		return repository.save(branch);
	}

	public List<String> getAllBranch() {

		List<BranchDto> branchDtoList = null;
		List<Branch> branchList = repository.findAll();

		if (!branchList.isEmpty()) {

			branchDtoList = branchList.stream().map(branch -> ModelMapper.INSTANCE.BranchEntityToDto(branch))
					.collect(Collectors.toList());
		}
		
		List<String> branchNameList = branchDtoList.stream().map(i-> i.getBranchName()).collect(Collectors.toList());

		return branchNameList;
	}

	public List<String> listOfVaccinesByBranch(Integer branchId) {
		
		List<String> vaccineList = branchVaccineRepository.listOfVaccinesByBranch(branchId);
		
		return vaccineList;
	}
	
	public BranchDto availableTimeSlots(Integer branchId) {
		Branch branch = repository.getBranchById(branchId);
		BranchDto branchDto = null;
		if(branch != null) {
			List<String> slots = new ArrayList();
			branchDto = ModelMapper.INSTANCE.BranchEntityToDto(branch);
			
			LocalTime from = branchDto.getTimeFrom().toLocalTime();
			LocalTime to = branchDto.getTimeTo().toLocalTime();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(GlobalConstants.YYYY_MM_DD_HH_MM);
			while(from.isBefore(to.plusMinutes(1))) {
				slots.add(LocalDateTime.now().withHour(from.getHour()).withMinute(from.getMinute()).format(dateTimeFormatter));
				from = from.plusMinutes(GlobalConstants.MINUTES_INTERVAL);
			}
			branchDto.setSlots(slots);
		}
		return branchDto;
	}

}
