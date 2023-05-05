package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	@Query(value="SELECT e FROM Employee e  join e.address a ")
	List<Employee> getAllEmployees();

}
