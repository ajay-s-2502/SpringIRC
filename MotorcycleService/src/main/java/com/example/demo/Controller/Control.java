package com.example.demo.Controller;

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

import com.example.demo.Model.Pojo;
import com.example.demo.Service.Serve;

@RestController
@RequestMapping("/MS")
public class Control {
	@Autowired Serve s;
	@PostMapping(" ")
	public String create(@RequestBody Pojo p)
	{
		return s.addVehicle(p);
	}
	@GetMapping(" ")
	public List<Pojo> read()
	{
		return s.getVehicle();
	}
	@GetMapping("/{job_card}")
	public Optional<Pojo> readById(@PathVariable int job_card)
	{
		return s.getVehicleById(job_card);
	}
	@PutMapping("/update")
	public String update(@RequestBody Pojo p)
	{
		return s.updateVehicle(p);
	}
	@DeleteMapping("/delete")
	public String delete(@RequestParam ("JCid") int job_card)
	{
		return s.deleteByRequestParamId(job_card);
	}
}