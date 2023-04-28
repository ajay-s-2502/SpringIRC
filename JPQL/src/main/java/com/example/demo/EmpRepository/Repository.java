package com.example.demo.EmpRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.EmpModel.Model;

public interface Repository extends JpaRepository<Model, Integer>{

	List<Model> findByName(String name);

	
	

	
}
