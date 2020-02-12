package com.qa.services;

import java.util.List;

public interface CrudServices<T> {
	
	   public List<T> readAll();
	     
	   public void create(T t);
	     
	   public void update(long id, T t);
	 
	   public void delete(Long id);
}
