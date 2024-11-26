package com.sprint.boot.application.service;

import java.util.List;

import com.sprint.boot.application.model.Employee;

public interface EmployeeService {
	
	//Save 
	Employee saveEmployeeDetails(Employee employee);
	
	//Get All
	List<Employee> getEmployeeDetailsList();
	
	//Get Single Value
	void getEmployeeSingleDetails(Integer id);
	
	//Update
	Employee updateEmployeedetails(Employee employee, Integer id);
	
	//delete
	void deleteEmployeedetail(Integer id);
	
	//Single Record
	Employee getSingleRecord(Integer id);
	
	

}
