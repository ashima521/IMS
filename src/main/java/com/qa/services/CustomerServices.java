package com.qa.services;

import java.util.List;

import com.qa.persistence.Customer;
import com.qa.persistence.Dao;

public class CustomerServices implements CrudServices<Customer> {
	
	Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
	this.customerDao = customerDao;
	}
	
	public List<Customer> readAll() {
	
		return customerDao.readall();
	}

	public void create(Customer customer) {
		
		customerDao.create(customer);
		
	}

	public void update(long id, Customer customer) {

		customerDao.update(id, customer);
		
	}

	public void delete(Long id) {
		
		customerDao.delete(id);
		
	}




}
