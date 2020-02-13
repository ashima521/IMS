package com.qa.persistence;

public class Customer {
	
	private Long id;
	private String foreName;
	private String surname;
	private String email;
	private String address;
	
	public Customer(Long id, String foreName, String surname, String email, String address) {
		super();
		this.id = id;
		this.foreName = foreName;
		this.surname = surname;
		this.email = email;
		this.address = address;
	}

	public Customer(String foreName, String surname, String email, String address) {
		this.foreName = foreName;
		this.surname = surname;
		this.email = email;
		this.address = address;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "id: " + id + " , " + "first name: " + foreName + " , " + "surname: " + surname + " ," +  "email: " + email + " , " + "address: " + address; 
		
	}

}
