package br.com.projetoFullStack.projetoFull.servives;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.Course;
import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll(){
		return repository.findAll();
	}
	
	public Course findById(Integer id) {
		Optional<Course> obj = repository.findById(id);
		return obj.get();
	}
	
}
