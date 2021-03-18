package com.nagarro.vaccnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.vaccnow.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

	@Query(value = "SELECT * FROM BRANCH where BRANCH_ID = ?1", nativeQuery = true)
	public Branch getBranchById(Integer branchId);
}
