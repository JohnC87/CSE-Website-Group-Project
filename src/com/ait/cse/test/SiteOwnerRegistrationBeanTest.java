package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ait.cse.SiteOwner;
import com.ait.cse.SiteOwnerRegistrationBean;

public class SiteOwnerRegistrationBeanTest {
	private SiteOwner siteOwner;
	private SiteOwnerRegistrationBean sorb;

	@Before
	public void setUp() {
		siteOwner = new SiteOwner("Holly", "username1", "siteOwnerPassword", "siteOwnerEmail", "siteOwnerName");
		sorb = new SiteOwnerRegistrationBean();
	}

	@Test
	public void testGettersSetters() {
		sorb.setSiteOwnerName("Holly");
		assertEquals("Holly", sorb.getSiteOwnerName());
		sorb.setSiteName("Galway");
		assertEquals("Galway", sorb.getSiteName());
		sorb.setSiteOwner(siteOwner);
		assertEquals(siteOwner, sorb.getSiteOwner());
		sorb.setSiteOwnerEmail("newemail");
		assertEquals("newemail", sorb.getSiteOwnerEmail());
		sorb.setSiteOwnerPassword("newpass");
		assertEquals("newpass", sorb.getSiteOwnerPassword());
		sorb.setUsername("newusername");
		assertEquals("newusername", sorb.getUsername());
		
	}
	
}
