package br.com.projetoFullStack.projetoFull.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.repositories.StudentRepository;
import br.com.projetoFullStack.projetoFull.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ClassService classService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	public Student findById(Integer id) {
		Optional<Student> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	@Transactional
	public Student insert(Student student) {
		
		Student obj = createStudent(student);
		System.out.println("Criou");
		
		if(obj.getStudentClass().getCourse().getId() != obj.getCourse().getId()) {
			throw new IllegalArgumentException("the student's class does not match it's course");
		}
		Student newObj = entityManager.merge(obj);
		return repository.save(newObj);
	}
	
	
	public Student createStudent(Student student) {
		Student newStudent = new Student(student.getIdStudent(), student.getStudentName(), student.getBirthDate(), student.getCpf(), student.getAddres(), student.getCampus(), student.getPhone(), student.getDateOfEntry(), student.getStudentStatus(), classService.createClass(student.getStudentClass()), courseService.createCourse(student.getCourse()));
		System.out.println("criou");
		return newStudent;
	}
	
	
	
	
	
	
}
