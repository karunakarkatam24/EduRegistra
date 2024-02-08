package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Course;
import com.klef.jfsd.springboot.model.Employee;

public interface EmployeeService 
{
     public String addemployee(Employee employee);
     public String updateemployee(Employee emp);
     public Employee viewempbyid(int eid);
     public List<Course> viewallcourse();
     
     public Employee checkemplogin(String email,String pwd);
}
