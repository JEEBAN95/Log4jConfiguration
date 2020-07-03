package com.jk;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jk.dao.ContactDao;
import com.jk.exception.NoDataFoundException;
import com.jk.model.Contact;
import com.jk.service.impl.ContactServiceImpl;

public class ContactServiceTest {

	private static ContactServiceImpl contactService;

	@BeforeClass
	public static void init() {
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class);
		// method-1
		EasyMock.expect(daoProxy.findNameById(101)).andReturn("Jeeban");
		
		// method-2
		List<String> names = new ArrayList<String>();
		names.add("Saila");
		names.add("Jeeban");
		names.add("Sachin");
		names.add("MS DHoni");
		EasyMock.expect(daoProxy.findNames()).andReturn(names);
		
		// method-3
		Contact c = new Contact();
		c.setPersonId(101);
		c.setPersonName("Peter");
		c.setPersonMobileNum("123456");
		c.setPersonEmail("person@gmail.com");
		EasyMock.expect(daoProxy.findById(101)).andReturn(c);
		
		EasyMock.expect(daoProxy.findById(102)).andReturn(null);
		
		// save behavior of mock obj
		EasyMock.replay(daoProxy);
		
		// dependency to service
		contactService = new ContactServiceImpl();
		contactService.setContactDao(daoProxy);

	}

	@Test
	public void testGetNameById_01() {

		String name = contactService.getNameById(101);
		assertNotNull(name);
	}

	@Test
	public void testGetAllNames_01() {

		List<String> allNames = contactService.getAllContactNames();
		assertNotNull(allNames);
	}
	
	@Test
	public void testGetContactInfoById_01() {
		
		Contact contact = contactService.getContactInfoById(101);
		assertNotNull(contact);
	}
	
	@Test(expected = NoDataFoundException.class)
	public void testGetContactInfoById_02() {
		
		contactService.getContactInfoById(102);
		
	}
}