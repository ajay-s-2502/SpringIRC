package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Details;
import com.example.demo.Repository.Repo;

@Service
public class Services {

	@Autowired Repo r;
	public String addProduct(Details d)
	{
		r.save(d);
		return "Data Added!";
	}
	public List<Details> getProducts()
	{
		return r.findAll();
	}
	//Sorting
	public List<Details> getSorted(String field)
	{
		return r.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	public List<Details> getWithPagination(int offset, int pagesize)
	{
		Page<Details> pg = r.findAll(PageRequest.of(offset, pagesize));
		return pg.getContent();
	}
	public List<Details> getWithPnS(String field, int offset, int pagesize)
	{
		PageRequest pr = PageRequest.of(offset, pagesize, Sort.by(field));
		Page<Details> p = r.findAll(pr);
		return p.getContent();
	}
}
