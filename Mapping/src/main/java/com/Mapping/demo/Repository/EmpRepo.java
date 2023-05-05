package com.Mapping.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mapping.demo.Model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

	List<Employee> getAllEmployees();

}
