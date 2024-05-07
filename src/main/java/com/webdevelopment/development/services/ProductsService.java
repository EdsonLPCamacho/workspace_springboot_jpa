package com.webdevelopment.development.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevelopment.development.entity.Products;
import com.webdevelopment.development.repositories.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository usrRepository;
	
	

	
	public List<Products> findAll(){
		
		return usrRepository.findAll();
		
	}
	
	
	
	public Products findById(Long id) {
		
		Optional<Products> obj = usrRepository.findById(id);
		return obj.get();
		
	}


    public Products save(Products user) {
        return usrRepository.save(user);
    }

}