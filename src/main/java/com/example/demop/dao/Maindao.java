package com.example.demop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demop.entity.Employee;
import com.example.demop.entity.country;




@Repository

public class Maindao 
{
	@Autowired
	SessionFactory factory;

	public String addcountry(country c) {
		
		Session session=null;
	  Transaction tx=null;
	  String msg=null;
	  
	  try {
		  session=factory.openSession();
		  tx=session.beginTransaction();
		  session.persist(c);
		  tx.commit();
		  msg="country added";
		  
	  }catch (Exception e) {
		  if(tx!=null)
		  {
			  tx.rollback();
		  }
		  e.printStackTrace();
		
	}finally {
		if(session!=null) {
			session.close();
		}
	}
		
		return msg;
		}

	public String deletecountry(int id) {
		
		Session s=factory.openSession();
	    s.beginTransaction();
	    
	    
		country c1=s.get(country.class, id);
		s.remove(c1);
		
		s.getTransaction().commit();
		s.close();
		
		return "country delete";
	}

	public String updatecountry(country c,int  p)
	{

		Session s=factory.openSession();
	    s.beginTransaction();
	    
	    country c1=s.get(country.class, p);
	    
	    c1.setCname(c.getCname());
	    s.merge(c1);
		
	    s.getTransaction().commit();
		s.close();
		
		return "country updated";
	}

	public List<country> allcountry() {
		
		
		String hqlQuery="From country";
		
		Session s=factory.openSession();
	    s.beginTransaction();
	    
	    Query<country> q=s.createQuery(hqlQuery,country.class);
	    List<country>li=q.list();
	    
	    s.getTransaction().commit();
		s.close();
		
		return li;
	    
	}

	public country getparticularcountry(int id) {

		Session ses=null;
	  Transaction tx=null;
	  country c1=null;
	  //String msg=null;
	  try {
			ses=factory.openSession();
			tx=ses.beginTransaction();
			
			c1=ses.get(country.class, id);
			tx.commit();
			
		}
		catch (Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}	
		finally {
			ses.close();
		}
		
		return c1;
	}

	public String addemployee(Employee emp) {
	
		Session ses=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			ses=factory.openSession();
			tx=ses.beginTransaction();
			
			ses.persist(emp);
			
			tx.commit();
			
			msg="Employee addes successfully";
		}
		catch (Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}	
		finally {
			ses.close();
		}
		
		return msg;
	}

	public String updateemp(Employee emp) {
		Session s=null;
		Transaction tx=null;
		String msg=null;

		try {
			s=factory.openSession();
			tx=s.beginTransaction();
			
			Employee e1=s.get(Employee.class,emp.getId());
			
			e1.setName(emp.getName());
			e1.setCountry(emp.getCountry());
			e1.setCreatedby(emp.getCreatedby());
			e1.setCreateddtm(emp.getCreateddtm());
			e1.setUpdatedby(emp.getUpdatedby());
			e1.setUpdateddtm(emp.getUpdateddtm());
			e1.setDept(emp.getDept());
			e1.setEmailid(emp.getEmailid());
			e1.setStatus(emp.getStatus());
			e1.setSalary(emp.getSalary());
			e1.setPhoneno(emp.getPhoneno());
			
			s.merge(e1);
			
			tx.commit();
			
			msg="Employee updated successfully";
			
		} catch (Exception e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(s!=null)
			{
				s.close();
			}
		}
		return msg;
	}

	public String deleteemp(int id) {
		
		Session s=null;
		Transaction tx=null;
		String msg=null;

		try {
			s=factory.openSession();
			tx=s.beginTransaction();
			
			Employee em=s.get(Employee.class, id);
			
			s.remove(em);
			
			s.getTransaction().commit();
			s.close();
			
			msg="record deleted";
		}
		catch (Exception e) {
			if(tx!=null)
			{
				
				tx.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			if(s!=null)
			{
				s.close();
			}
		}
		
		
		return msg;
	}

	public List<Employee> getallrec() {
		String hqlQuery="From Employee";
		
		Session s=factory.openSession();
	    s.beginTransaction();
	    
	    Query<Employee> q=s.createQuery(hqlQuery,Employee.class);
	    List<Employee>li=q.list();
	    
	    s.getTransaction().commit();
		s.close();
		
		return li;
		
		
	}

	public Employee particularemp(int id) {
		Session s=null;
		Transaction t=null;
		Employee em=null;
		
		try {
			
			s=factory.openSession();
			s.beginTransaction();
			
			em=s.get(Employee.class, id);
			
			t.commit();
			
		} catch (Exception e) {
			
			if(t!=null)
			{
				t.rollback();
			}
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		return em;
	}

	public List<Employee> getempbystatus(String status) {
		Session s=null;
		Transaction t=null;
		Query<Employee> q;
		List<Employee>li=null;
		String hqlQuery="From Employee where status=:mystatus";
		try {
			
			
			
			s=factory.openSession();
			s.beginTransaction();
			
			q=s.createQuery(hqlQuery,Employee.class);
			
			q.setParameter("mystatus",status);
		    li=q.list();
			
			t.commit();
			
		} catch (Exception e) {
			
			if(t!=null)
			{
				t.rollback();
			}
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		return li;
		 
	
	}

	public Employee userlogin(Employee emp) {
		
		Session s=null;
		Transaction t=null;
		Query<Employee> q;
		//List<Employee>li=null;
		Employee em1=null;
		String hqlQuery="From Employee where phoneno=:mynumber and emailid=:myid";
		try {
			
			
			
			s=factory.openSession();
			s.beginTransaction();
			
			q=s.createQuery(hqlQuery,Employee.class);
			
			q.setParameter("mynumber",emp.getPhoneno());
			q.setParameter("myid", emp.getEmailid());
			em1=q.uniqueResult();
			
			
			t.commit();
			
		} catch (Exception e) {
			
			if(t!=null)
			{
				t.rollback();
			}
			e.printStackTrace();
		}
		finally {
			s.close();
		}
	
		
		return em1;
	}

	public List<Employee> getempbystatus(double price) {
		Session s=null;
		Transaction t=null;
		Query<Employee> q;
		List<Employee>li=null;
		String hqlQuery="From Employee where salary >: price";
		try {
			
			
			
			s=factory.openSession();
			s.beginTransaction();
			
			q=s.createQuery(hqlQuery,Employee.class);
			
			q.setParameter("price",price);
		    li=q.list();
			
			t.commit();
			
		} catch (Exception e) {
			
			if(t!=null)
			{
				t.rollback();
			}
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		return li;
	}
	

	
}
