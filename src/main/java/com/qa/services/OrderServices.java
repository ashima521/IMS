package com.qa.services;

import java.util.List;

import com.qa.persistence.Dao;
import com.qa.persistence.Order;

public class OrderServices implements CrudServices<Order>{
	
	Dao<Order> orderDao;

	public OrderServices(Dao<Order> orderDao) {
		this.orderDao = orderDao;
		
	}

	public List<Order> readAll() {
		
		return orderDao.readall();
	
	}

	public void create(Order order) {
		
		orderDao.create(order);
		
	}

	public void update(long id, Order order) {
		
		orderDao.update(id, order);
		
	}

	public void delete(Long id) {
	
		orderDao.delete(id);
		
	}

}
