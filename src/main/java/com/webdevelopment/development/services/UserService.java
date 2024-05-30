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

	public List<User> findAll() {

		return usrRepository.findAll();

	}

	public User findById(Long id) {

		Optional<User> obj = usrRepository.findById(id);
		return obj.get(); 

	}

	public User save(User user) {
		return usrRepository.save(user);
	}

	// Save user to data base
	public User insert(User obj) {

		return usrRepository.save(obj); // Returns the saved object

	}
	
	//Delete user from data base
	public void delete(Long id) {
		usrRepository.deleteById(id);
	}
	
	//Update user function
	public User update(Long id, User obj) {
		User entity = usrRepository.getReferenceById(id);
		updateData(entity, obj);
		return usrRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}

}