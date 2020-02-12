package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class ItemController implements CrudController<Item>{
	
	
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Item> itemService;
	
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}
	
	String getInput() {
		return Utils.input();
	}
	

	public List<Item> readAll() {
		List<Item> product = itemService.readAll();
		for(Item products: product) {
			LOGGER.info(products.toString());
		}
		return product;
	}
		
	public void create() {
		LOGGER.info("Please enter a product name");
		String productName = Utils.input();
		LOGGER.info("Please enter quantity");
		Long quantity = Long.valueOf(Utils.input());
		LOGGER.info("Please enter price");
		Long price = Long.valueOf(Utils.input());
		itemService.create(new Item(null, productName, quantity, price));
		LOGGER.info("Item created successfully");
		
	}

	public void update() {
		LOGGER.info("Please enter the id of the product you would like to update");
		Long id = Long.valueOf(Utils.input());
		LOGGER.info("Please enter product name");
		String foreName = Utils.input();
		LOGGER.info("Please enter quantity");
		Long quantity = Long.valueOf(Utils.input());
		LOGGER.info("Please enter price");
		Long price = Long.valueOf(Utils.input());
		itemService.update(1, new Item(id, foreName, quantity, price));
		LOGGER.info("Item updated successfully");
		
	}

	public void delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long id = Long.valueOf(Utils.input());
		itemService.delete(id);
	}

}
