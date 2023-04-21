package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest
{
	@Value("${text}")private String msg;
	
	@Value("${id}")private String id;
	
	@GetMapping("/sampleurl")
	
	public String print()
	{
		return msg+" "+id;
	}
}