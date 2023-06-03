package com.toscano.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toscano.university.entities.StudentClass;
import com.toscano.university.repositories.StudentClassRepository;

@Service
public class StudentClassService {
	
	@Autowired
	private StudentClassRepository repository;
	
	public List<StudentClass> findAll(){
		return repository.findAll();
	}
	
	public StudentClass findById(Integer id) {
		Optional<StudentClass> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public StudentClass insert(StudentClass student) {
		return repository.save(student);
	}

}
