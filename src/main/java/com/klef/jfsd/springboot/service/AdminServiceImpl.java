package com.klef.jfsd.springboot.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Course;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CourseRepository;
import com.klef.jfsd.springboot.repository.EmployeeRepository;

@Service
public class AdminServiceImpl implements AdminService
{
        @Autowired	
        private AdminRepository adminRepository;
        
        @Autowired
        private EmployeeRepository employeeRepository;
      @Autowired
      private CourseRepository courseRepository;
        
	@Override
	public List<Employee> viewallemployees() 
	{
		return employeeRepository.findAll();
	}
    
	

	@Override
	public String deleteemployees(int eid) 
	{
		Optional<Employee> obj =  employeeRepository.findById(eid);//optional is a container of object
        
        String msg = null;
        
        if(obj.isPresent())
        {
          Employee emp = obj.get();
          
          employeeRepository.delete(emp);
          
          msg = "Employee Deleted Successfully";
        }
        else
        {
          msg = "Employee Not Found";
        }
        
        return msg;
	}

	@Override
	public Employee viewemployeebyid(int eid) 
	{
		Optional<Employee> obj =  employeeRepository.findById(eid);
        
        if(obj.isPresent())
        {
          Employee emp = obj.get();
          
          return emp;
        }
        else
        {
          return null;
        }
	}

	@Override
	public Admin checkadminlogin(String uname, String pwd) 
	{
		
		return adminRepository.checkadminlogin(uname, pwd);
	}






	



	@Override
	public String addcourse(Course c) {
		// TODO Auto-generated method stub
		courseRepository.save(c);
		
		return null;
	}



	@Override
	public String deletecourse(int eid) {

		Optional<Course> obj =  courseRepository.findById(eid);//optional is a container of object
        
        String msg = null;
        
        if(obj.isPresent())
        {
          Course course = obj.get();
          
          courseRepository.delete(course);
          
          msg = "Course Deleted Successfully";
        }
        else
        {
          msg = "Employee Not Found";
        }
        
        return msg;
	}



	@Override
	public List<Course> viewallcourse() {
		return courseRepository.findAll();
		
	}
     
}
