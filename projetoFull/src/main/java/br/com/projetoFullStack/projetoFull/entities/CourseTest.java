package br.com.projetoFullStack.projetoFull.entities;

import br.com.projetoFullStack.projetoFull.entities.classesToBeInherited.Test;
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
public class CourseTest extends Test{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCourseTest;
	
	
	
	@Column(name = "course_test_creation_day", nullable=false)
	private String courseTestCreationDay;
	
	@ManyToOne
	@JoinColumn(name="course_test_course_id")
	private Course course;

	public CourseTest() {}
	
	public CourseTest(String courseTestName, Double courseTestFullGrade, Integer idCourseTest, String courseTestCreationDay,
			Integer courseTestGrade) {
		super();
		this.setFullGrade(courseTestFullGrade);
		this.setName(courseTestName);
		this.idCourseTest = idCourseTest;
		this.courseTestCreationDay = courseTestCreationDay;
	}

	public Integer getIdCourseTest() {
		return idCourseTest;
	}

	public void setIdCourseTest(Integer idCourseTest) {
		this.idCourseTest = idCourseTest;
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
		int result = super.hashCode();
		result = prime * result + ((idCourseTest == null) ? 0 : idCourseTest.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
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
