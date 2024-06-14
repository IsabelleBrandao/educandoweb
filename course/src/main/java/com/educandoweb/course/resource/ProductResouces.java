package com.educandoweb.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.ProductTable;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResouces {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<ProductTable>> findAll(){
		List<ProductTable> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductTable> findById(@PathVariable Long id){
		ProductTable obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
}
