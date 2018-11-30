package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.cse.Manager;

public class ManagerTest {

	Manager manager;

	@Test
	public void testManagerConstructor() {
		manager = new Manager("Sabrina", "pass1234");
		assertEquals("Sabrina", manager.getUsername());
		assertEquals("pass1234".hashCode(), manager.getPassword());
	}
	
	@Test
	public void testManagerChangePassword(){
		manager = new Manager("Sabrina", "pass1234");
		assertTrue(manager.changePassword("pass1234", "newpass"));
	}
	
	@Test
	public void testManagerChangePasswordInvalidOld(){
		manager = new Manager("Sabrina", "pass1234");
		assertFalse(manager.changePassword("wrongpass", "newpass"));
	}

}
