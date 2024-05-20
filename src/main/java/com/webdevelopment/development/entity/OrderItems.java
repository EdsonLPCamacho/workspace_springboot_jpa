package com.webdevelopment.development.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webdevelopment.development.entity.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_ordem_items")
public class OrderItems implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	
	private Double price;
	
	//Constructor
	public OrderItems() {
		
	}

	public OrderItems(OrderItem order, Products products, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProducts(products);
		this.quantity = quantity;
		this.price = price;
	}
	
	//Getters and Setters	
	public OrderItem getOrder() {
		
		return id.getOrder();
	}
	
	public void setOrder(OrderItem order) {
		
		id.setOrder(order);
		
	}
	
	@JsonIgnore
    public Products getProducts() {
		
		return id.getProducts();
	}
	
	public void setProducts(Products products) {
		
		id.setProducts(products);
		
	}
		
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//SubTotal Method
	public Double getSubTotal() {
		
		return price * quantity;
	}

	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
