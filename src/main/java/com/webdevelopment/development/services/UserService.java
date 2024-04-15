package com.webdevelopment.development.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevelopment.development.entity.User;
import com.webdevelopment.development.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository usrRepository;
	
	public List<User> findAll(){
		
		return usrRepository.findAll();
		
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = usrRepository.findById(id);
		return obj.get();
		
	}
	

}
