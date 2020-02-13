package com.qa.persistence;

import java.util.ArrayList;

public interface OrderDao<T, U, V> {
	
	public void create(T t);

    //R	
	public ArrayList<T> readall();
	
	//U
	public void update(long id, T t);
	
	//D
	public void delete(long id);
	
	public void item(U u);



}
