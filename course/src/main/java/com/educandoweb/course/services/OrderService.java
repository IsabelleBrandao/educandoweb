package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.OrderTable;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<OrderTable> findAll(){
		return repository.findAll();
	}
	
	public OrderTable findById(Long id){
		Optional<OrderTable> obj = repository.findById(id);
		return obj.get();
		
	}
	
}
