package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	AddressRepository addressRepo;
		
		public Employee saveEmployee(Employee emp)
		{
			return empRepo.save(emp);
		}

		public List<Employee> getAllEmployees() {
			
			return empRepo.getAllEmployees();
		}


}
