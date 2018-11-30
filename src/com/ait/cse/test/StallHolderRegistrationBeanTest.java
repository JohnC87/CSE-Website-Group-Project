package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.ait.cse.StallHolder;
import com.ait.cse.StallHolderRegistrationBean;

public class StallHolderRegistrationBeanTest {
	StallHolderRegistrationBean shrb;

	@Before
	public void start() {
		shrb = new StallHolderRegistrationBean();
	}

	@Test
	public void testGettersAndSetters() {
		StallHolderRegistrationBean s = new StallHolderRegistrationBean();
		s.setIsActivated(false);
		s.setLocation("Galway");
		s.setStallHolderDescription("testing");
		s.setStallHolderEmail("test@test.com");
		s.setStallHolderName("test");
		s.setStallHolderPassword("test2");
		s.setStallName("testy's");
		s.setTypeOfProduce("tests");
		s.setUsername("test1");
		s.setWebsiteLink("www.test.com");
		assertFalse(s.getIsActivated());
		assertTrue(s.getLocation().equals("Galway"));
		assertTrue(s.getStallHolderDescription().equals("testing"));
		assertTrue(s.getStallHolderEmail().equals("test@test.com"));
		assertTrue(s.getStallHolderName().equals("test"));
		assertTrue(s.getStallHolderPassword().equals("test2"));
		assertTrue(s.getStallName().equals("testy's"));
		assertTrue(s.getTypeOfProduce().equals("tests"));
		assertTrue(s.getUsername().equals("test1"));
		assertTrue(s.getWebsiteLink().equals("www.test.com"));
		StallHolder sh=new StallHolder("John Apple", "John's Fruit", "johnsfruit01", "john@google.com", "passwrd",
				"Fresh fruit from John's garden.", "Fruit", "web.ie", "Galway", false);
		s.setStallHolder(sh);
		assertTrue(s.getStallHolder().equals(sh));
	}

}
