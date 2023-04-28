package com.example.demo.EmpController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmpModel.Model;
import com.example.demo.EmpRepository.Repository;
import com.example.demo.EmpServices.Services;

@RestController
@RequestMapping("/emp")
public class Controller {

	@Autowired Services s;
	@Autowired Repository r;
	
	@PostMapping(" ")
	public String addEmp(@RequestBody Model m)
	{
		return r.save(m);
	}
	
	@GetMapping(" ")
	public List<Model> getEmp()
	{
		return r.getData();
	}
	
	@GetMapping("/count")
	public long getEmpCount()
	{
		return r.getCount();
	}
	
	@GetMapping("/{name}")
	public List<Model> getEmpByName(@PathVariable String name)
	{
		return r.findByName(name);
	}
	
	@GetMapping("/status/{name}/{status}")
	public List<Model> getAllEmp(@PathVariable String name, @PathVariable String status)
	{
		return r.findByStatus(name, status);
	}
}
