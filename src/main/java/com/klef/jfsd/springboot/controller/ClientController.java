package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Course;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.service.AdminService;

import com.klef.jfsd.springboot.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{
	    @Autowired
		private AdminService adminService;
		
	    @Autowired
		private EmployeeService employeeService;
	    
	    @GetMapping("/")
	    public String main()
	    {
	    	return "index";
	    }
	    
	    @GetMapping("empreg")
	    public ModelAndView empreg()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("empreg");
	      return mv;
	    }
	   
	    
	    
	    
	    @PostMapping("insertemp")
	    public ModelAndView insert(HttpServletRequest request)
	    {
	    	ModelAndView mv = new ModelAndView();
	    	
	    	String msg = null;
	    	
	    	try 
	    	{
	    		String name = request.getParameter("name");
	    		String gender = request.getParameter("gender");
	    		String dob = request.getParameter("dob");
	    		String dept = request.getParameter("dept");
	    		String sal = request.getParameter("salary");
	    		double salary = Double.parseDouble(sal);
	    		String email = request.getParameter("email");
	    		String pwd = request.getParameter("pwd");
	    		String location = request.getParameter("location");
	    		String contact = request.getParameter("contact");
	    		
	    		Employee emp = new Employee();
	    		
	    		emp.setName(name);
	    		emp.setGender(gender);
	    		emp.setDateofbirth(dob);
	    		emp.setDepartment(dept);
	    		emp.setSalary(salary);
	    		emp.setEmail(email);
	    		emp.setPassword(pwd);
	    		emp.setLocation(location);
	    		emp.setContact(contact);
	    		emp.setActive(true);
	    		
	    	msg = 	employeeService.addemployee(emp);
	    	
	    	mv.setViewName("displaymsg");
	    	mv.addObject("message", msg);
	    	
	    	}
	    	catch (Exception e) 
	    	{
				 msg = e.getMessage();
				 
				 mv.setViewName("displayerror");
				 mv.addObject("message", msg);
			}
	    	
	    	return mv;
	    }
	    
	    @GetMapping("addcourse")
	    public ModelAndView addcourse()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("addcourse");
	      return mv;
	    }
	   
	    @PostMapping("insertcourse")
	    public ModelAndView add(HttpServletRequest request)
	    {
	    	ModelAndView mv = new ModelAndView();
	    	
	    	String msg = null;
	    	
	    	try 
	    	{
	    		String coursename = request.getParameter("courseName");
	    		String coursecode = request.getParameter("courseCode");
	    		String facultyname = request.getParameter("facultyName");
	    		
	    		Course course = new Course();
	    		
	    		course.setCoursename(coursename);
	    		course.setCoursecode(coursecode);
	    		course.setFacultyename(facultyname);
	    		
	    		course.setActive(true);
	    		
	    	msg = 	adminService.addcourse(course);
	    	
	    	mv.setViewName("displaymsg");
	    	mv.addObject("message", msg);
	    	
	    	}
	    	catch (Exception e) 
	    	{
				 msg = e.getMessage();
				 
				 mv.setViewName("displayerror");
				 mv.addObject("message", msg);
			}
	    	
	    	return mv;
	    }
	    
	    
	    
	    
	    @GetMapping("emplogin") // URI & method name can be different
	    public ModelAndView emplogin()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("emplogin");
	      return mv;
	    }
	    
	    
	    @PostMapping("checkemplogin")
	    public ModelAndView checkemplogin(HttpServletRequest request)
	    {
	      ModelAndView mv = new ModelAndView();
	      
	      String email = request.getParameter("email");
	      String pwd = request.getParameter("pwd");
	      
	        Employee emp = employeeService.checkemplogin(email, pwd);
	        
	        if(emp!=null)
	        {
	        	// session
	        	
	        	HttpSession session  = request.getSession();
	        	
	        	session.setAttribute("eid", emp.getId());// eid is a session variable
	        	session.setAttribute("ename", emp.getName()); // ename is a session variable
	        	
	        	// session
	          
	          mv.setViewName("emphome");
	        }
	        else
	        {
	          mv.setViewName("emplogin");
	          mv.addObject("message", "Login Failed");
	        }
	        
	        return mv;
	    }
	    
	    @GetMapping("emphome")
	    public ModelAndView emphome(HttpServletRequest request)
	    {
        	HttpSession session  = request.getSession();
        		
        	int eid = (int)  session.getAttribute("eid"); // eid is a session variable
        	String ename = (String) session.getAttribute("ename"); // ename is a session variable
	    	
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("emphome");
	      
	      mv.addObject("eid", eid);
	      mv.addObject("ename", ename);
	      
	      return mv;
	    }
	    
	    @GetMapping("adminlogin")
	    public ModelAndView adminlogin()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("adminlogin");
	      return mv;
	    }
	    
	    @PostMapping("checkadminlogin")
	    public ModelAndView checkadminlogin(HttpServletRequest request)
	    {
	    	ModelAndView mv = new ModelAndView();
	    	
	    	String uname = request.getParameter("uname");
	    	String pwd = request.getParameter("pwd");
	    	
	    Admin a = adminService.checkadminlogin(uname, pwd);
	    
	    if(a != null)
	    {
	    	mv.setViewName("adminhome");
	    }
	    else
	    {
	    	mv.setViewName("adminlogin");
	    	mv.addObject("message", "Login Failed");
	    }
	    return mv;
	    
	    }
	    
	    @GetMapping("viewallemps")
	    public ModelAndView viewallemps()
	    {
	    	ModelAndView mv = new ModelAndView();
	    	mv.setViewName("viewallemps");
	    	
	    	List<Employee> emplist = adminService.viewallemployees();
	    	
	    	mv.addObject("empdata", emplist);
	    	
	    	return mv;
	    }
	    @GetMapping("viewallcourse")
	    public ModelAndView viewallcourse()
	    {
	    	ModelAndView mv = new ModelAndView();
	    	mv.setViewName("viewallcourse");
	    	
	    	List<Course> emplist = employeeService.viewallcourse();
	    	
	    	mv.addObject("empdata", emplist);
	    	
	    	return mv;
	    }
	    
	    
	    @GetMapping("adminhome")
	    public ModelAndView adminhome()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("adminhome");
	      return mv;
	    }
	    
	    @GetMapping("deleteemp")
	    public ModelAndView deleteemp()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("deleteemp");
	      
	      List<Employee> emplist =  adminService.viewallemployees();
	      
	      mv.addObject("empdata", emplist);
	      
	      return mv;
	    }
	    @GetMapping("deletecourse")
	    public ModelAndView deletecourse()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("deletecourse");
	      
	      List<Course> emplist =  adminService.viewallcourse();
	      
	      mv.addObject("empdata", emplist);
	      
	      return mv;
	    }
	    
	    
	    @GetMapping("view")
	    public ModelAndView viewempdemo(@RequestParam("id") int eid)
	    {
	      Employee emp = adminService.viewemployeebyid(eid);
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("viewempbyid");
	      mv.addObject("emp", emp);
	      return mv;
	    }
	    
	    
	    
	    @GetMapping("delete/{id}")
	    public String deleteaction(@PathVariable("id") int eid)
	    {
	      adminService.deleteemployees(eid);
	      return "redirect:/viewallemps";
	    }
	    
	    @GetMapping("deletecourse/{id}")
	    public String delete(@PathVariable("id") int eid)
	    {
	      adminService.deletecourse(eid);
	      return "redirect:/deletecourse";
	    }
	    
	    @GetMapping("updateprofile")
	    public ModelAndView updateemp(HttpServletRequest request)
	    {
	      ModelAndView mv = new ModelAndView();
	      
	      HttpSession session = request.getSession();
	      
	      mv.setViewName("updateprofile");
	      
	      mv.addObject("eid", session.getAttribute("eid"));
	      mv.addObject("ename", session.getAttribute("ename"));
	      
	      int id = (int) session.getAttribute("eid");
	      
	      Employee emp = employeeService.viewempbyid(id);
	      
	      mv.addObject("emp", emp);
	      
	      return mv;
	    }
	    
	    @PostMapping("update")
	    public ModelAndView updateaction(HttpServletRequest request)
	    {
	      String msg = null;
	      
	      ModelAndView mv = new ModelAndView();
	      
	        HttpSession session = request.getSession();
	      
	      mv.addObject("eid", session.getAttribute("eid"));
	      mv.addObject("ename", session.getAttribute("ename"));
	      
	      int id = (int) session.getAttribute("eid");
	      
	     try
	     {
	       String name = request.getParameter("name");
	       String dob = request.getParameter("dob");
	       String dept = request.getParameter("dept");
	       String sal = request.getParameter("salary");
	       double salary = Double.parseDouble(sal);
	       String email = request.getParameter("email");
	       String pwd = request.getParameter("pwd");
	       String location = request.getParameter("location");
	       String contact = request.getParameter("contact");
	       
	       Employee emp = new Employee();
	        emp.setId(id);
	        emp.setName(name);
	        emp.setDateofbirth(dob);
	        emp.setDepartment(dept);
	        emp.setSalary(salary);
	        emp.setEmail(email);
	        emp.setPassword(pwd);
	        emp.setLocation(location);
	        emp.setContact(contact);
	        
	        
	        msg = employeeService.updateemployee(emp);
	        
	        mv.setViewName("emplogin");
	        mv.addObject("message",msg);
	       
	     }
	     catch(Exception e)
	     {
	       msg = e.getMessage();
	       
	       mv.setViewName("updateerror");
	        mv.addObject("message",msg);
	     }
	      
	     
	      return mv;

	    }
	    
}