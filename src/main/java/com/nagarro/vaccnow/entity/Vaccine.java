package com.nagarro.vaccnow.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@Entity
@Table(name = "vaccine")
public class Vaccine implements Serializable {

	@Id
	@Column(name = "vaccine_id")
	private Integer id;
	@Column(name = "vaccine_name")
	private String vaccineName;

}
