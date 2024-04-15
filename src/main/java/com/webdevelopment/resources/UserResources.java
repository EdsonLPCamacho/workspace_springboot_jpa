package com.webdevelopment.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevelopment.development.entity.User;
import com.webdevelopment.development.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService usrService;	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = usrService.findAll();	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findUsers() {
	    System.out.println("Call findUsers() method");
	    List<User> list = usrService.findAll();    
	    return ResponseEntity.ok().body(list);
	}

}