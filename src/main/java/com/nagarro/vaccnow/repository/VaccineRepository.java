package com.nagarro.vaccnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.vaccnow.entity.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

	@Query(value = "SELECT * FROM VACCINE where VACCINE_ID = ?1", nativeQuery = true)
	public Vaccine getVaccineById(Integer vaccineId);
}
