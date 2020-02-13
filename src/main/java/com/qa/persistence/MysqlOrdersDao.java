package com.qa.persistence;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.utils.Utils;

public class MysqlOrdersDao implements Dao<Order>{
	
	public static final Logger LOGGER = Logger.getLogger(MysqlCustomerDao.class);

	private Connection connection;

	public MysqlOrdersDao() {

		
	}
	public void checkConnection() {
		LOGGER.info("Enter Username:");
		String username = Utils.input();
		LOGGER.info("Enter password:");
		String password = Utils.input();

		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://34.76.141.152:3306/IMS", username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void create(Order order) {
	
		try {
			checkConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into orders(customerId, totalQuantity, totalPrice) values('"
					 + order.getCustomerId() + "','" + order.getTotalQuantity() + "','"
					+ order.getTotalPrice() + "')");

			LOGGER.info("Order was added successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Order> readall() {
		ArrayList<Order> order = new ArrayList<Order>();
		try {
			checkConnection();			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				Long orderId = resultSet.getLong("orderId");
				Long customerId = resultSet.getLong("customerId");
				Long quantity = resultSet.getLong("totalQuantity");
				Double price = resultSet.getDouble("totalPrice");
				order.add(new Order(orderId, customerId, quantity, price));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return order;

	}

	public void update(long id, Order order) {
		try {
			checkConnection();
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE orders set customerId = ?, totalQuantity = ?, totalPrice = ? where orderId = ?");
			statement.setLong(1, order.getCustomerId());
			statement.setLong(2, order.getTotalQuantity());
			statement.setDouble(3, order.getTotalPrice());
			statement.setLong(4, id);
			statement.executeUpdate();

			LOGGER.info("Order was updated successfully");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void delete(long id) {
		try {
			checkConnection();
			PreparedStatement statement = connection.prepareStatement("Delete from orders where orderId=?");

			statement.setLong(1, id);
			statement.executeUpdate();

			LOGGER.info("Order was deleted successfully");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
