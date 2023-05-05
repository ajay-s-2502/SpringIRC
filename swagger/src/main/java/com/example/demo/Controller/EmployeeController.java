package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.DepartmentRepo;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Service.EmployeeRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;


@RestController
public class EmployeeController {

	@Autowired DepartmentRepo dRepo;
	@Autowired EmployeeRepo eRepo;
	
	@Operation(summary = "Creates a new employee")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Employee Created Successfully!"), @ApiResponse(responseCode = "400", description = "Employee is Invalid"), @ApiResponse(responseCode = "401", description = "Invalid Credentials")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(value = "/employee", produces = "application/json", consumes = "application/json")
	public Employee saveEmployee(@RequestBody EmployeeRequest eRequest)
	{
		Department dep = new Department();
		dep.setName(eRequest.getDepartment());
		dep = dRepo.save(dep);
		Employee emp = new Employee();
		emp.setDepartment(dep);
		eRepo.save(emp);
		return emp;
	}
	
	@Operation(summary = "Get all employees")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Getting Employee Successfully!"), @ApiResponse(responseCode = "401", description = "Invalid Credentials"), @ApiResponse(responseCode = "404", description = "Employee not found!")})
	
	@GetMapping(value = "/employee", produces = "application/json")
	public List<Employee> getEmployees()
	{
		return eRepo.findAll();
	}
	
	@GetMapping("/department")
	public List<Department> getDepartment()
	{
		return dRepo.findAll();
	}

}
