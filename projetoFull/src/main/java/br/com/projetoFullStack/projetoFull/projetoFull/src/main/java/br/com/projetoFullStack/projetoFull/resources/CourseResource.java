package br.com.projetoFullStack.projetoFull.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projetoFullStack.projetoFull.entities.Course;
import br.com.projetoFullStack.projetoFull.services.CourseService;

@RestController
@RequestMapping(value = "/courses")
public class CourseResource {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	public ResponseEntity<List<Course>> findAll(){
		List list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Course> findById(@PathVariable Integer id){
		Course obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Course> insert (Course course){
		service.insert(course);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(course.getId()).toUri();
		return ResponseEntity.created(uri).body(course);
	}

}
