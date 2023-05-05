package com.Mapping.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mapping.demo.Model.EmployeeDetails;

@Repository
public interface EmpDetailsRepo extends JpaRepository<EmployeeDetails, Integer>{

}
