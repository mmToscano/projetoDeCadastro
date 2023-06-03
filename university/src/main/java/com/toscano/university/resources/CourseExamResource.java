package com.toscano.university.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.toscano.university.entities.CourseExam;
import com.toscano.university.services.CourseExamService;

@RestController
@RequestMapping(value = "/courseExams")
public class CourseExamResource {
	
	@Autowired
	private CourseExamService service;
	
	@GetMapping
	public ResponseEntity<List<CourseExam>> findAll(){
		List list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseExam> findById(@PathVariable int id){
		CourseExam obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<CourseExam> insert(@RequestBody CourseExam obj) {
		//System.out.println("Chegou");
		URI uri = null;
		service.insert(obj);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCourseExam()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
		
	}

}
