package com.webdevelopment.development.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevelopment.development.entity.OrderItem;
import com.webdevelopment.development.services.OrderItemService;

@RestController
@RequestMapping("/development/OrderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItemList = orderItemService.findAll();
        return ResponseEntity.ok(orderItemList);
    }

    @PostMapping("/register")
    public ResponseEntity<OrderItem> registerOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem savedOrderItem = orderItemService.save(orderItem);
        return new ResponseEntity<>(savedOrderItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.findById(id);
        return ResponseEntity.ok(orderItem);
    }

   
}
