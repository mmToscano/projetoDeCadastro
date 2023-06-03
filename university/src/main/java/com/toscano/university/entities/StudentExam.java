package com.toscano.university.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentExam")
public class StudentExam implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStudentExam;
	
	//@Column(name = "test_date", nullable=false)
	private String studentExamDate;
	
	
	//@Column(name = "student_test_grade", nullable=false)
	private Integer fullGrade;
	

	//@Column(name = "student_test_achieved", nullable=false)
	private Double gradeAcquired;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "studentExam_student_id")
	private Student student;
	
	public StudentExam() {}

	public StudentExam(Integer idStudentExam, String studentExamDate, Integer fullGrade, Double gradeAcquired,
			Student student) {
		super();
		this.idStudentExam = idStudentExam;
		this.studentExamDate = studentExamDate;
		this.fullGrade = fullGrade;
		this.gradeAcquired = gradeAcquired;
		this.student = student;
	}

	public Integer getIdStudentExam() {
		return idStudentExam;
	}

	public void setIdStudentExam(Integer idStudentExam) {
		this.idStudentExam = idStudentExam;
	}

	public String getStudentExamDate() {
		return studentExamDate;
	}

	public void setStudentExamDate(String studentExamDate) {
		this.studentExamDate = studentExamDate;
	}

	public Integer getFullGrade() {
		return fullGrade;
	}

	public void setFullGrade(Integer fullGrade) {
		this.fullGrade = fullGrade;
	}

	public Double getGradeAcquired() {
		return gradeAcquired;
	}

	public void setGradeAcquired(Double gradeAcquired) {
		this.gradeAcquired = gradeAcquired;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
