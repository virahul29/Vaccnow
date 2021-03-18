package com.nagarro.vaccnow.dto;

public class VaccineDto{

	private Integer id;
	private String vaccineName;

	public VaccineDto() {
		super();
	}

	public VaccineDto(Integer id, String vaccineName) {
		super();
		this.id = id;
		this.vaccineName = vaccineName;
	}

	public VaccineDto(Integer vaccineId) {
		this.id = vaccineId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

}
