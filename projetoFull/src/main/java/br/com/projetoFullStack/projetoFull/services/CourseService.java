package br.com.projetoFullStack.projetoFull.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.Course;
import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.CourseRepository;
import br.com.projetoFullStack.projetoFull.services.exceptions.ResourceNotFoundException;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll(){
		return repository.findAll();
	}
	
	public Course findById(Integer id) {
		Optional<Course> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Course createCourse(Course course) {
		Course newCourse = null;
		List<Course> courseList = findAll();
		
		if(course.getCourseName() != null) {
			for(Course item: courseList) {
				if(item.getCourseName().equalsIgnoreCase(course.getCourseName())) {
					newCourse = new Course(item.getId(), item.getCourseName(), item.getWorkload());
					break;
				}
			}
		}
		return newCourse;
	}
	
}






