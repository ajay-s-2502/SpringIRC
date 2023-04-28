package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Pojo;
import com.example.demo.Service.Serve;
import com.example.demo.ValidateModel.PojoLogin;

@RestController
@RequestMapping("/vtsaservice")
public class Control {
	
	public static boolean flag = false;

	@Autowired Serve s;
	
	@PostMapping(" ")
	public String create(@RequestBody Pojo p)
	{
		if(flag)
			return s.addVehicle(p);
		else
			return "Please Login!";
	}
	
	@GetMapping(" ")
	public List<Pojo> read()
	{
		if(flag)
			return s.getVehicle();
		else
			return null;
	}
	
	@GetMapping("/{job_card}")
	public Optional<Pojo> readById(@PathVariable int job_card)
	{
		if(flag)
			return s.getVehicleById(job_card);
		else
			return null;
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Pojo p)
	{
		if(flag)
			return s.updateVehicle(p);
		else
			return "Please Login!";
	}
	
	@DeleteMapping("/delete/{job_card}")
	public String delete(@PathVariable int job_card)
	{
		if(flag)
			return s.deleteByRequestParamId(job_card);
		else
			return "Please Login!";
	}
	
	@GetMapping("/sortasc/{field}")
	public List<Pojo> getSortedAsc(@PathVariable String field)
	{
		if(flag)
			return s.getSortedAsc(field);
		else
			return null;
	}
	
	@GetMapping("/sortdesc/{field}")
	public List<Pojo> getSortedDesc(@PathVariable String field)
	{
		if(flag)
			return s.getSortedDesc(field);
		else
			return null;
	}
	
	@GetMapping("/page/{offset}/{pagesize}")
	public List<Pojo> getPaginate(@PathVariable int offset, @PathVariable int pagesize)
	{
		if(flag)
			return s.getPaginate(offset, pagesize);
		else
			return null;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String,String> mp)
	{
		String uname = mp.get("uname");
		String pass = mp.get("pass");
		String res = s.validate(uname, pass);
		return res;
	}
	
	@PostMapping("/login/newuser")
	public String newUser(@RequestBody PojoLogin pl)
	{
		if(flag)
			return s.newUserAdd(pl);
		else
			return "Please Login!";
	}
	
	@PutMapping("/login/changepwd")
	public String changePwd(@RequestBody PojoLogin pl)
	{
		if(flag)
			return s.changeUserPwd(pl);
		else
			return "Please Login!";
	}
}