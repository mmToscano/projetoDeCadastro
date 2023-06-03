package com.toscano.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toscano.university.entities.StudentExam;
import com.toscano.university.repositories.StudentExamRepository;

@Service
public class StudentExamService {
	
	@Autowired
	private StudentExamRepository repository;
	
	public List<StudentExam> findAll(){
		return repository.findAll();
	}
	
	public StudentExam findById(Integer id) {
		Optional<StudentExam> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public StudentExam insert(StudentExam student) {
		return repository.save(student);
	}

}
