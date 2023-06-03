package com.toscano.university.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "courseExam")
public class CourseExam implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCourseExam;
	
	private LocalDate courseExamDate;
	
	//@Column(name = "course_test_grade", nullable=false)
	private Integer fullGrade;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "courseExam_course_id")
	private Course course;
	
	public CourseExam() {}


	public CourseExam(Integer idCourseExam, LocalDate courseExamDate, Integer fullGrade, Course course) {
		super();
		this.idCourseExam = idCourseExam;
		this.courseExamDate = courseExamDate;
		this.fullGrade = fullGrade;
		this.course = course;
	}


	public Integer getIdCourseExam() {
		return idCourseExam;
	}


	public void setIdCourseExam(Integer idCourseExam) {
		this.idCourseExam = idCourseExam;
	}


	public LocalDate getCourseExamDate() {
		return courseExamDate;
	}


	public void setCourseExamDate(LocalDate courseExamDate) {
		this.courseExamDate = courseExamDate;
	}


	public Integer getFullGrade() {
		return fullGrade;
	}


	public void setFullGrade(Integer fullGrade) {
		this.fullGrade = fullGrade;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
