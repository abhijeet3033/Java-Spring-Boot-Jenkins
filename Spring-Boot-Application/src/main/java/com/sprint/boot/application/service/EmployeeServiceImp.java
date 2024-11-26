package com.sprint.boot.application.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.boot.application.model.Employee;
import com.sprint.boot.application.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class.getName());

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		logger.info("Entry com.sprint.boot.application.service.EmployeeServiceImp.saveEmployeeDetails");
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public void getEmployeeSingleDetails(Integer id) {
		employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getEmployeeDetailsList() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployeedetails(Employee employee, Integer id) {

		Employee emp = employeeRepository.findById(id).get();

		if (Objects.nonNull(employee.getFirstname()) && !"".equalsIgnoreCase(employee.getFirstname())) {
			emp.setFirstname(employee.getFirstname());
		}
		if (Objects.nonNull(employee.getLastname()) && !"".equalsIgnoreCase(employee.getLastname())) {
			emp.setLastname(employee.getLastname());
		}
		if (Objects.nonNull(employee.getAddress()) && !"".equalsIgnoreCase(employee.getAddress())) {
			emp.setAddress(employee.getAddress());
		}
		if (Objects.nonNull(employee.getCity()) && !"".equalsIgnoreCase(employee.getCity())) {
			emp.setCity(employee.getCity());
		}
		if (Objects.nonNull(employee.getMobile()) && !"".equalsIgnoreCase(employee.getMobile())) {
			emp.setMobile(employee.getMobile());
		}
		if (Objects.nonNull(employee.getUsername()) && !"".equalsIgnoreCase(employee.getUsername())) {
			emp.setUsername(employee.getUsername());
		}
		if (Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword())) {
			emp.setPassword(employee.getPassword());
		}
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployeedetail(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee getSingleRecord(Integer id) {
		return employeeRepository.findSingleRecord(id);
	}

}
