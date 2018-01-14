/*
 * Classname: FishPhotoTest
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
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

/**
 * Test class for {@link FishPhoto}. Contains all test cases.
 *
 */
public class FishPhotoTest {

	private FishPhoto photo1;
	private FishPhoto photo2;
	private FishPhoto photo3;
	private FishPhoto photo4;
	
	private Fish fish;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setupFishPhoto() {
		fish = new Fish(1, new FishType("Rotlachs"), 90.0);
		
		photo1 = new FishPhoto();
		
		PhotoId id1 = new PhotoId(998);
		photo2 = new FishPhoto(id1);
		
		photo3 = new FishPhoto(fish);
		
		PhotoId id2 = new PhotoId(999);
		photo4 = new FishPhoto(id2, fish);
	}

	//*************************************************************************
	//		FishPhoto.constructors
	//*************************************************************************
	@Test
	public void testConstructors() {
		assertNotNull(photo1);
		assertNotNull(photo2);
		assertNotNull(photo3);
		assertNotNull(photo4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNull() {
		PhotoId id = new PhotoId(998);
		FishPhoto photo = new FishPhoto(id, null);
	}
	
	//*************************************************************************
	//		FishPhoto.set-/get-methods
	//*************************************************************************
	@Test
	public void testGetter() {
		assertNotNull(photo2.getId());
        assertEquals(998, photo2.getId().asInt());
        
        assertNotNull(photo3.getFish());
        
        assertNotNull(photo4.getFish());
        assertNotNull(photo4.getId());
        assertEquals(999, photo4.getId().asInt());
	}

	@Test
	public void testSetter() {
		photo1.setFish(fish);
		assertNotNull(photo1.getFish());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetterNull() {
		photo1.setFish(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNameNull() {
		photo4.setFish(null);
	}
}
