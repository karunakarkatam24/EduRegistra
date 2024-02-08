package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.model.Course;

public interface AdminService 
{
     public List<Employee> viewallemployees();
     
     public String deleteemployees(int eid);
     
     public  String addcourse(Course c);
     
     
     public Admin checkadminlogin(String uname,String pwd);

	
	 public Employee viewemployeebyid(int eid);

	public String deletecourse(int eid);

	public List<Course> viewallcourse();
	
}
