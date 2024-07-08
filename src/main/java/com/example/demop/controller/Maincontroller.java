package com.example.demop.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demop.entity.Employee;
import com.example.demop.entity.country;
import com.example.demop.service.Mainservice;

@CrossOrigin //for sharing API to frontend developer
@RestController
@RequestMapping("api")
public class Maincontroller {
 
	@Autowired
	Mainservice service;
	
	//country curd operations
	@PostMapping("addcountry")
	public String addcountry(@RequestBody country c) {
	
	String s= service.addcountry(c);
	
	return s;
		

	}
	
	@DeleteMapping("deletecountry/{id}")
	public String deletecountry(@PathVariable int id)
	{
		
	  String m=	service.deletecountry(id);
	  return m;

	}
	
	@PutMapping("updatecountry/{p}")
	public String updatecountry(@RequestBody country c, @PathVariable int p)
	{
	 String s=	service.updatecountry(c,p);
	 return s;
	}
	
	@GetMapping("allcountry")
	public List<country> allcountry() 
	{
	
		List<country> l=service.allcountry();
		
		return l;
	}
	
	@GetMapping("getparticularcountry/{id}")
	public country getparticularcountry (@PathVariable int id) 
	{
		country c= service.getparticularcountry(id);
		
		return c;
	}
	
	//Employee curd operations 
	
	
	@PostMapping("addemp")
	public String addemployee(@RequestBody Employee emp)
	{
		String msg=service.addemployee(emp);
		
		return msg;
	}
	
	@PutMapping("updateemp")
	public String updateemp(@RequestBody Employee emp) {
		// TODO Auto-generated method stub
		
	String msg=	service.updateemp(emp);
	return msg;

	}
	
	@DeleteMapping("deleteemp/{id}")
	public String deleteemp(@PathVariable int id)
	{
		String msg=service.deleteemp(id);
		
		return msg;
	}
	
	
	@GetMapping("getallemp")
	public List<Employee> getallrec()
	{
		List<Employee> l=service.getallrec();
		
		return l;
	}
	
	@GetMapping("particularemp")
	public Employee particularemp(@RequestParam int id)
	{
		Employee emp=service.particularemp(id);
		
		return emp;
	}
	
	@GetMapping("getempbystatus/{status}")
	public List<Employee> getempbystatus(@PathVariable String status)
	{
		List<Employee> l=service.getempbystatus(status);
		
		return l;
	}
	
	
	@PostMapping("userlogin")
	public HashMap userlogin(@RequestBody Employee emp)
	{
		HashMap  map= service.userlogin(emp);
		
		return map;
	}
	
	
	
	
		@GetMapping("salarygreaterthan50000/{price}")
		public List<Employee> salarygreaterthan50000(@PathVariable int price)
		{
			List<Employee> l=service.salarygreaterthan50000(price);
			
			return l;
		
	}

}
