package com.ait.cse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.cse.FarmersMarketUserDatabase;

import org.junit.Before;

public class FarmersMarketUserDatabaseTest {
	FarmersMarketUserDatabase fmud;

	@Before
	public void start() {
		fmud = new FarmersMarketUserDatabase();
	}

	@Test
	public void test() {
		fmud.setGalwayFee(false);
		fmud.setSligoFeePaid(true);
		assertFalse(fmud.isGalwayFeePaid());
		assertTrue(fmud.isSligoFeePaid());
	}

}
