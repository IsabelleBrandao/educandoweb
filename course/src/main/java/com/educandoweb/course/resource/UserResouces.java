package com.educandoweb.course.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.educandoweb.course.entities.UserTable;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResouces {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserTable>> findAll(){
		List<UserTable> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserTable> findById(@PathVariable Long id){
		UserTable obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<UserTable> insert(@RequestBody UserTable id){
		 UserTable obj = service.insert(id);
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	                                             .path("/{id}")
	                                             .buildAndExpand(obj.getId())
	                                             .toUri();
	        return ResponseEntity.created(uri).body(obj);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserTable> update(@PathVariable Long id, @RequestBody UserTable obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
 