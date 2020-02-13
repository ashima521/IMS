package com.qa;



import org.apache.log4j.Logger;

import com.qa.controller.Action;
import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.controller.ItemController;
import com.qa.controller.OrderController;
import com.qa.persistence.Domain;
import com.qa.persistence.MysqlCustomerDao;
import com.qa.persistence.MysqlItemDao;
import com.qa.persistence.MysqlOrdersDao;
import com.qa.services.CustomerServices;
import com.qa.services.ItemServices;
import com.qa.services.OrderServices;
import com.qa.utils.Utils;

public class Ims {

	
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void imsSystem()  {
		LOGGER.info("What is your username");
		String username = Utils.input();
		LOGGER.info("What is your password");
		String password = Utils.input();
		
		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();
		
		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

		Action.printActions();
		Action action = Action.getAction();
		
		switch (domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(new CustomerServices(new MysqlCustomerDao()));
			doAction(customerController, action);
			break;
		case ITEM:
			ItemController itemController = new ItemController(new ItemServices(new MysqlItemDao()));
			doAction(itemController, action);
			break;
		case ORDER:
			OrderController orderController = new OrderController(new OrderServices(new MysqlOrdersDao()));
			doAction(orderController, action);
			break;
		case STOP:
			break;
		default:
			break;
		}
		
	}
	
	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
}
