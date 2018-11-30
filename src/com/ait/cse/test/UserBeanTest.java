package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.cse.StallHolder;
import com.ait.cse.UserBean;
import com.ait.cse.Users;

import org.junit.Before;

public class UserBeanTest {
	UserBean ub;

	@Before
	public void start() {
		ub = new UserBean();
		ub.init();
	}

	@Test
	public void testInit() {
		assertEquals(ub.getStallHolderList().get(0).getName(), "John Apple");
	}

	@Test
	public void testLoginManager() {
		ub.setPassword("FarmersM");
		ub.setUsername("Sabrina1");
		assertTrue(ub.login().equals("Manager"));
	}

	@Test
	public void testLoginStallHolder() {
		ub.setPassword("password01");
		ub.setUsername("johnsfruit01");
		assertTrue(ub.login().equals("StallOwner"));
	}

	@Test
	public void testLoginSiteOwner() {
		ub.setPassword("pass01");
		ub.setUsername("galwaysite");
		assertTrue(ub.login().equals("SiteOwnerGalway"));
		ub.registerSiteOwner("Sligo", "Sligo1", "passligo", "sligo@info.com", "Sligo");
	}

	@Test
	public void testLoginFalse() {
		ub.setPassword("pass01");
		ub.setUsername("johnsfruit01");
		assertTrue(ub.login().equals("SingleLogin"));
	}

	@Test
	public void testLogout() {
		ub.setPassword("password01");
		ub.setUsername("johnsfruit01");
		assertTrue(ub.login().equals("StallOwner"));
		ub.Logout();
		assertEquals(ub.getPassword(), null);
		assertEquals(ub.getUsername(), null);
	}

	@Test
	public void TestRegisterStallHolder() {
		assertTrue(ub.registerStallHolder("test", "testy's", "test1", "test@test.com", "test2", "tests", "tests",
				"test@test.com", "sligo", true).equals("Manager"));
		assertTrue(ub.getUserList().size() == 6);
		assertTrue(ub.getStallHolderList().size() == 3);
	}

	@Test
	public void TestRegisterSiteOwner() {
		assertTrue(ub.registerSiteOwner("sligo", "sligo", "test", "test", "test").equals("Manager.xhtml"));
		assertTrue(ub.getUserList().size() == 6);
		assertTrue(ub.getSiteOwnerList().size() == 3);
	}

	@Test
	public void ChangePasswordSo() {
		ub.setPassword("pass01");
		ub.setUsername("galwaysite");
		ub.login();
		ub.setOldPassword(ub.getLoggedInSo().getSiteOwnerPassword());
		ub.setNewPassword("password");
		assertTrue(ub.changePasswordSo().equals("SiteOwnerGalway"));
		assertEquals(ub.getLoggedInSo().getSiteOwnerPassword(), "password");
	}

	@Test
	public void ChangePasswordSoFail() {
		ub.setPassword("pass01");
		ub.setUsername("galwaysite");
		ub.login();
		ub.setOldPassword(null);
		ub.setNewPassword("password");
		assertTrue(ub.changePasswordSo().equals("Error"));
	}

	@Test
	public void ChangePasswordSh() {
		ub.setPassword("password01");
		ub.setUsername("johnsfruit01");
		ub.login();
		ub.setOldPassword(ub.getLoggedInSh().getPassword());
		ub.setNewPassword("password");
		assertTrue(ub.changePasswordSh().equals("StallOwner"));
		assertTrue(ub.getLoggedInSh().getPassword().equals("password"));
	}

	@Test
	public void ChangePasswordShFail() {
		ub.setPassword("password01");
		ub.setUsername("johnsfruit01");
		ub.login();
		ub.setOldPassword(null);
		ub.setNewPassword("password");
		assertTrue(ub.changePasswordSh().equals("Error"));
	}

