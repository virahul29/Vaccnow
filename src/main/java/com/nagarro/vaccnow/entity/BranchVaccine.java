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

import lombok.Data;

@Data
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

}
