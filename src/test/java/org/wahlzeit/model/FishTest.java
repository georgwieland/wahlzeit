/*
 * Classname: FishTest
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
 * Test class for {@link Fish}. Contains all test cases.
 *
 */
public class FishTest {

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
	//		Fish.constructors
	//*************************************************************************
	@Test
	public void testConstructors() {
		assertNotNull(fish1);
		assertNotNull(fish2);
	}
	
	//*************************************************************************
	//		Fish.set-/get-methods
	//*************************************************************************
	@Test
	public void testGetter() {
		assertEquals(90.0, fish1.getSize(), 1E-5);
		assertEquals(fishtype1, fish1.getFishType());
		assertEquals(1, fish1.getId());
		
		assertEquals(80.5, fish2.getSize(), 1E-5);
		assertEquals(fishtype2, fish2.getFishType());
		assertEquals(2, fish2.getId());
	}
	
	@Test
	public void testSetter() {
		fish2.setFishType(fishtype1);
		fish2.setSize(50.33);
		fish2.setId(1234);
		
		assertEquals(50.33, fish2.getSize(), 1E-5);
		assertEquals(fishtype1, fish2.getFishType());
		assertEquals(1234, fish2.getId());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetSizeNaN() {
		fish2.setSize(Double.NaN);
	}
	
	
	//*************************************************************************
	//		Fish.equals
	//*************************************************************************
	@Test
	public void testEquals() {		
		assertNotEquals(fish1, fish2);
		assertEquals(fish1, fish1);
	}
	
	@Test
	public void testHashCode() {		
		assertNotEquals(fish1.hashCode(), fish2.hashCode());
		assertEquals(fish1.hashCode(), fish1.hashCode());
	}
	
	
}//end of class FishTest
