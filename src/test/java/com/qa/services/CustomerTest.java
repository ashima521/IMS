package com.qa.services;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.Customer;

public class CustomerTest {

	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1L, "A", "B", "C", "D");
		other = new Customer(1L, "A", "B", "C", "D");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getForeName());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getAddress());
		
		customer.setId(null);
		assertNull(customer.getId());
		customer.setForeName(null);
		assertNull(customer.getForeName());
		customer.setSurname(null);
		assertNull(customer.getSurname());
		customer.setEmail(null);
		assertNull(customer.getEmail());
		customer.setAddress(null);
		assertNull(customer.getAddress());
		
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(), 0);
		assertEquals("A", customer.getForeName());
		assertEquals("B", customer.getSurname());
		assertEquals("C", customer.getEmail());
		assertEquals("D", customer.getAddress());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setForeName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setForeName("rhys");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setForeName(null);
		other.setForeName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setId(null);
		other.setId(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		other.setSurname(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setSurname("E");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("A", "B", "C", "D");
		assertNull(customer.getId());
		assertNotNull(customer.getForeName());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getAddress());
	}
	
	@Test
	public void toStringTest() {
		String toString = "id: 1 , first name: A , surname: B , email: C , address: D";
		assertEquals(toString, customer.toString());

}

}
