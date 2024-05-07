package com.webdevelopment.development.entity.pk;

import java.io.Serializable;
import java.util.Objects;

import com.webdevelopment.development.entity.OrderItem;
import com.webdevelopment.development.entity.Products;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "Order_id")
	private OrderItem order;
	
	@ManyToOne
	@JoinColumn(name = "Products_id")
	private Products products;
	
	//Getters and Setters
	public OrderItem getOrder() {
		return order;
	}	

	public void setOrder(OrderItem order) {
		this.order = order;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	
	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(order, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(products, other.products);
	}
	
	

}
