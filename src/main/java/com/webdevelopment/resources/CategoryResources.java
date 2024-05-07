package com.webdevelopment.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevelopment.development.entity.Category;
import com.webdevelopment.development.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {
	
	@Autowired
	private CategoryService usrService;	
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		
		List<Category> list = usrService.findAll();	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Category>> findCategorys() {
	    System.out.println("Call findCategorys() method");
	    List<Category> list = usrService.findAll();    
	    return ResponseEntity.ok().body(list);
	}

}