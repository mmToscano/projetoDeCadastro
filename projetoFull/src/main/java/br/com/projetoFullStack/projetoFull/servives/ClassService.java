package br.com.projetoFullStack.projetoFull.servives;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.Class;
import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.ClassRepository;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository repository;
	
	public List<Class> findAll(){
		return repository.findAll();
	}
	
	public Class findById(Integer id) {
		Optional<Class> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Student> findStudentsByIdClass(Integer id) {
		List<Student> studentsList = new ArrayList<>();
		Class classObj = repository.getReferenceById(id);
		
		studentsList.addAll(classObj.getStudents());
		return studentsList;
	}
}
