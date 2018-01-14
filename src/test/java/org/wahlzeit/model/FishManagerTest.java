/*
 * Classname: FishManagerTest
 * 
 * Copyright (c) 2017 by Georg Wieland
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Test class for {@link FishManager}. Contains all test cases.
 *
 */
public class FishManagerTest {
	FishType fishtype1;
	FishType fishtype2;
	Fish fish1;
	Fish fish2;
	
	@Before
	public void setupFish() {
		fishtype1 = new FishType("Rotlachs");
		fishtype2 = new FishType("Zander", true);
		fish1 = new Fish(1, fishtype1, 90.0);
		fish2 = new Fish(2, fishtype2, 80.5);
	}
	
	//*************************************************************************
	//		FishManager.getInstance
	//*************************************************************************
	@Test
	public void testGetInstance() {
		assertNotNull(FishManager.getInstance());
		assertEquals(FishManager.getInstance(), FishManager.getInstance());
	}
	
	//*************************************************************************
	//		FishManager.createFish
	//*************************************************************************
	@Test
	public void testCreateFish() {		
		assertEquals(fish1, FishManager.getInstance().createFish(1234, fishtype1.getName(), 90.0));
		assertEquals(fish1, FishManager.getInstance().createFish(1234, fishtype1.getName(), 90.0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateFishNull() {
		FishManager.getInstance().createFish(1234, null, 90.0);
	}
	
	
	//*************************************************************************
	//		FishManager.createFishType
	//*************************************************************************
	@Test
	public void testCreateFishType() {		
		assertEquals(fishtype1, FishManager.getInstance().createFishType("Rotlachs", false));
		assertEquals(fishtype1, FishManager.getInstance().createFishType("Rotlachs", false));
		assertEquals(fishtype2, FishManager.getInstance().createFishType("Zander", true));
		assertEquals(fishtype2, FishManager.getInstance().createFishType("Zander", true));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateFishTypeNull() {		
		FishManager.getInstance().createFishType(null, false);
	}

	//*************************************************************************
	//		FishManager.getFishType
	//*************************************************************************
	
	@Test
	public void testGetFishType() {		
		assertEquals(fishtype1, FishManager.getInstance().getFishType("Rotlachs"));
		assertEquals(fishtype2, FishManager.getInstance().getFishType("Zander"));
		assertEquals(new FishType("Dorade"), FishManager.getInstance().getFishType("Dorade"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetFishTypeNull() {		
		FishManager.getInstance().getFishType(null);
	}
	
}//end of class FishManagerTest
