//package com.qa.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.persistence.Order;
//import com.qa.services.OrderServices;
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class OrderControllerTest {
//
//	@Mock
//	private OrderServices orderServices;
//	
//	@Spy
//	@InjectMocks
//	
//	private OrderController orderController;
//	
//	@Test
//	public void readAllTest() {
//		OrderController orderController = new OrderController(orderServices);
//		List<Order> orders = new ArrayList<Order>();
//	    orders.add(new Order(1L, 9L, 2.99));
//		Mockito.when(orderServices.readAll()).thenReturn(orders);
//		assertEquals(orders, orderController.readAll());
//	}		
//		
//	
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(orderController).getInput();
//		orderController.delete();
//		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
//	}
//	
//}
