package com.example.demo.CustomerController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CustomerDetails.Details;
import com.example.demo.CustomerService.Services;

@RestController
@RequestMapping("/customer")
public class Controller {
	@Autowired
	Services serve;
	@PostMapping(" ")
	public String create(@RequestBody Details customer)
	{
		return serve.addCustomer(customer);
	}
	@GetMapping(" ")
	public List<Details> read()
	{
		return serve.getCustomer();
	}
	@GetMapping("/{id}")
	public Optional<Details> readById(@PathVariable int id)
	{
		return serve.getCustomerById(id);
	}
	@PutMapping("/put")
	public String update(@RequestBody Details customer)
	{
		return serve.updateCustomer(customer);
	}
	@DeleteMapping("/delete")
	public String delete(@RequestParam ("cid") int id)
	{
		return serve.deleteByRequestParamId(id);
	}
}