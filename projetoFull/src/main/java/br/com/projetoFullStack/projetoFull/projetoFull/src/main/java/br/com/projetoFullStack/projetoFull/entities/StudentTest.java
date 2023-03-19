package br.com.projetoFullStack.projetoFull.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studenttest")
public class StudentTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStudentTest;
	
	@Column(name = "test_date", nullable=false)
	private String testDate;
	
	@Column(name = "student_test_name", nullable=false)
	private String studentTestName;
	
	@Column(name = "student_test_grade", nullable=false)
	private Double studentTestGrade;
	
	@Column(name="test_type", nullable=false)
	private String testType;
	

	@Column(name = "student_test_achieved", nullable=false)
	private Double studentTestAchieved;
	
	@ManyToOne
	@JoinColumn(name="student_test_student_id")
	private Student student;
	
	public StudentTest() {}

	public StudentTest(Integer idStudentTest, String testDate, String studentTestName, Double studentTestGrade,String testType,
			Double studentTestAchieved, Student student) {
		super();
		this.idStudentTest = idStudentTest;
		this.testDate = testDate;
		this.studentTestName = studentTestName;
		this.studentTestGrade = studentTestGrade;
		this.testType = testType;
		this.studentTestAchieved = studentTestAchieved;
		this.student = student;
	}

	public Integer getIdStudentTest() {
		return idStudentTest;
	}

	public void setIdStudentTest(Integer idStudentTest) {
		this.idStudentTest = idStudentTest;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getStudentTestName() {
		return studentTestName;
	}

	public void setStudentTestName(String studentTestName) {
		this.studentTestName = studentTestName;
	}

	public Double getStudentTestGrade() {
		return studentTestGrade;
	}

	public void setStudentTestGrade(Double studentTestGrade) {
		this.studentTestGrade = studentTestGrade;
	}
	
	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public Double getStudentTestAchieved() {
		return studentTestAchieved;
	}

	public void setStudentTestAchieved(Double studentTestAchieved) {
		this.studentTestAchieved = studentTestAchieved;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStudentTest == null) ? 0 : idStudentTest.hashCode());
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
		StudentTest other = (StudentTest) obj;
		if (idStudentTest == null) {
			if (other.idStudentTest != null)
				return false;
		} else if (!idStudentTest.equals(other.idStudentTest))
			return false;
		return true;
	}
	
	
	

}
