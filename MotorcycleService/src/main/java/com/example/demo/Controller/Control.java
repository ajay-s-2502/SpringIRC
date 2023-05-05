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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Pojo;
import com.example.demo.Model.PojoCost;
import com.example.demo.Model.PojoLogin;
import com.example.demo.Repository.RepoCost;
import com.example.demo.Repository.RepoLogin;
import com.example.demo.Service.Serve;

import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;

@RestController
@RequestMapping("/vtsaservice")
public class Control {
	
	public static boolean flag = false;

	@Autowired Serve s;
	
	@Autowired RepoLogin rl;
	
	@Autowired RepoCost rc;
	
	@Operation(summary = "Add New Vehicle")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Vehicle Successfully!"), @ApiResponse(responseCode = "400", description = "Invalid Data"), @ApiResponse(responseCode = "401", description = "Invalid Data")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(value = "/add",  produces = "application/json", consumes = "application/json")
	public String create(@RequestBody Pojo p)
	{
		if(flag)
			return s.addVehicle(p);
		else
			return "Please Login!";
	}
	
	@Operation(summary = "Get all Vehicles")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Vehicles obtained Successfully!"), @ApiResponse(responseCode = "401", description = "Invalid Data"), @ApiResponse(responseCode = "404", description = "Not Found!")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@GetMapping(value = "/view")
	public List<Pojo> read()
	{
		if(flag)
			return s.getVehicle();
		else
			return null;
	}
	
	@Operation(summary = "Get Vehicle By Register Number")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Vehicle obtained Successfully!"), @ApiResponse(responseCode = "401", description = "Invalid Data"), @ApiResponse(responseCode = "404", description = "Not Found!")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@GetMapping(value = "/view/{regnum}",  produces = "application/json")
	public Optional<Pojo> readByNum(@PathVariable String regnum)
	{
		if(flag)
			return s.getVehicleByNum(regnum);
		else
			return null;
	}
	
	@Operation(summary = "Update Vehicle")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Vehicles obtained Successfully!"), @ApiResponse(responseCode = "401", description = "Invalid Data"), @ApiResponse(responseCode = "404", description = "Not Found!")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PutMapping(value = "/update",  produces = "application/json", consumes = "application/json")
	public String update(@RequestBody Pojo p)
	{
		if(flag)
			return s.updateVehicle(p);
		else
			return "Please Login!";
	}
	
	@Operation(summary = "Delete Vehicle By Register Number")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Vehicles obtained Successfully!"), @ApiResponse(responseCode = "401", description = "Invalid Data"), @ApiResponse(responseCode = "404", description = "Not Found!")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@DeleteMapping("/delete/{regnum}")
	public String delete(@PathVariable String regnum)
	{
		if(flag)
			return s.deleteByNum(regnum);
		else
			return "Please Login!";
	}
	
	@Operation(summary = "Ascending Sort Vehicles By Any")
	
	@GetMapping("/sortasc/{field}")
	public List<Pojo> getSortedAsc(@PathVariable String field)
	{
		if(flag)
			return s.getSortedAsc(field);
		else
			return null;
	}
	
	@Operation(summary = "Descending Sort Vehicles By Any")
	
	@GetMapping("/sortdesc/{field}")
	public List<Pojo> getSortedDesc(@PathVariable String field)
	{
		if(flag)
			return s.getSortedDesc(field);
		else
			return null;
	}
	
	@Operation(summary = "Pagination")
	
	@GetMapping("/page/{offset}/{pagesize}")
	public List<Pojo> getPaginate(@PathVariable int offset, @PathVariable int pagesize)
	{
		if(flag)
			return s.getPaginate(offset, pagesize);
		else
			return null;
	}
	
	@Operation(summary = "Login To Continue")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Logged In Successfully!"), @ApiResponse(responseCode = "400", description = "Invalid Data"), @ApiResponse(responseCode = "401", description = "Invalid Data")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String,String> mp)
	{
		String uname = mp.get("uname");
		String pass = mp.get("pass");
		return s.validate(uname, pass);
	}
	
	@Operation(summary = "Sign Up Here")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Logged In Successfully!"), @ApiResponse(responseCode = "400", description = "Invalid Data"), @ApiResponse(responseCode = "401", description = "Invalid Data")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping("/login/newuser")
	public String newUser(@RequestBody PojoLogin pl)
	{
		if(flag)
			return s.newUserAdd(pl);
		else 
			return "Please Login!";
	}
	
	@Operation(summary = "Change Password")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Logged In Successfully!"), @ApiResponse(responseCode = "400", description = "Invalid Data"), @ApiResponse(responseCode = "401", description = "Invalid Data")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PutMapping("/login/changepwd")
	public String changePwd(@RequestBody PojoLogin pl)
	{
		if(flag)
			return s.changeUserPwd(pl);
		else
			return "Please Login!";
	}
	
	@Operation(summary = "Delete User")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Deleted Successfully!"), @ApiResponse(responseCode = "400", description = "Invalid Data"), @ApiResponse(responseCode = "401", description = "Invalid Data")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@DeleteMapping("/delUser/{username}")
	public String delUser(@PathVariable String username)
	{
		if(flag)
		{
			int res = rl.delUser(username);
			if(res > 0)
			{
				return "Deleted Successfully!";
			}
			else
			{
				return "No Record Found!";
			}
		}
		else
		{
			return "Please Login!";
		}
	}
	@Operation(summary = "Cost of Spares")
	@GetMapping("/costtable")
	public List<PojoCost> viewCost()
	{
		if(flag)
			return rc.viewAllCost();
		else
			return null;
	}
	
	@Operation(summary = "To Update Cost")
	@PutMapping("/costupdate/{pid}/{cost}")
	public String updateCost(@PathVariable String pid, @PathVariable int cost)
	{
		if(flag) 
		{	
			int res = rc.updateCost(pid, cost);
			if(res > 0)
			{
				return "Cost Updated!";
			}
			else
			{
				return "Invalid Product";
			}
		}
		else
		{
			return "Please Login!";
		}
	}
}