	@Test
	public void testUpdate() {
		ub.setPassword("password01");
		ub.setUsername("johnsfruit01");
		ub.login();
		ub.setUpdateDescription("test");
		ub.setUpdateEmail("test");
		ub.setUpdateLocation("test");
		ub.setUpdateName("test");
		ub.setUpdateProduce("test");
		ub.setUpdateStallName("test");
		ub.setUpdateUsername("test");
		ub.setUpdateWebsiteLink("test");
		assertTrue(ub.updateData().equals("StallOwner"));
		assertTrue(ub.getLoggedInSh().getDescription().equals("test"));
		assertTrue(ub.getLoggedInSh().getEmail().equals("test"));
		assertTrue(ub.getLoggedInSh().getLocation().equals("test"));
		assertTrue(ub.getLoggedInSh().getName().equals("test"));
		assertTrue(ub.getLoggedInSh().getTypeOfProduce().equals("test"));
		assertTrue(ub.getLoggedInSh().getStallName().equals("test"));
		assertTrue(ub.getLoggedInSh().getUsername().equals("test"));
		assertTrue(ub.getLoggedInSh().getWebsiteLink().equals("test"));
	}

	@Test
	public void testView() {
		ub.registerStallHolder("test", "testy's", "test1", "test@test.com", "test2", "tests", "tests", "sligo",
				"test@test.com", true);
		String s = "John's Fruit";
		ub.view(s);
		assertEquals(ub.getViewing().getPassword(), "password01");
	}

	@Test
	public void testSortLists() {
		ub.registerStallHolder("test", "testy's", "test1", "test@test.com", "test2", "tests", "tests", "sligo",
				"test@test.com", true);
		assertTrue(ub.getSligoList().size() == 1);
	}
	
	@Test
	public void testChangeActivationStatus() {
		ub.setManaging(ub.getStallHolderList().get(0));
		assertEquals(ub.changeActivationStatus(), "ManageSelectedStallHolder");
		assertEquals(ub.changeActivationStatus(), "ManageSelectedStallHolder");
	}

	@Test
	public void testChangeExternalLinkStatus() {
		ub.setManaging(ub.getStallHolderList().get(0));
		assertEquals(ub.changeExternalLinkStatus(), "ManageSelectedStallHolder");
		assertEquals(ub.changeExternalLinkStatus(), "ManageSelectedStallHolder");
	}

	@Test
	public void testGetMonth() {
		assertTrue(ub.getCurrentMonth().equals("August"));
	}

	@Test
	public void testFeePaid() {
		ub.setGalwayFeePaid(true);
		assertTrue(ub.getGalwayFeePaid().equals("Paid-In-Full"));
		ub.setGalwayFeePaid(false);
		assertTrue(ub.getGalwayFeePaid().equals("Fee Not Paid"));
		ub.setSligoFeePaid(true);
		assertTrue(ub.getSligoFeePaid().equals("Fee Paid-In-Full"));
		ub.setSligoFeePaid(false);
		assertTrue(ub.getSligoFeePaid().equals("Fee Not Paid"));
	}

	@Test
	public void testGettersAndSetters() {
		ub.setLog(true);
		assertTrue(ub.isLog());
		ub.setNewPassword("Pass");
		ub.setOldPassword("Old");
		assertTrue(ub.getOldPassword().equals("Old"));
		assertTrue(ub.getNewPassword().equals("Pass"));
		ub.setUpdateDescription("test");
		ub.setUpdateEmail("test");
		ub.setUpdateLocation("test");
		ub.setUpdateName("test");
		ub.setUpdateProduce("test");
		ub.setUpdateStallName("test");
		ub.setUpdateUsername("test");
		ub.setUpdateWebsiteLink("test");
		assertTrue(ub.getUpdateDescription().equals("test"));
		assertTrue(ub.getUpdateEmail().equals("test"));
		assertTrue(ub.getUpdateLocation().equals("test"));
		assertTrue(ub.getUpdateName().equals("test"));
		assertTrue(ub.getUpdateProduce().equals("test"));
		assertTrue(ub.getUpdateStallName().equals("test"));
		assertTrue(ub.getUpdateUsername().equals("test"));
		assertTrue(ub.getUpdateWebsiteLink().equals("test"));
		ub.setLoginFailed(true);
		assertTrue(ub.isLoginFailed());
	}
}