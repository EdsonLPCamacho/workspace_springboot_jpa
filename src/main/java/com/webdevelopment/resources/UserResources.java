package com.webdevelopment.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/*
	 
	 @PostMapping:
	 A anotação @PostMapping é utilizada no Spring Framework para mapear solicitações HTTP POST 
	 para métodos específicos em um controlador. 
	 Quando um cliente envia uma solicitação HTTP POST para uma URL específica, o método anotado com @PostMapping 
	 é executado para processar essa solicitação.
	 
	 @RequestBody:
	 A anotação @RequestBody no Spring Framework é usada para mapear o corpo da solicitação HTTP para um objeto
	 em um método do controlador. Quando um cliente envia uma solicitação HTTP (como um POST ou PUT) com dados 
	 no corpo da solicitação, a anotação @RequestBody indica que esses dados devem ser convertidos 
	 em um objeto Java e passado como argumento para o método.
	 
	 Test:{
	  "name": "Elvis Presley",
	  "email": "elvis@elvis.com",
	  "password": "123456"
	 }
	 
	  */
	
	//Insert new user to database
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
				obj = usrService.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();							
				 return ResponseEntity.created(uri).body(obj);
	}
	

}