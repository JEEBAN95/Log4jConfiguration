package com.jk.service;

import java.util.List;

import com.jk.model.Contact;

public interface ConctactService {

	public String getNameById(Integer id);
	
	public List<String> getAllContactNames();
	
	public Contact getContactInfoById(Integer id);
 }