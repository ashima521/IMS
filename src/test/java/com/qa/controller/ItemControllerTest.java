package com.qa.controller;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;


import com.qa.persistence.Item;
import com.qa.services.ItemServices;

public class ItemControllerTest {

	@Mock
	private ItemServices itemServices;
	
	@Spy
	@InjectMocks
	private ItemController itemController;
	
	
	@Test
		public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item>item1 = new ArrayList<Item>();
		List<Item>item2 = new ArrayList<Item>();
		item1.add(new Item(1L, "B", 1L, 1.00));
		item2.add(new Item("B", 1L, 1.00));
//		Mockito.when(itemServices.readAll()).thenReturn(item1);
//		assertEquals(item2, itemController.readAll());
//	

	}
}