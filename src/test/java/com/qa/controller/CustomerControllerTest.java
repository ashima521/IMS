package com.qa.controller;

import static org.junit.Assert.assertEquals;

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
	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private CustomerServices customerServices;
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;
	@Test
	public void readAllTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "B", "C", "D", "E"));
		customers.add(new Customer(2L, "B", "C", "D", "E"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}



}