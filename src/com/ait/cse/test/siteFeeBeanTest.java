package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.cse.siteFeeBean;

import org.junit.Before;

public class siteFeeBeanTest {

	siteFeeBean sfb;

	@Before
	public void Before() {
		sfb = new siteFeeBean();
		sfb.init();
	}

	@Test
	public void test() {
		assertEquals(sfb.getFees(), sfb.getFees());
	}

}
