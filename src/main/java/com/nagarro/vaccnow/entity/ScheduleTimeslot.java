package com.nagarro.vaccnow.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@Entity
@Table(name = "schedule_timeslot")
public class ScheduleTimeslot implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_timeslot_id")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id")
	private Branch branch;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;
	@Column(name = "slot_date")
	private Date slotDate;
	@Column(name = "email")
	private String email;
	@Column(name = "transaction_id")
	private String transactionId;
	@Column(name = "transaction_status")
	private String transactionStatus;
	@Column(name = "vaccinaction_done")
	private short vaccinactionDone;

}
