package com.qa.services;

import java.util.List;

import com.qa.persistence.Dao;
import com.qa.persistence.Item;

public class ItemServices implements CrudServices<Item>{

	Dao<Item> itemDao;
	
	public ItemServices(Dao<Item> itemDao) {
	this.itemDao = itemDao;
	}
	
	public List<Item> readAll() {
	
		return itemDao.readall();
	}

	public void create(Item product) {
		
		itemDao.create(product);
		
	}

	public void update(long id, Item product) {

		itemDao.update(id, product);
		
	}

	public void delete(Long id) {
		
		itemDao.delete(id);
		
	}


}
