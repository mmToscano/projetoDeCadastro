package br.com.projetoFullStack.projetoFull.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.services.StudentService;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false", value = "http://localhost:8080")
@RestController
@RequestMapping(value = "/students")
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> findAll(){
		List list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Student> findById(@PathVariable Integer id){
		Student obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Student> insert(@RequestBody Student obj) {
		URI uri = null;
		try {
		service.insert(obj);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdStudent()).toUri();
		}catch(HttpClientErrorException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.created(uri).body(obj);
		
		
	}

}
