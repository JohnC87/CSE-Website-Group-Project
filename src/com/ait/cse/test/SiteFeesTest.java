package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.cse.SiteFees;

import org.junit.Before;

public class SiteFeesTest {
	SiteFees sf;

	@Before
	public void start() {
		sf = new SiteFees();
	}

	@Test
	public void test() {
		sf.setMonth("January");
		sf.setPayment(true);
		assertTrue(sf.isPayment());
		assertTrue(sf.getMonth().equals("January"));
	}

}
