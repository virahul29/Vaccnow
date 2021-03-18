package com.nagarro.vaccnow.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "branch_vaccine")
public class BranchVaccine implements Serializable {

	@Id
	@Column(name = "branch_vaccine_id")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id")
	private Branch branch;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;

	@Column(name = "vaccine_count")
	private Integer vaccineCount;
	
	public BranchVaccine() {
		super();
	}

	public BranchVaccine(Integer id, Branch branch, Vaccine vaccine, Integer vaccineCount) {
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

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Integer getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(Integer vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

}
