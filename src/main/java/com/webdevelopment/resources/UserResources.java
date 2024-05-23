package com.webdevelopment.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<User>> findUsers() {
	    System.out.println("Call findUsers() method");
	    List<User> list = usrService.findAll();    
	    return ResponseEntity.ok().body(list);
	}
	
	//Insert new user to database
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
				obj = usrService.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();							
				 return ResponseEntity.created(uri).body(obj);
	}
	
	//Create end point to delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		usrService.delete(id);
		return ResponseEntity.noContent().build(); //Return empty answer
	}
	
	//Using HTTP Method
	@PutMapping(value = "/{id}")
		public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = usrService.update(id, obj);
	    return ResponseEntity.ok().body(obj);
		
	}
	
	}