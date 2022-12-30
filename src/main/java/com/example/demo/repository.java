package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface repository extends JpaRepository<employee,Integer>{

	@Query(value="SELECT * FROM employee s where s.employeeId=?1",nativeQuery=true)
	List<employee> findById(int id);
	
	
	@Query(value="SELECT * FROM employee s where s.employeeName=?1",nativeQuery=true)
	List<employee> findByName(String employeeName);
	
	
	@Modifying
	@Transactional
	@Query(value="Update employee s set s.employeeId=?1 , s.employeeName=?2 , s.employeeEmail=?3 , s.dept=?4 where s.employeeId=?5", nativeQuery=true)
	void update(int employeeId,String employeeName, String employeeEmail, String dept, int id);
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM employee where employeeId=?1", nativeQuery=true)
	void deleteAllByIdInBatch(int id);
}