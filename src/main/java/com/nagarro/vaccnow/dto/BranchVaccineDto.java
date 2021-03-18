package com.nagarro.vaccnow.dto;

public class BranchVaccineDto {

	private Integer id;
	private BranchDto branch;
	private VaccineDto vaccine;
	private Integer vaccineCount;

	
	public BranchVaccineDto() {
		super();
	}

	public BranchVaccineDto(Integer id, BranchDto branch, VaccineDto vaccine, Integer vaccineCount) {
		super();
		this.id = id;
		this.branch = branch;
		this.vaccine = vaccine;
		this.vaccineCount = vaccineCount;
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

	public Integer getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(Integer vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

}
