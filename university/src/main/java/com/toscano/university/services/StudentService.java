package com.toscano.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toscano.university.entities.Course;
import com.toscano.university.entities.Student;
import com.toscano.university.entities.StudentClass;
import com.toscano.university.repositories.CourseRepository;
import com.toscano.university.repositories.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private CourseService courseService;
	
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	public Student findById(Integer id) {
		Optional<Student> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	@Transactional
	public Student insert(Student student) {
		Course course = courseService.findByName(student.getCourse().getName());
		StudentClass sc = em.find(StudentClass.class, student.getStudentClass().getIdStudentClass());
		
		student.setCourse(course);
		student.setStudentClass(sc);
		em.persist(student);
		
		return repository.save(student);
	}
	
	
}
