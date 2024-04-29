package com.webdevelopment.development.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdevelopment.development.entity.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long>{

}
