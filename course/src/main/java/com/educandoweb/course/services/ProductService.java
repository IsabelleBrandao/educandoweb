package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.ProductTable;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<ProductTable> findAll(){
		return repository.findAll();
	}
	
	public ProductTable findById(Long id){
		Optional<ProductTable> obj = repository.findById(id);
		return obj.get();
		
	}
	
}
