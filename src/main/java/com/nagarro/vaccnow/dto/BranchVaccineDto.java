package com.nagarro.vaccnow.dto;

import lombok.Data;

@Data
public class BranchVaccineDto {

	private Integer id;
	private BranchDto branch;
	private VaccineDto vaccine;
	private Integer vaccineCount;

}
