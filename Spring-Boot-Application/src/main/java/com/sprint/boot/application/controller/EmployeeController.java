package com.sprint.boot.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sprint.boot.application.model.Employee;
import com.sprint.boot.application.service.EmployeeServiceImp;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeServiceImp employeeService;

	@Autowired
	private RestTemplate restTemplate;

	// Test URI
	@GetMapping("/welcome")
	public String welcome() {
		logger.info("Welcome Spring Boot Application.....");
		return "Welcome Spring Boot Application.....";
	}

	// Consumed Test URI
	@GetMapping("/consumedWelcome")
	public String consumeAPI() {
		String uri = "http://localhost:8091/welcome";
		String str = restTemplate.getForObject(uri, String.class);
		logger.info("consumed API.....");
		return str;
	}

	// POST URI
	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping("/employee")
	public Employee saveDetails(@RequestBody Employee employee) {
		logger.info("Entry com.sprint.boot.application.controller.EmployeeController.saveDetails");
		logger.info("calling service layer...");
		return employeeService.saveEmployeeDetails(employee);
	}

	// Consumed POST URI
	@PostMapping("/consumedEmployee")
	public Employee consumedSaveDetails(@RequestBody Employee employee) {
		String uri = "http://localhost:8091/employee";
		return restTemplate.postForObject(uri, employee, Employee.class);
	}

	// GET by ID URI
	@GetMapping("/singleEmployee/{id}")
	public String getSingleDetail(@PathVariable Integer id) {
		employeeService.getEmployeeSingleDetails(id);
		return "Data Fetched Successfully.....";
	}

	// Consumed GET by ID URI
	@GetMapping("/consumedSingleEmployee/{id}")
	public String consumedGetSingleDetails(@PathVariable Integer id) {
		String uri = "http://localhost:8091/singleEmployee/" + id;
		return restTemplate.getForObject(uri, String.class);
	}

	// GET URI
	@GetMapping("/employee")
	public List<Employee> getAllDataList() {
		return employeeService.getEmployeeDetailsList();
	}

	// Consumed GET URI
	@GetMapping("/consumedEmployee")
	public List<Employee> consumedGetAllDataList() {
		String uri = "http://localhost:8091/employee";
		List list = restTemplate.getForObject(uri, List.class);
		return list;
	}

	// PUT URI
	@PutMapping("/employeeUpdate/{id}")
	public Employee updateEmployeeDetails(@PathVariable Integer id, @RequestBody Employee employee) {
		return employeeService.updateEmployeedetails(employee, id);
	}

	// Consumed PUT URI
	@PutMapping("/consumedEmployee/{id}")
	public String consumedUpdateEmployeeDetails(@PathVariable Integer id, @RequestBody Employee employee) {
		String uri = "http://localhost:8091/employeeUpdate/" + id;
		restTemplate.put(uri, employee, id);
		return "Updated Successfully.....";
	}

	// DELETE URI
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteRecord(@PathVariable Integer id) {
		employeeService.deleteEmployeedetail(id);
		return "Delete Successfully.....";
	}

	// Consumed DELETE URI
	@DeleteMapping("/consumedEmployee/{id}")
	public String consumedDeleteRecord(@PathVariable Integer id) {
		String uri = "http://localhost:8091/deleteEmployee/" + id;
		restTemplate.delete(uri, String.class);
		return "Successfully Deleted.....";
	}
}
