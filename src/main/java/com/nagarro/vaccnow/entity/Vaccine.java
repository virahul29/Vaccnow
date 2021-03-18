package com.nagarro.vaccnow.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "vaccine")
public class Vaccine implements Serializable {

	@Id
	@Column(name = "vaccine_id")
	private Integer id;
	@Column(name = "vaccine_name")
	private String vaccineName;

	public Vaccine() {
	}

	public Vaccine(Integer id, String vaccineName) {
		super();
		this.id = id;
		this.vaccineName = vaccineName;
	}

	public Vaccine(Integer vaccineId) {
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
