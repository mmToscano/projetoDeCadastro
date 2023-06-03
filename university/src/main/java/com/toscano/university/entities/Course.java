package com.toscano.university.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCourse;
	
	private String name;
	
	private Integer workload;
	
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<Student> students  = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<CourseExam> courseExams  = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<StudentClass> studentClasses  = new ArrayList<>();
	
	public Course() {}

	public Course(Integer idCourse, String name, Integer workload) {
		super();
		this.idCourse = idCourse;
		this.name = name;
		this.workload = workload;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWorkload() {
		return workload;
	}

	public void setWorkload(Integer workload) {
		this.workload = workload;
	}

	public List<Student> getStudents() {
		return students;
	}


	public List<CourseExam> getCourseExams() {
		return courseExams;
	}


	public List<StudentClass> getStudentClasses() {
		return studentClasses;
	}

	
	
	

}
