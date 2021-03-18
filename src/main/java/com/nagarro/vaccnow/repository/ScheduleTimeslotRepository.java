package com.nagarro.vaccnow.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.vaccnow.entity.ScheduleTimeslot;

@Repository
public interface ScheduleTimeslotRepository extends JpaRepository<ScheduleTimeslot, Integer> {

	@Query(value = "select * from SCHEDULE_TIMESLOT where SLOT_DATE = :slotDate "
			+ "and transaction_status in (:transactionStatus) " , nativeQuery = true)
	public ScheduleTimeslot slotAvailable(@Param(value = "slotDate") Date slotDate, 
			@Param(value = "transactionStatus") List<String> transactionStatus);
	
	@Query(value = "select * from SCHEDULE_TIMESLOT where EMAIL = :email", nativeQuery = true)
	ScheduleTimeslot findByEmail(@Param(value = "email") String email);
	
	@Query(value = "SELECT * from SCHEDULE_TIMESLOT where BRANCH_ID = :branchId", nativeQuery = true)
	List<ScheduleTimeslot> findAllByBranchId(@Param(value = "branchId") Integer branchId);
	
	@Query(value = "select * from SCHEDULE_TIMESLOT where SLOT_DATE between :start and :end and BRANCH_ID = :branchId" , nativeQuery = true)
	List<ScheduleTimeslot> findAllByDay(@Param(value = "start") Date start,
			@Param(value = "end") Date end, @Param(value = "branchId") int branchId);
	
	@Query(value = "select * from SCHEDULE_TIMESLOT where VACCINACTION_DONE=1 and SLOT_DATE between :start and :end" , nativeQuery = true)
	List<ScheduleTimeslot> findAllConfirmedByDay(@Param(value = "start") Date start,
			@Param(value = "end") Date end);
}
