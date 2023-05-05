package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Services.EmployeeService;
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/savePerson")
	public Employee savePerson(@RequestBody Employee emp)
	{
	
		return service.saveEmployee(emp);
		
		
	}
	@GetMapping("/getAllPersons")	
	public List<Employee> getAllEmployee()
	{
	
		return service.getAllEmployees();
	}

}
