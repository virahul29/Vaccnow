package com.nagarro.vaccnow.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.vaccnow.service.BranchVaccinationService;
import com.nagarro.vaccnow.utility.GlobalConstants;

@RestController
@RequestMapping("/reporting")
public class ReportingController {

	@Autowired
	private BranchVaccinationService branchVaccinationService;

	@GetMapping(value = "/applied-vaccination-per-branch/{branchId}")
	public ResponseEntity<List<String>> getAppliedVaccinationPerBranch(@PathVariable Integer branchId) {
		return ResponseEntity.ok(branchVaccinationService.getScheduleVaccinationByBranch(branchId));
	}

	@GetMapping(value = { "/applied-vaccination-per-day/{start}/{end}/{branchId}" })
	public ResponseEntity<List<String>> getAppliedVaccinationPerByDatesAndBranch(@PathVariable(required = false) String start,
			@PathVariable(required = false) String end, @PathVariable(required = false) Integer branchId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GlobalConstants.YYYY_MM_DD);
		LocalDate startDate = LocalDate.parse(start, formatter);
		LocalDate endDate = LocalDate.parse(end, formatter).plusDays(1);

		return ResponseEntity.ok(branchVaccinationService.getScheduleVaccinationPerDay(startDate, endDate, branchId));
	}

	@GetMapping(value = { "/confirmed-vaccinations/{start}/{end}" })
	public ResponseEntity<List<String>> getConfirmedVaccinations(@PathVariable String start, @PathVariable String end) {
		LocalDate startDate, endDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GlobalConstants.YYYY_MM_DD);
		startDate = LocalDate.parse(start, formatter);
		endDate = LocalDate.parse(end, formatter).plusDays(1);
		return ResponseEntity.ok(branchVaccinationService.confirmedVaccinations(startDate, endDate));
	}
}
