package com.nagarro.vaccnow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.vaccnow.entity.BranchVaccine;

@Repository
public interface BranchVaccineRepository extends JpaRepository<BranchVaccine, Integer> {

	@Query(value = "SELECT V.VACCINE_NAME FROM BRANCH_VACCINE BV inner join vaccine V where BV.Branch_id = ?1", nativeQuery = true)
	public List<String> listOfVaccinesByBranch(Integer branchId);

}
