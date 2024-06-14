package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.UserTable;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserTable> findAll(){
		return repository.findAll();
	}
	
	public UserTable findById(Long id){
		Optional<UserTable> obj = repository.findById(id);
		return obj.get();
	}
	
	public UserTable insert(UserTable obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public UserTable update(Long id, UserTable obj) {
		UserTable entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	public void updateData(UserTable entity, UserTable obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}	
}
