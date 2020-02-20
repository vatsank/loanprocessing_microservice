package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoanApplication;

@Repository
public interface LoanProcessing extends JpaRepository<LoanApplication, Integer> {

	
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update loan_application set status='Approved' where panId=:panId")
	public int updateStatus(@Param("panId") String panId);
}
