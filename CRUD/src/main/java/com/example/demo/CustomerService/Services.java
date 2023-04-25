package com.example.demo.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CustomerDetails.Details;
import com.example.demo.CustomerRepository.Repository;

@Service
public class Services{
	@Autowired
	Repository repo;
	public String addCustomer(Details customer)
	{
		repo.save(customer);
		return "Added Successfully";
	}
	public List<Details> getCustomer()
	{
		return repo.findAll();
	}
	public Optional<Details> getCustomerById(int id)
	{
		return repo.findById(id);
	}
	public String updateCustomer(Details customer)
	{
		repo.save(customer);
		return "Updated successfully";
	}
	public String deleteByRequestParamId(int id)
	{
		repo.deleteById(id);
		return "Deleted successfully";
	}
}
