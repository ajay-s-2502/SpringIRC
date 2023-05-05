package com.Mapping.demo.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mapping.demo.Model.Employee;
import com.Mapping.demo.Service.Services;

@RestController
public class EmployeeController {
	
	@Autowired
	Services ser;
	
	@PostMapping("/emp")
	public String addemp(@RequestBody Employee emp)
	{
		return ser.addData(emp);
	}
	@GetMapping("/empl")
	public List<Employee> getAllEmployee()
	{
		return ser.getAll();
	}

}
