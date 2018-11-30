package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.cse.StallHolder;

import org.junit.Before;

public class StallHolderTest {
	StallHolder sh;

	@Before
	public void startup() {
		sh = new StallHolder("John Apple", "John's Fruit", "johnsfruit01", "john@google.com", "passwrd",
				"Fresh fruit from John's garden.", "Fruit", "web.ie", "Galway", false);
	}

	@Test
	public void testStallHolderConstructor() {
		assertEquals("John Apple", sh.getName());
	}

	@Test
	public void testToString() {
		assertTrue(sh.toString()
				.equals("Name:" + sh.getName() + "\nStallName: " + sh.getStallName() + "\nUsername: " + sh.getUsername()
						+ "\nEmail: " + sh.getEmail() + "\nDescription: " + sh.getDescription() + "\nLocation: "
						+ sh.getLocation() + "\nWebsiteLink: " + sh.getWebsiteLink() + "\nType of Produce: "
						+ sh.getTypeOfProduce() + "\nPassword: " + sh.getPassword() + "\nActivation Status: "
						+ sh.getActivationStatus()));
	}

	@Test
	public void testSetters() {
		sh.setDescription("test");
		sh.setEmail("test@test.com");
		sh.setLocation("Sligo");
		sh.setName("Seán");
		sh.setPassword("password1");
		sh.setStallName("Seán's seafood");
		sh.setTypeOfProduce("seafood");
		sh.setUsername("Seán1");
		sh.setWebsiteLink("www.test.com");
		sh.addClick();
		assertTrue(sh.getDescription().equals("test"));
		assertTrue(sh.getEmail().equals("test@test.com"));
		assertTrue(sh.getLocation().equals("Sligo"));
		assertTrue(sh.getName().equals("Seán"));
		assertTrue(sh.getPassword().equals("password1"));
		assertTrue(sh.getStallName().equals("Seán's seafood"));
		assertTrue(sh.getTypeOfProduce().equals("seafood"));
		assertTrue(sh.getUsername().equals("Seán1"));
		// assertEquals(sh.getWebsiteLink(), "www.test.com");
		assertTrue(sh.getClicks() == 1);
	}
	
	@Test
	public void testActivation() {
		sh.setActivationCommand(sh.getActivationCommand());
		assertTrue(sh.getActivationCommand().equals("Activate"));
		sh.setActivationStatus(true);
		assertTrue(sh.getActivationCommand().equals("Deactivate"));
	}
	
	@Test
	public void testExternalLinkDisplay() {
		sh.setActivationCommand(sh.getActivationCommand());
		assertTrue(sh.getActivationCommand().equals("Activate"));
		sh.setActivationStatus(true);
		assertTrue(sh.getActivationCommand().equals("Deactivate"));
	}
}
