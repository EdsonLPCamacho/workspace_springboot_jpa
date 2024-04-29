package com.webdevelopment.development.entity.enums;

public enum OrderItemStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderItemStatus(int code) {
		
		this.code = code;
	}
	
	public int getCode(){
		
		return code;
		
	}
	
	public static OrderItemStatus valueOf(int code) {
		
		for(OrderItemStatus value : OrderItemStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("This code is invalid!");
		
	}
	

}
