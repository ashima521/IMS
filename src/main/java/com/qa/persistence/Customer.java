package com.qa.persistence;

public class Customer {
	
	private Long id;
	private String foreName;
	private String surname;
	
	public Customer(Long id, String foreName, String surname) {
		super();
		this.id = id;
		this.foreName = foreName;
		this.surname = surname;
	}
	//getters and setters 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getForeName() {
		return foreName;
	}
	public void setForeName(String firstName) {
		this.foreName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return "id:" + id  + "first name:" + foreName + "surname:" + surname;
		
	}

}
