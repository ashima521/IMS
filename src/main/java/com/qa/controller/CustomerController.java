package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.Customer;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class CustomerController implements CrudController<Customer> {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Customer> customerService;
	
	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}
	
	String getInput() {
		return Utils.input();
	}
	

	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for(Customer customer: customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}


	public void create() {
		LOGGER.info("Please enter a first name");
		String foreName = Utils.input();
		LOGGER.info("Please enter a surname");
		String surname = Utils.input();
		customerService.create(new Customer(null, foreName, surname));
		LOGGER.info("Customer created");
		
	}

	public void update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long id = Long.valueOf(Utils.input());
		LOGGER.info("Please enter a first name");
		String foreName = Utils.input();
		LOGGER.info("Please enter a surname");
		String surname = Utils.input();
		customerService.update(1, new Customer(id, foreName, surname));
		LOGGER.info("Customer Updated");
	}

	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(Utils.input());
		customerService.delete(id);
	}

		
	}


