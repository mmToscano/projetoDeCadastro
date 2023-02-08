package br.com.projetoFullStack.projetoFull.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStudent;
	
	@Column(name = "student_name", length = 40, nullable = true)
	private String studentName;
	
	@Column(name = "birth_date", length = 10, nullable = true)
	private String birthDate;
	
	@Column(name = "cpf", length = 11, nullable = true)
	private String cpf;
	
	@Column(name = "addres", length = 40, nullable = false)
	private String addres;
	
	@Column(name = "campus", length = 30, nullable = false)
	private String campus;
	
	@Column(name = "phone", length = 30, nullable = true)
	private String phone;
	
	@Column(name = "date_of_entry", length = 10, nullable = true)
	private String dateOfEntry;
	
	@Column(name = "student_status", length = 15, nullable = false)
	private String studentStatus;
	
	@ManyToOne
	@JoinColumn(name="student_course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "student_class_id")
	private Class studentClass;
	
	public Student() {}

	public Student(Integer idStudent, String studentName, String birthDate, String cpf, String addres, String campus,
			String phone, String dateOfEntry, String studentStatus, Class studentClass, Course course) {
		super();
		this.idStudent = idStudent;
		this.studentName = studentName;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.addres = addres;
		this.campus = campus;
		this.phone = phone;
		this.dateOfEntry = dateOfEntry;
		this.studentStatus = studentStatus;
		this.studentClass = studentClass;
		this.course = course;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}

	public Class getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Class studentClass) {
		this.studentClass = studentClass;
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
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	

}
