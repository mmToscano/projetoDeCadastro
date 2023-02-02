package br.com.projetoFullStack.projetoFull.servives;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	public Student findById(Integer id) {
		Optional<Student> obj = repository.findById(id);
		return obj.get();
	}
}
