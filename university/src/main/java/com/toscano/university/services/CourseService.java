package com.toscano.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toscano.university.entities.Course;
import com.toscano.university.repositories.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll(){
		return repository.findAll();
	}
	
	public Course findById(Integer id) {
		Optional<Course> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public Course insert(Course student) {
		return repository.save(student);
	}
	
	public Course findByName(String name) {
		Course course = null;
		
		for(Course item: findAll()) {
			if(item.getName().equals(name)) {
				course = item;
				break;
			}
		}
		return course;
	}

}
