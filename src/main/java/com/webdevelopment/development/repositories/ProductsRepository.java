package com.webdevelopment.development.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdevelopment.development.entity.Products;

public interface ProductsRepository  extends JpaRepository<Products, Long>{

}
