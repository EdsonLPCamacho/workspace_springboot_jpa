package com.webdevelopment.development.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevelopment.development.entity.OrderItem;
import com.webdevelopment.development.repositories.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository usrRepository;
	
    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
	
	public List<OrderItem> findAll(){
		
		return usrRepository.findAll();
		
	}
	
	public OrderItem findById(Long id) {
		
		Optional<OrderItem> obj = usrRepository.findById(id);
		return obj.get();
		
	}


	


}