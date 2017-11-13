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

	private Fish fish1;
	private Fish fish2;
	private Fish fish3;
	
	@Before
	public void setupFish() {
		fish1 = new Fish();
		fish2 = new Fish("Dorade");
		fish3 = new Fish("Zander", 80.5, true);
	}
	
	//*************************************************************************
	//		Fish.constructors
	//*************************************************************************
	@Test
	public void testConstructors() {
		assertNotNull(fish1);
		assertNotNull(fish2);
		assertNotNull(fish3);
	}
	
	//*************************************************************************
	//		Fish.set-/get-methods
	//*************************************************************************
	@Test
	public void testGetter() {
		assertEquals("", fish1.getName());
		assertEquals(0.0, fish1.getSize(), 1E-5);
		assertEquals(false, fish1.isPredator());
		
		assertEquals("Dorade", fish2.getName());
		assertEquals(0.0, fish2.getSize(), 1E-5);
		assertEquals(false, fish2.isPredator());
		
		assertEquals("Zander", fish3.getName());
		assertEquals(80.5, fish3.getSize(), 1E-5);
		assertEquals(true, fish3.isPredator());
	}
	
	@Test
	public void testSetter() {
		fish3.setName("Hummer");;
		fish3.setAverageSize(50.33);
		fish3.setPredator(false);
		
		assertEquals("Hummer", fish3.getName());
		assertEquals(50.33, fish3.getSize(), 1E-5);
		assertEquals(false, fish3.isPredator());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNameNull() {
		fish3.setName(null);
	}
}
