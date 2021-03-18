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

	public ScheduleTimeslot() {
		super();
	}

	public ScheduleTimeslot(Integer id, Branch branch, Vaccine vaccine, Date slotDate, String email,
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

	public Date getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(Date slotDate) {
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
