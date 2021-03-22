package com.nagarro.vaccnow.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
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

}
