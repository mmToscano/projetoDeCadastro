package br.com.projetoFullStack.projetoFull.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Class")
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClass;
	
	@JsonIgnore
	@OneToMany(mappedBy = "studentClass")
	private Set<Student> students = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "class_course_id")
	private Course course;
	
	public Class() {}

	public Class(Integer idClass, Course course) {
		super();
		this.idClass = idClass;
		this.course = course;
	}

	public Integer getIdClass() {
		return idClass;
	}

	public void setIdClass(Integer idClass) {
		this.idClass = idClass;
	}

	public Set<Student> getStudents() {
		return students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClass == null) ? 0 : idClass.hashCode());
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
		Class other = (Class) obj;
		if (idClass == null) {
			if (other.idClass != null)
				return false;
		} else if (!idClass.equals(other.idClass))
			return false;
		return true;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	

}
