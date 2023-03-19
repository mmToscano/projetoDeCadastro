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

import br.com.projetoFullStack.projetoFull.entities.Class;
import br.com.projetoFullStack.projetoFull.entities.Student;
import br.com.projetoFullStack.projetoFull.services.ClassService;

@RestController
@RequestMapping(value = "/classes")
public class ClassResource {
	
	@Autowired
	private ClassService service;
	
	@GetMapping
	public ResponseEntity<List<Class>> findAll(){
		List list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Class> findById(@PathVariable Integer id){
		Class obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/findStudents/{id}")
	public ResponseEntity<List<Student>> findStudentsByIdClass(@PathVariable Integer id){
		List list = service.findStudentsByIdClass(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Class> insert(@RequestBody Class obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdClass()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
