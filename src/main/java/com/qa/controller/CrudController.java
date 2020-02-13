package com.qa.controller;

import java.util.List;

public interface CrudController<T> {
	
    public List<T> readAll();
    
    public void create();
     
    public void update();
     
    public void delete();

	}


