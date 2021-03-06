package com.qa.persistence;

public class Item {


	private Long id;
	private String productName;
	private Long quantity;
	private Double price;
	
	public Item(String productName, Long quantity, Double price) {
		this.setProductName(productName);
		this.setQuantity(quantity);
		this.setPrice(price);
		

}
	
	public Item(Long id, String productName, Long quantity, Double price) {
		this.setId(id);
		this.setProductName(productName);
		this.setQuantity(quantity);
		this.setPrice(price);

}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString() {
		return "id: " + id + " , "+ "Product name: " + productName + " , "+  "quantity: " + quantity + " , " + "price: " + price;
		
	}
}
