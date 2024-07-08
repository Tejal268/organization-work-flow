package com.example.demop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demop.dao.Maindao;
import com.example.demop.entity.Employee;
import com.example.demop.entity.country;

@Service
public class Mainservice {
	
	@Autowired
	Maindao dao;
	
	public String addcountry(country c)
	{
		
		
		String msg= dao.addcountry(c);
		if(Objects.isNull(msg))
		{
			System.out.println("country not added");
		}
		return msg;
		
		

	}
	
	public String deletecountry(int id) 
	{
		
		 String msg= dao.deletecountry(id);
		 
		 return msg;
	}

	public String updatecountry(country c, int p) 
	{
		
		String m= dao.updatecountry(c,p);
		
		return m;
	}

	public List<country> allcountry() {
		List <country>l=dao.allcountry();
		
		return l;
		
		
		
	}

	public country getparticularcountry(int id) {
		country c= dao.getparticularcountry(id);
		if(Objects.isNull(c))
		{
			c=null;
		}
		
		return c;
	}
	
	

	
	
	
	public String addemployee(Employee emp) {
	
		String msg=dao.addemployee(emp);
		
		if(Objects.isNull(msg))
		{
			System.out.println("Employee is not added");
		}
		return msg;
	}

	public String updateemp(Employee emp) {
		
		String msg=dao.updateemp(emp);
		
		if(Objects.isNull(msg))
		{
			msg="Record is not be updated";
		}
		return msg;
		// TODO Auto-generated method stub
		
	}

	public String deleteemp(int id) 
	{
		String msg=dao.deleteemp(id);
		
		if(Objects.isNull(msg))
		{
			msg="Record is not deleted";
		}
		return null;
	}

	public List<Employee> getallrec() {
		
		List<Employee> l=dao.getallrec();
	
		return l;
	}

	public Employee particularemp(int id) {

		Employee emp=dao.particularemp(id);
		
		if(Objects.isNull(emp))
		{
			emp=null;
			
		}
		
		return emp;
	}

	public List<Employee> getempbystatus(String status) {
		
		List<Employee> l=dao.getempbystatus(status);
		
		if(Objects.isNull(l))
		{
			l=null;
		}
		
		return l;
	}

	public HashMap userlogin(Employee emp)
	{
		Employee e=dao.userlogin(emp);
		
		HashMap map=new HashMap();
		if(Objects.isNull(e))
		{
			map.put("msg"," Invalid user");
			map.put("user",e);
		}
		else {
			map.put("msg"," valid user");
			map.put("user",e);
		}
		return map;
	}

	public List<Employee> salarygreaterthan50000(double price) {
		List<Employee> l=dao.getempbystatus(price);
		
		if(Objects.isNull(l))
		{
			l=null;
		}
		
		return l;
	}
	
	

}
