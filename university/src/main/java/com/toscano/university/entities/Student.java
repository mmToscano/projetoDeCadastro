package com.toscano.university.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStudent;
	
	private String name;
	
	private LocalDate dateOfBirth;
	
	private String cpf;
	
	
	private String tel;
	
	private LocalDate entryDate;
	
	private String status;
	
	//Foreign keys:
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="student_course_id", nullable=true)
	private Course course;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "student_studentClass_id")
	private StudentClass studentClass;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<StudentExam> exams = new ArrayList<>();
	
	public Student() {}
	


	public Student(Integer idStudent, String name, LocalDate dateOfBirth, String cpf, String tel, LocalDate entryDate,
			String status, Course course, StudentClass studentClass) {
		super();
		this.idStudent = idStudent;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
		this.tel = tel;
		this.entryDate = entryDate;
		this.status = status;
		this.course = course;
		this.studentClass = studentClass;
	}

	




	public Integer getIdStudent() {
		return idStudent;
	}



	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public LocalDate getEntryDate() {
		return entryDate;
	}



	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public StudentClass getStudentClass() {
		return studentClass;
	}



	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}



	public List<StudentExam> getExams() {
		return exams;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStudent == null) ? 0 : idStudent.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (idStudent == null) {
			if (other.idStudent != null)
				return false;
		} else if (!idStudent.equals(other.idStudent))
			return false;
		return true;
	};
	
	
	
}
