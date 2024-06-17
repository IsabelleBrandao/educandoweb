package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.UserTable;
import com.educandoweb.course.exceptions.DataBaseException;
import com.educandoweb.course.exceptions.ResourceNotFoundException;
import com.educandoweb.course.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserTable> findAll(){
		return repository.findAll();
	}
	
	public UserTable findById(Long id){
		Optional<UserTable> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public UserTable insert(UserTable obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			
			if (repository.existsById(id)) {
	            repository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }	
		  } catch (DataIntegrityViolationException e) {			
		        throw new DataBaseException(e.getMessage());	
		}
		
	}
	
	public UserTable update(Long id, UserTable obj) {
		try {
			UserTable entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);	
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);	
		}
	}

	private void updateData(UserTable entity, UserTable obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
