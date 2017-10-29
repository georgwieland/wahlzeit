/*
 * Classname: CoordinateTest
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
 * Test class for {@link Coordinate} which contains all test cases.
 *
 */
public class CoordinateTest {
	Coordinate defaultCoordinate;
	Coordinate parameterizedCoordinate;
	
	@Before
	public void setupCoordinates() {
		defaultCoordinate = new Coordinate();
		parameterizedCoordinate = new Coordinate(1.0, 2.0, 3.0);
	}
	
	//*************************************************************************
	//							Coordinate.constructors
	//*************************************************************************
	@Test
	public void testDefaultConstructor() {
		assertEquals(0.0, defaultCoordinate.getX(), 0.0);
		assertEquals(0.0, defaultCoordinate.getY(), 0.0);
		assertEquals(0.0, defaultCoordinate.getZ(), 0.0);
	}
	
	@Test
	public void testParameterizedConstructor() {
		assertEquals(1.0, parameterizedCoordinate.getX(), 0.0);
		assertEquals(2.0, parameterizedCoordinate.getY(), 0.0);
		assertEquals(3.0, parameterizedCoordinate.getZ(), 0.0);
	}
	
	
	//*************************************************************************
	//							Coordinate.set-/get-
	//*************************************************************************
	@Test
	public void testSetterAndGetter() {
		defaultCoordinate.setX(3);
		defaultCoordinate.setY(4);
		defaultCoordinate.setZ(5);
		assertEquals(3.0, defaultCoordinate.getX(), 0.0);
		assertEquals(4.0, defaultCoordinate.getY(), 0.0);
		assertEquals(5.0, defaultCoordinate.getZ(), 0.0);
	}
	
	
	//*************************************************************************
	//							Coordinate.getDistance
	//*************************************************************************
	@Test
	public void testGetDistanceNull() {
		//check null value
		assertEquals(Double.NaN, defaultCoordinate.getDistance(null), 0.0);
	}
	
	@Test
	public void testGetDistanceItself() {
		assertEquals(0, defaultCoordinate.getDistance(defaultCoordinate), 0.0);
		assertEquals(0, parameterizedCoordinate.getDistance(parameterizedCoordinate), 0.0);
	}
	
	@Test
	public void testGetDistanceCalculation() {		
		assertEquals(3.741657, defaultCoordinate.getDistance(parameterizedCoordinate), 0.000001);	
		assertEquals(3.741657, parameterizedCoordinate.getDistance(defaultCoordinate), 0.000001);
	}
	
	
	//*************************************************************************
	//							Coordinate.isEqual
	//*************************************************************************
	@Test
	public void testIsEqualNull() {
		assertFalse(defaultCoordinate.isEqual(null));
	}
	
	@Test
	public void testIsEqualSameObject() {
		assertTrue(defaultCoordinate.isEqual(defaultCoordinate));
	}
	
	@Test
	public void testIsEqualNotEqual() {
		assertFalse(defaultCoordinate.isEqual(parameterizedCoordinate));
	}
	
	
	//*************************************************************************
	//							Coordinate.equals
	//*************************************************************************
	@Test
	public void testEqualNull() {
		assertFalse(defaultCoordinate.equals(null));
	}
	
	@Test
	public void testEqualSameObject() {
		assertTrue(defaultCoordinate.equals(defaultCoordinate));
	}
	
	@Test
	public void testEqualOtherObjectType() {
		assertFalse(defaultCoordinate.equals(new Object()));
	}
	
	@Test
	public void testEqualNotEqual() {
		assertFalse(defaultCoordinate.equals(parameterizedCoordinate));
		assertFalse(parameterizedCoordinate.equals(new Coordinate(2.0, 2.0, 3.0)));
		assertFalse(parameterizedCoordinate.equals(new Coordinate(1.0, 1.0, 3.0)));
		assertFalse(parameterizedCoordinate.equals(new Coordinate(1.0, 2.0, 2.0)));
	}

	//*************************************************************************
	//		Coordinate.hashcode
	//*************************************************************************
	@Test
	public void testHashCode() {
		assertEquals(parameterizedCoordinate.hashCode(), parameterizedCoordinate.hashCode());
	}
}
