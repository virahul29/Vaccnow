package com.nagarro.vaccnow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.vaccnow.enums.ErrorCodes;

@RestControllerAdvice
public class VaccinationControllerAdvice {

	@ExceptionHandler(InvalidVaccineRequestException.class)
	public ResponseEntity<ApiErrorResponse> handleInvalidVaccineRequestException(InvalidVaccineRequestException ex) {
		ApiErrorResponse response = new ApiErrorResponse(ErrorCodes.INVALID_VACCINATION_REQUEST.getResponseCode(),
				String.format(ErrorCodes.INVALID_VACCINATION_REQUEST.getResponseMessage(), ex.getBranchName(),
						ex.getVaccineName(), ex.getScheduledTime()));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SlotNotAvailableException.class)
	public ResponseEntity<String> handleSlotNotAvailableException(SlotNotAvailableException ex) {

		return ResponseEntity.status(HttpStatus.IM_USED).body("Sloat Already Booked. Please try another sloat.");

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not available with given emailId");

	}
}
