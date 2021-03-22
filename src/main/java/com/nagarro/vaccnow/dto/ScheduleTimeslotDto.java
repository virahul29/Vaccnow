package com.nagarro.vaccnow.dto;

import lombok.Data;

@Data
public class ScheduleTimeslotDto{

	private Integer id;
	private BranchDto branch;
	private VaccineDto vaccine;
	private String slotDate;
	private String email;
	private String transactionId;
	private String transactionStatus;
	private short vaccinactionDone;
	
}
