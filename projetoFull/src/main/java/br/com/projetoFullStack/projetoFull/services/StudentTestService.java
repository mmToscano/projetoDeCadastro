package br.com.projetoFullStack.projetoFull.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.StudentTest;
import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.StudentTestRepository;
import br.com.projetoFullStack.projetoFull.services.exceptions.ResourceNotFoundException;

@Service
public class StudentTestService {
	
	@Autowired
	private StudentTestRepository repository;
	
	public List<StudentTest> findAll(){
		return repository.findAll();
	}
	
	public StudentTest findById(Integer id) {
		Optional<StudentTest> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public StudentTest insert(StudentTest test) {
		return repository.save(test);
	}
	
}
