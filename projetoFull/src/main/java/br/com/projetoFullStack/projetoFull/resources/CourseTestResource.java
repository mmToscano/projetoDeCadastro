package br.com.projetoFullStack.projetoFull.resources;

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

import br.com.projetoFullStack.projetoFull.entities.CourseTest;
import br.com.projetoFullStack.projetoFull.services.CourseTestService;

@RestController
@RequestMapping(value = "/courseTests")
public class CourseTestResource {
	
	@Autowired
	private CourseTestService service;
	
	@GetMapping
	public ResponseEntity<List<CourseTest>> findAll(){
		List list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseTest> findById(@PathVariable Integer id){
		CourseTest obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<CourseTest> insert(@RequestBody CourseTest test){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(test.getIdCourseTest()).toUri();
		return ResponseEntity.created(uri).body(test);
	}
	

}
