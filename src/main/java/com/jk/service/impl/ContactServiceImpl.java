package com.jk.service.impl;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jk.dao.ContactDao;
import com.jk.exception.NoDataFoundException;
import com.jk.model.Contact;
import com.jk.service.ConctactService;

public class ContactServiceImpl implements ConctactService {

	private ContactDao contactDao;

	private static Logger logger = Logger.getLogger(ContactServiceImpl.class);
	static {

		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "Log4j.properties");
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
		logger.info("Dependency injection  is done.");
	}

	@Override
	public String getNameById(Integer id) {
		logger.debug("getNameById method execution is started");
		String name = contactDao.findNameById(id);
		String formattedName = name.toUpperCase();
		logger.debug("getNameById method execution is ended");
		return formattedName;
	}

	@Override
	public List<String> getAllContactNames() {
		logger.debug("getAllContactNames method execution is started");
		List<String> names = contactDao.findNames();
		if (!names.isEmpty()) {
			return names;
		}
		logger.debug("getAllContactNames method execution is ended");
		return null;
	}

	@Override
	public Contact getContactInfoById(Integer id) {
		logger.debug("getContactInfoById method execution is started");
		Contact contact = contactDao.findById(id);
		if (contact == null) {
			logger.error("exception rised");
			throw new NoDataFoundException();
		}
		logger.debug("getContactInfoById method execution is ended");
		return contact;
	}
}