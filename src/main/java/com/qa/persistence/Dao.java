package com.qa.persistence;

import java.util.ArrayList;

public interface Dao <T> {    //where T is any generic value
	                          //t is a reference variable
	                          //everything is abstract in an interface

	//C
	public void create(T t);

    //R	
	public ArrayList<T> readall();
	
	//U
	public void update(long id, T t);
	
	//D
	public void delete(long id);
	

}
