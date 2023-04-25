package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Pojo;
import com.example.demo.Repository.Repo;

@Service
public class Serve {
	@Autowired Repo r;
	public String addVehicle(Pojo p)
	{
		r.save(p);
		return "Added !";
	}
	public List<Pojo> getVehicle()
	{
		return r.findAll();
	}
	public Optional<Pojo> getVehicleById(int job_card)
	{
		return r.findById(job_card);
	}
	public String updateVehicle(Pojo p)
	{
		r.save(p);
		return "Updated !";
	}
	public String deleteByRequestParamId(int job_card)
	{
		r.deleteById(job_card);
		return "Deleted !";
	}
}