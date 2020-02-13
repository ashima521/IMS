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

public class MysqlItemDao implements Dao<Item>{
	
	public static final Logger LOGGER = Logger.getLogger(MysqlCustomerDao.class);

	private Connection connection;

	public MysqlItemDao() {


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
	

	public void create(Item product) {
		try {
			checkConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into product(productName, quantity, price) values('"
					+ product.getProductName() + "','" + product.getQuantity() + "','" + product.getPrice() + "')");

			LOGGER.info("Product was added successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	public ArrayList<Item> readall() {
		ArrayList<Item> product = new ArrayList<Item>();
		try {
			checkConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from product");
			while (resultSet.next()) {
				Long id = resultSet.getLong("productId");
				String productName = resultSet.getString("productName");
				Long quantity = resultSet.getLong("quantity");
				Double price = resultSet.getDouble("price");
				product.add(new Item(id, productName, quantity, price));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return product;
	}

	public void update(long id, Item product) {
		try {
			checkConnection();
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE product set productName = ?, quantity = ?, price = ? where productId = ?");
			statement.setString(1, product.getProductName());
			statement.setLong(2, product.getQuantity());
			statement.setDouble(3, product.getPrice());
			statement.setLong(4, id);
			statement.executeUpdate();

			LOGGER.info("Item was updated successfully");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void delete(long id) {
		try {
			checkConnection();
			PreparedStatement statement = connection.prepareStatement("Delete from product where productId=?");

			statement.setLong(1, id);
			statement.executeUpdate();

			LOGGER.info("Item was deleted successfully");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}


}
