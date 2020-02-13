package com.qa.persistence;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.utils.Utils;

public class MysqlCustomerDao implements Dao<Customer> {
	
	public static final Logger LOGGER = Logger.getLogger(MysqlCustomerDao.class);

	private Connection connection;

	public MysqlCustomerDao() {

		
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
	
	public void create(Customer customer) {
		try {
			checkConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(foreName, surname, email, address) values('" + customer.getForeName() + "','"
					+ customer.getSurname() + "','"+ customer.getEmail() + "','"+ customer.getAddress() + "')");

			LOGGER.info("Customer was created successfully");
 
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Customer> readall() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			checkConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customers");
			while (resultSet.next()) {
				Long id = resultSet.getLong("customerId");
				String foreName = resultSet.getString("foreName");
				String surname = resultSet.getString("surname");
				String email = resultSet.getString("email");
				String address = resultSet.getString("address");
				customers.add(new Customer(id, foreName, surname, email, address));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return customers;
	}

	public void update(long id, Customer customer) {

		try {
			checkConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE customers set foreName = ?, surname = ? where customerId = ?");
			statement.setString(1, customer.getForeName());
			statement.setString(2, customer.getSurname());
			statement.setLong(3, id);
			statement.executeUpdate();

			LOGGER.info("User was updated successfully");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void delete(long id) {

		try {
			checkConnection();
			PreparedStatement statement = connection.prepareStatement("Delete from customers where customerId=?");

			statement.setLong(1, id);
			statement.executeUpdate();

			LOGGER.info("A user was deleted successfully");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	

	
	
}
