package com.webdevelopment.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevelopment.development.entity.OrderItem;
import com.webdevelopment.development.services.OrderItemService;

@RestController
@RequestMapping(value = "/OrderItem")
public class OrderItemResources {
	
	@Autowired
	private OrderItemService usrService;	
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll() {
		
		List<OrderItem> list = usrService.findAll();	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<OrderItem>> findOrderItems() {
	    System.out.println("Call findOrderItems() method");
	    List<OrderItem> list = usrService.findAll();    
	    return ResponseEntity.ok().body(list);
	}

}