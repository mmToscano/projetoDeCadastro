package com.toscano.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toscano.university.entities.CourseExam;
import com.toscano.university.repositories.CourseExamRepository;

@Service
public class CourseExamService {
	
	@Autowired
	private CourseExamRepository repository;
	
	public List<CourseExam> findAll(){
		return repository.findAll();
	}
	
	public CourseExam findById(Integer id) {
		Optional<CourseExam> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public CourseExam insert(CourseExam student) {
		return repository.save(student);
	}

}
