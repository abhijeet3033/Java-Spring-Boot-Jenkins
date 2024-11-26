package com.sprint.boot.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.boot.application.model.Employee;
import com.sprint.boot.application.service.EmployeeServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HomeRestController {

	private static final Logger logger = LoggerFactory.getLogger(HomeRestController.class.getName());

	@Autowired

	private EmployeeServiceImp employeeServiceImp;

	@GetMapping("/homeRestController")
	public String restControllerTest() {
		return "Welcome to homeRestController!!!!! ";
	}

	@GetMapping("/homeRestController/{id}")
	public Employee getSingleRecord(@PathVariable Integer id) {
		return employeeServiceImp.getSingleRecord(id);
	}

}
