package com.nagarro.vaccnow.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "branch")
public class Branch implements Serializable {

	@Id
	@Column(name = "branch_id")
	private Integer id;
	@Column(name = "branch_name")
	private String branchName;
	@Column(name = "time_from")
	private Time timeFrom;
	@Column(name = "time_to")
	private Time timeTo;

	public Branch() {

	}

	public Branch(Integer id, String branchName, Time timeFrom, Time timeTo) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
	}

	public Branch(Integer brancnId) {
		this.id = brancnId;
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

}
