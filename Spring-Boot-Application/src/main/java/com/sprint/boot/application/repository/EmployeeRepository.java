package com.sprint.boot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint.boot.application.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	@Query(value = "SELECT * FROM EMPLOYEE WHERE ID = ?", nativeQuery = true)
	public Employee findSingleRecord(Integer id);

}
