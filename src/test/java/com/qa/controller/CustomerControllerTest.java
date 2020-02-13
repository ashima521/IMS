package com.qa.controller;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.Customer;
import com.qa.services.CustomerServices;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	private CustomerServices customerServices;
	
	@Spy
	@InjectMocks
	private CustomerController customerController;
	
	@Test
		public void readAllTest() {
			CustomerController customerController = new CustomerController(customerServices);
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(new Customer(1L, "B", "C", "D", "E"));
			Mockito.when(customerServices.readAll()).thenReturn(customers);
			assertEquals(customers, customerController.readAll());
			
	}
//	@Test
//	public void createTest() {
//		String foreName = "A";
//		String surname = "B";
//		String email = "C";
//		String address = "D";
//		
//		Mockito.doReturn(foreName, surname, email, address).when(customerController).getInput();
//		Customer customer = new Customer(foreName, surname, email, address);
//		Customer savedCustomer = new Customer(1L, "A", "B", "C", "D");
//		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
//		assertEquals(savedCustomer, customerController.create());
//	
	
//	@Test
//	public void updateTest() {
//		Long id = 1L;
//		String foreName = "A";
//		String surname = "B";
//		String email = "C";
//		String address = "D";
//		Mockito.doReturn(id, foreName, surname, email, address).when(customerController).getInput();
//		Customer customer = new Customer(foreName, surname, email, address);
//		Mockito.doReturn(customer).when(customerServices.update(id, customer));
//		assertEquals(customer, customerController.update());
//	}
	
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

	}
	