package com.Mapping.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Mapping.demo.Model.Employee;
import com.Mapping.demo.Repository.EmpDetailsRepo;
import com.Mapping.demo.Repository.EmpRepo;

@Service
public class Services {

	@Autowired
	EmpRepo repo;
	
	@Autowired
	EmpDetailsRepo empdtlrepo;

	public String addData(Employee emp) {
		repo.save(emp);
		return "Added";
	}

	public List<Employee> getAll() {
		
		return repo.getAllEmployees();
	}

	
}
