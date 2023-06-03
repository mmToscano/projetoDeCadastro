package com.toscano.university.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class StudentClass implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStudentClass;
	
	@JsonIgnore
	@OneToMany(mappedBy = "studentClass")
	private List<Student> students  = new ArrayList<>();
	
	//@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "studentClass_course_id")
	private Course course;
	
	public StudentClass() {}

	public StudentClass(Integer idStudentClass, Course course) {
		super();
		this.idStudentClass = idStudentClass;
		this.course = course;
	}

	public Integer getIdStudentClass() {
		return idStudentClass;
	}

	public void setIdStudentClass(Integer idStudentClass) {
		this.idStudentClass = idStudentClass;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
