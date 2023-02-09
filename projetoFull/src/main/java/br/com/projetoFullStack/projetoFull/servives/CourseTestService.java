package br.com.projetoFullStack.projetoFull.servives;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.CourseTest;
import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.CourseTestRepository;

@Service
public class CourseTestService {
	
	@Autowired
	private CourseTestRepository repository;
	
	public List<CourseTest> findAll(){
		return repository.findAll();
	}
	
	public CourseTest findById(Integer id) {
		Optional<CourseTest> obj = repository.findById(id);
		return obj.get();
	}
	
}
