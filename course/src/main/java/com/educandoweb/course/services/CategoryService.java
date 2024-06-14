package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.CategoryTable;
import com.educandoweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryTable> findAll(){
		return repository.findAll();
	}
	
	public CategoryTable findById(Long id){
		Optional<CategoryTable> obj = repository.findById(id);
		return obj.get();
		
	}
	
}
