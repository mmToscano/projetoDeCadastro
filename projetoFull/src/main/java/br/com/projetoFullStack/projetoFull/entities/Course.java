package br.com.projetoFullStack.projetoFull.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCourse;
	
	@Column(name = "course_name", length = 30, nullable = true)
	private String courseName;
	
	private Integer workload;
	
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private Set<Class> classes = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private Set<Student> students = new HashSet<>();
	
	public Course() {}

	public Course(Integer id, String courseName, Integer workload) {
		super();
		this.idCourse = id;
		this.courseName = courseName;
		this.workload = workload;
	}

	public Integer getId() {
		return idCourse;
	}

	public void setId(Integer id) {
		this.idCourse = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getWorkload() {
		return workload;
	}

	public void setWorkload(Integer workload) {
		this.workload = workload;
	}

	public Set<Class> getClasses() {
		return classes;
	}


	public Set<Student> getStudents() {
		return students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
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
		Course other = (Course) obj;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		return true;
	}

	
	

}
