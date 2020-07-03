package com.jk.dao;

import java.util.List;

import com.jk.model.Contact;

public interface ContactDao {

	public String findNameById(Integer id);
	
	public List<String> findNames();
	
	public Contact findById(Integer id);
}
