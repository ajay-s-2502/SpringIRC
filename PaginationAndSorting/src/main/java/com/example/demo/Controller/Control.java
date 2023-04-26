package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Details;
import com.example.demo.Services.Services;

@RestController
@RequestMapping("/eshopping")
public class Control {

	@Autowired Services s;
	
	@GetMapping(" ")
	public List<Details> read()
	{
		return s.getProducts();
	}
	
	@PostMapping(" ")
	public String create(@RequestBody Details d)
	{
		return s.addProduct(d);	
	}
	
	//Sorting
	@GetMapping("/{field}")
	public List<Details> getProductsSorted(@PathVariable String field)
	{
		return s.getSorted(field);
	}
	
	//Pagination
	@GetMapping("/{offset}/{pagesize}")
	public List<Details> getProductsPagination(@PathVariable int offset, @PathVariable int pagesize)
	{
		return s.getWithPagination(offset, pagesize);
		//offset --> Page Number
		//pagesize -->Number of data in a page
	}
	
	//Sorting and Pagination combined
	@GetMapping("/{field}/{offset}/{pagesize}")
	public List<Details> getProductsWithPnS(@PathVariable String field, @PathVariable int offset, @PathVariable int pagesize)
	{
		return s.getWithPnS(field, offset, pagesize);
	}
}
