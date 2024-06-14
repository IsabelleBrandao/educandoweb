package com.educandoweb.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.CategoryTable;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResouces {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryTable>> findAll(){
		List<CategoryTable> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryTable> findById(@PathVariable Long id){
		CategoryTable obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
}
