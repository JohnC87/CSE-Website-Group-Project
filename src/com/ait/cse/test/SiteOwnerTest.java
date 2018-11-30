package com.ait.cse.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ait.cse.FarmersMarketUserDatabase;
import com.ait.cse.SiteOwner;

public class SiteOwnerTest {
	SiteOwner galway;
	FarmersMarketUserDatabase db;
	ArrayList<SiteOwner> siteOwnerList;

	@Before
	public void startUp() {
		galway = new SiteOwner("Galway", "galwaysite", "pass01", "john@galway.ie", "John Smith");
		db = new FarmersMarketUserDatabase();

		db = new FarmersMarketUserDatabase();
		siteOwnerList = db.getSiteOwnerList();
	}

	@Test
	public void registerSiteOwner() {
		db.addNewSiteOwner(galway);
		ArrayList<SiteOwner> siteOwnersList = db.getSiteOwnerList();
		assertTrue(siteOwnersList.contains(galway));
		assertEquals("Galway", galway.getSiteName());
		assertEquals("galwaysite", galway.getUsername());
		assertEquals("pass01", galway.getSiteOwnerPassword());
		assertEquals("john@galway.ie", galway.getSiteOwnerEmail());
		assertEquals("John Smith", galway.getSiteOwnerName());
	}

	@Test
	public void testSetters() {
		galway.setSiteName("Sligo");
		assertEquals("Sligo", galway.getSiteName());
		galway.setUsername("newusername");
		assertEquals("newusername", galway.getUsername());
		galway.setSiteOwnerPassword("newpass");
		assertEquals("newpass", galway.getSiteOwnerPassword());
		galway.setSiteOwnerEmail("new@email.com");
		assertEquals("new@email.com", galway.getSiteOwnerEmail());
		galway.setSiteOwnerName("John NewMan");
		assertEquals("John NewMan", galway.getSiteOwnerName());
	}

	@Test
	public void testChangePassword() {
		String oldPassword = "pass01", newPassword = "password";
		galway.changePassword(oldPassword, newPassword);
		assertTrue(galway.getSiteOwnerPassword().equals("password"));
	}

	@Test
	public void testChangePasswordFail() {
		String oldPassword = "password", newPassword = "password";
		galway.changePassword(oldPassword, newPassword);
		assertTrue(galway.getSiteOwnerPassword().equals("pass01"));
	}

}
