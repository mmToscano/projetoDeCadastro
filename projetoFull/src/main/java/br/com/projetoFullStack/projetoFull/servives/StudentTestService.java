package br.com.projetoFullStack.projetoFull.servives;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.StudentTest;
import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.StudentTestRepository;

@Service
public class StudentTestService {
	
	@Autowired
	private StudentTestRepository repository;
	
	public List<StudentTest> findAll(){
		return repository.findAll();
	}
	
	public StudentTest findById(Integer id) {
		Optional<StudentTest> obj = repository.findById(id);
		return obj.get();
	}
	
}
