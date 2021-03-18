package com.nagarro.vaccnow.modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nagarro.vaccnow.dto.BranchDto;
import com.nagarro.vaccnow.dto.BranchVaccineDto;
import com.nagarro.vaccnow.dto.ScheduleTimeslotDto;
import com.nagarro.vaccnow.dto.VaccineDto;
import com.nagarro.vaccnow.entity.Branch;
import com.nagarro.vaccnow.entity.BranchVaccine;
import com.nagarro.vaccnow.entity.ScheduleTimeslot;
import com.nagarro.vaccnow.entity.Vaccine;

@Mapper(componentModel = "spring")
public interface ModelMapper {

	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

	 BranchDto BranchEntityToDto(Branch branchEntity);
	
	 BranchVaccineDto BranchVaccineEntityToDto(BranchVaccine branchVaccineEntity);
	
	 ScheduleTimeslotDto ScheduleTimeslotEntityToDto(ScheduleTimeslot scheduleTimeslotEntity);
	
	 VaccineDto VaccineEntityToDto(Vaccine vaccineEntity);
	
	
}
