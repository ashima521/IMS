package com.qa.services;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.Item;

public class ItemTest {


	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(1L, "A", 1L, 1.00);
		other = new Item(1L, "A", 1L, 1.00);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getProductName());
		assertNotNull(item.getQuantity());
		assertNotNull(item.getPrice());
	
		
		item.setId(null);
		assertNull(item.getId());
		item.setProductName(null);
		assertNull(item.getProductName());
		item.setQuantity(null);
		assertNull(item.getQuantity());
		item.setPrice(null);
		assertNull(item.getPrice());
		
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createProductWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("A", item.getProductName());
		assertEquals("B", item.getQuantity());
		assertEquals("C", item.getPrice());
	
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(item.equals(other));
	}
	
	@Test
	public void productNameNullButOtherNameNotNull() {
		item.setProductName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void productNamesNotEqual() {
		other.setProductName("Q");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setProductName(null);
		other.setProductName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullQuantity() {
		item.setQuantity(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullQuantityOnBoth() {
		item.setQuantity(null);
		other.setQuantity(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherQuantityDifferent() {
		other.setQuantity(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("A", 1L, 1.00);
		assertNull(item.getId());
		assertNotNull(item.getProductName());
		assertNotNull(item.getQuantity());
		assertNotNull(item.getPrice());
		
	}
	
	@Test
	public void toStringTest() {
		String toString = "id: 1 , Product name: A , quantity: 1 , price: 1.00";
		assertEquals(toString, item.toString());
		
	}
}
