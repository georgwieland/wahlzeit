/*
 * Classname: LocationTest
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Location} contains all test cases.
 *
 */
public class LocationTest {
	
	Location defaultLocation;
	Location parameterizedLocation;
	
	@Before
	public void setupLocation() throws CoordinateException {
		defaultLocation = new Location();
		parameterizedLocation = new Location(CartesianCoordinate.createCartesianCoordinate(1.0, 2.0, 3.0));
	}
	
	//*************************************************************************
	//		Location.constructors
	//*************************************************************************
	@Test
	public void testParameterizedConstructor() throws CoordinateException {
		assertEquals(CartesianCoordinate.createCartesianCoordinate(1.0, 2.0, 3.0), parameterizedLocation.getCoordinate());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParameterizedConstructorNull() {
		parameterizedLocation = new Location(null);
	}
	
	//*************************************************************************
	//		Location.set-/get-
	//*************************************************************************
	@Test
	public void testSetAndGet() throws CoordinateException {
		defaultLocation.setCoordinate(CartesianCoordinate.createCartesianCoordinate(2.0, 2.0, 2.0));
		assertEquals(CartesianCoordinate.createCartesianCoordinate(2.0, 2.0, 2.0), defaultLocation.getCoordinate());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNull() {
		defaultLocation.setCoordinate(null);
	}

	
	//*************************************************************************
	//		Location.equals
	//*************************************************************************
	@Test
	public void testEqualNull() {
		assertFalse(defaultLocation.equals(null));
	}
	
	@Test
	public void testEqualSameObject() {
		assertTrue(defaultLocation.equals(defaultLocation));
	}
	
	@Test
	public void testEqualOtherObjectType() {
		assertFalse(defaultLocation.equals(new Object()));
	}
	
	@Test
	public void testEqualNotEqual() throws CoordinateException {
		defaultLocation.setCoordinate(CartesianCoordinate.createCartesianCoordinate());
		assertFalse(defaultLocation.equals(parameterizedLocation));
	}
	
	
	//*************************************************************************
	//		Location.hashcode
	//*************************************************************************
	@Test
	public void testHashCode() {
		assertEquals(parameterizedLocation.hashCode(), parameterizedLocation.hashCode());
	}
}//end of class LocationTest
