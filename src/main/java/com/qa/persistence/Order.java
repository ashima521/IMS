package com.qa.persistence;

public class Order {
	
	private Long orderId;
	private Long customerId;
	private Long totalQuantity;
	private Double totalPrice;

	public Order( Long customerId, Long totalQuantity, Double totalPrice) {
	
		this.setCustomerId(customerId);
		this.setTotalQuantity(totalQuantity);
		this.setTotalPrice(totalPrice);
		
	}
	public Order(Long orderId, Long customerId, Long totalQuantity, Double totalPrice) {
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
		this.setTotalQuantity(totalQuantity);
		this.setTotalPrice(totalPrice);
		
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String toString() {
		return "order id: " + orderId  + " , " +  "customer id: " + customerId + " , " + "total quantity: " + totalQuantity + " , " + "total price: " + totalPrice;
		
	}
}
