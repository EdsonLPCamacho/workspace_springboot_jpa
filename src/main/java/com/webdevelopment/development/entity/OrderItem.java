package com.webdevelopment.development.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webdevelopment.development.entity.enums.OrderItemStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderitemStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	@OneToMany(mappedBy="id.order")
	private Set<OrderItems> items = new HashSet<>();
	
	//Payment
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment; 
	
	//Constructor
	public OrderItem() {
		
	}

	//Constructor
	public OrderItem(Long id, Instant moment,OrderItemStatus orderitemStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderitemStatus(orderitemStatus);
		this.client = client;
	}
	
	
	//Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}	

	public OrderItemStatus getOrderitemStatus() {
		return OrderItemStatus.valueOf(orderitemStatus);
	}

	public void setOrderitemStatus(OrderItemStatus orderitemStatus) {
		
		if(orderitemStatus != null) {
			
			this.orderitemStatus = orderitemStatus.getCode();
			
		}
	}
 
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItems> getItems(){
		
		return items;
		
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	//Total Method
	public Double getTotal() {
		Double sum = 0.0;
		for(OrderItems x : items) {
			sum += x.getSubTotal();			
		}
		return sum;
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	

	
	

}
