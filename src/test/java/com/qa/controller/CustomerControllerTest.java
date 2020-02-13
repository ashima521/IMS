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
		//	customers.add(new Customer("Rhys", "T"));
		//	customers.add(new Customer("Nic", "J"));
			Mockito.when(customerServices.readAll()).thenReturn(customers);
			assertEquals(customers, customerController.readAll());

}

	}
	