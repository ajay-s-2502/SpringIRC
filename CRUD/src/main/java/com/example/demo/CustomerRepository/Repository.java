package com.example.demo.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.CustomerDetails.Details;

public interface Repository extends JpaRepository<Details,Integer>
{
	
}