/*
 * Classname: FishPhotoFactoryTest
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
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

/**
 * 
 * Test class for {@link FishPhotoFactory}. Contains all test cases.
 *
 */
public class FishPhotoFactoryTest {

	private FishPhotoFactory factory;
	
	@ClassRule
    public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider())
            .around(new RegisteredOfyEnvironmentProvider());
	
	@Before
    public void setupFishPhotoFactoryTest() {
		factory = FishPhotoFactory.getInstance();
	}
	
	//*************************************************************************
	//		FishPhotoFactory construction
	//*************************************************************************
	@Test
	public void testConstruction() {
		assertNotNull(factory);		
	}
	
	//*************************************************************************
	//		FishPhotoFactory factory methods
	//*************************************************************************
	@Test
	public void testCreateWithoutId() {
		FishPhoto photo = factory.createPhoto();
		assertNotNull(photo);
	}
	
	@Test
	public void testCreateWithId() {
		PhotoId id2 = new PhotoId(999);
		FishPhoto photo = factory.createPhoto(id2);
		assertNotNull(photo);
		assertEquals(999, photo.getId().asInt());
	}
	
	
	@Test
	public void testCreateWithFishObject() {
		Fish fish = new Fish();
		FishPhoto photo = factory.createPhoto(fish);
		assertNotNull(photo);
		assertEquals("", fish.getName());
		assertEquals(0.0, fish.getSize(), 1E-5);
		assertEquals(false, fish.isPredator());
	}
	
	@Test
	public void testCreateWithIdAndFishObject() {
		Fish fish = new Fish();
		PhotoId id2 = new PhotoId(999);
		FishPhoto photo = factory.createPhoto(id2, fish);
		assertNotNull(photo);
		assertEquals(999, photo.getId().asInt());
		assertEquals("", fish.getName());
		assertEquals(0.0, fish.getSize(), 1E-5);
		assertEquals(false, fish.isPredator());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateWithIdAndFishObjectNull() {
		PhotoId id = new PhotoId(999);
		FishPhoto photo = factory.createPhoto(id, null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSetInstanceTwice() {
		FishPhotoFactory.setInstance(factory);
	}
}
