package com.webdevelopment.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevelopment.development.entity.OrderItem;
import com.webdevelopment.development.entity.Products;
import com.webdevelopment.development.services.ProductsService;

@RestController
@RequestMapping(value = "/products")
public class ProductsResources {
	
	@Autowired
	private ProductsService usrService;	
	
	@GetMapping
	public ResponseEntity<List<Products>> findAll() {
		
		List<Products> list = usrService.findAll();	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> findProductById(@PathVariable Long id) {
	    System.out.println("Call findProductById() method");
	    Products product = usrService.findById(id);
	    if (product != null) {
	        return ResponseEntity.ok().body(product);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


}