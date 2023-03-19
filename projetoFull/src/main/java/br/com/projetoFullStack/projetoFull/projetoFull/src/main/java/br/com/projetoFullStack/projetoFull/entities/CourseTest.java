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
@Table(name = "coursetest")
public class CourseTest{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCourseTest;
	
	@Column(name = "course_test_name", nullable=false)
	private String testName;
	
	@Column(name = "course_test_grade", nullable=false)
	private Double fullGrade;
	
	@Column(name = "test_type")
	private String testType;
	
	

	@Column(name = "course_test_creation_day", nullable=false)
	private String courseTestCreationDay;
	
	
	@ManyToOne
	@JoinColumn(name="course_test_course_id")
	private Course course;

	public CourseTest() {}
	
	

	public CourseTest(Integer idCourseTest, String testName, Double fullGrade, String testType, String courseTestCreationDay,
			Course course) {
		super();
		this.idCourseTest = idCourseTest;
		this.testName = testName;
		this.fullGrade = fullGrade;
		this.testType = testType;
		this.courseTestCreationDay = courseTestCreationDay;
		this.course = course;
	}



	public Integer getIdCourseTest() {
		return idCourseTest;
	}



	public void setIdCourseTest(Integer idCourseTest) {
		this.idCourseTest = idCourseTest;
	}



	public String getTestName() {
		return testName;
	}



	public void setTestName(String testName) {
		this.testName = testName;
	}



	public Double getFullGrade() {
		return fullGrade;
	}



	public void setFullGrade(Double fullGrade) {
		this.fullGrade = fullGrade;
	}
	
	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}



	public String getCourseTestCreationDay() {
		return courseTestCreationDay;
	}



	public void setCourseTestCreationDay(String courseTestCreationDay) {
		this.courseTestCreationDay = courseTestCreationDay;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCourseTest == null) ? 0 : idCourseTest.hashCode());
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
		CourseTest other = (CourseTest) obj;
		if (idCourseTest == null) {
			if (other.idCourseTest != null)
				return false;
		} else if (!idCourseTest.equals(other.idCourseTest))
			return false;
		return true;
	}

	

	

	
	
	
	
	

}
