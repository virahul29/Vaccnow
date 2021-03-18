package com.nagarro.vaccnow.dto;

import java.sql.Time;
import java.util.List;

public class BranchDto{

	private Integer id;
	private String branchName;
	private Time timeFrom;
	private Time timeTo;
	private List<VaccineDto> vaccines;
	private List<String> slots;
	
	public BranchDto() {
		super();
	}
	public BranchDto(Integer id, String branchName, Time timeFrom, Time timeTo, List<VaccineDto> vaccines,
			List<String> slots) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.vaccines = vaccines;
		this.slots = slots;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Time getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Time getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Time timeTo) {
		this.timeTo = timeTo;
	}
	public List<VaccineDto> getVaccines() {
		return vaccines;
	}
	public void setVaccines(List<VaccineDto> vaccines) {
		this.vaccines = vaccines;
	}
	public List<String> getSlots() {
		return slots;
	}
	public void setSlots(List<String> slots) {
		this.slots = slots;
	}

	

}
