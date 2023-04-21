package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JsonProp
{
	@GetMapping("/get")
	public String getData(@RequestBody Pojo obj)
	{
		return obj.toString();
	}
	@PostMapping("/post")
	public Pojo postData(@RequestBody Pojo obj)
	{
		return obj;
	}
}
