package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_table")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column(name="course_name",nullable=false,length = 50)
	private String coursename;
	@Column(name="course_code",nullable=false,length = 50)
	private String coursecode;
	@Column(name="course_faculty",nullable=false,unique = true,length = 50)
	private String facultyename;
	@Column(name="course_active",nullable=false)
	private boolean active; // true or false
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getFacultyename() {
		return facultyename;
	}
	public void setFacultyename(String facultyename) {
		this.facultyename = facultyename;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", coursename=" + coursename + ", coursecode=" + coursecode + ", facultyname=" + facultyename + "]";
	}
	
}

