package com.nagarro.vaccnow.dto;

import java.util.Date;

public class ScheduleTimeslotDto{

	private Integer id;
	private BranchDto branch;
	private VaccineDto vaccine;
	private String slotDate;
	private String email;
	private String transactionId;
	private String transactionStatus;
	private short vaccinactionDone;
	

	public ScheduleTimeslotDto() {
		super();
	}

	public ScheduleTimeslotDto(Integer id, BranchDto branch, VaccineDto vaccine, String slotDate, String email,
			String transactionId, String transactionStatus, short vaccinactionDone) {
		super();
		this.id = id;
		this.branch = branch;
		this.vaccine = vaccine;
		this.slotDate = slotDate;
		this.email = email;
		this.transactionId = transactionId;
		this.transactionStatus = transactionStatus;
		this.vaccinactionDone = vaccinactionDone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BranchDto getBranch() {
		return branch;
	}

	public void setBranch(BranchDto branch) {
		this.branch = branch;
	}

	public VaccineDto getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineDto vaccine) {
		this.vaccine = vaccine;
	}

	public String getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public short getVaccinactionDone() {
		return vaccinactionDone;
	}

	public void setVaccinactionDone(short vaccinactionDone) {
		this.vaccinactionDone = vaccinactionDone;
	}

}
