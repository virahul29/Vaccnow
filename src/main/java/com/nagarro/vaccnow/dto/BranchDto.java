package com.nagarro.vaccnow.dto;

import java.sql.Time;
import java.util.List;

import lombok.Data;

@Data
public class BranchDto{

	private Integer id;
	private String branchName;
	private Time timeFrom;
	private Time timeTo;
	private List<VaccineDto> vaccines;
	private List<String> slots;
	
}
