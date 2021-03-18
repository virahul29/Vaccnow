package com.nagarro.vaccnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.vaccnow.dto.ScheduleTimeslotDto;
import com.nagarro.vaccnow.service.BranchVaccinationService;
import com.nagarro.vaccnow.utility.GlobalConstants;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

	@Autowired
	private BranchVaccinationService branchVaccinationService;

	@PostMapping(value = "/schedule-vaccination-timeslot")
	public ResponseEntity<String> SaveScheduleVaccinationTimeslot(@RequestBody ScheduleTimeslotDto scheduleTimeslotDTO) {
		if(branchVaccinationService.slotAvailable(scheduleTimeslotDTO)) {  			
			return ResponseEntity.ok(branchVaccinationService.scheduleVaccinationTimeslot(scheduleTimeslotDTO));
		}else {
			return ResponseEntity.status(HttpStatus.IM_USED).body("Sloat Already Booked. Please try another sloat.");
		}
	}
	
	@PutMapping(value = "/confirm-vaccination/{email}")
	public ResponseEntity<String> getConfirmVaccinationTimeslot(
			@PathVariable String email) {
		if(GlobalConstants.UPDATED.equals(branchVaccinationService.confirmVaccination(email))) {
			return ResponseEntity.ok(GlobalConstants.UPDATED);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
