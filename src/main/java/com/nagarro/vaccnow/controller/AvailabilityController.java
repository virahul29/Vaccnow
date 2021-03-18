package com.nagarro.vaccnow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.vaccnow.dto.BranchDto;
import com.nagarro.vaccnow.service.BranchService;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

	@Autowired
	BranchService service;

	@GetMapping("/branch")
	public ResponseEntity<List<String>> getAllBranch() {
		return ResponseEntity.ok(service.getAllBranch());
	}
	
	@GetMapping("/list-vaccines/{branchId}")
	public ResponseEntity<List<String>> getListOfVaccienByBranch(@PathVariable(required = false) Integer branchId){
		return ResponseEntity.ok(service.listOfVaccinesByBranch(branchId));
	}

	@GetMapping(value = "/available-timeslots/{branchId}")
	public ResponseEntity<BranchDto> getAvailableTimeSlots(
			@PathVariable Integer branchId){
		return ResponseEntity.ok(service.availableTimeSlots(branchId));
	}
}
