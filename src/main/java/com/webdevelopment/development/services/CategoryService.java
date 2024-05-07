package com.webdevelopment.development.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevelopment.development.entity.Category;
import com.webdevelopment.development.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository usrRepository;
	
	

	
	public List<Category> findAll(){
		
		return usrRepository.findAll();
		
	}
	
	
	
	public Category findById(Long id) {
		
		Optional<Category> obj = usrRepository.findById(id);
		return obj.get();
		
	}

}