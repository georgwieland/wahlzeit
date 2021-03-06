/*
 * Classname: SphericCoordinateTest
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
 * Test class for {@link SphericCoordinate} which contains all test cases.
 *
 */
public class SphericCoordinateTest {
	
	SphericCoordinate defaultCoordinate;
	SphericCoordinate parameterizedCoordinate;

	@Before
	public void setupCoordinates() throws CoordinateException {
		defaultCoordinate = SphericCoordinate.createSphericCoordinate();
		parameterizedCoordinate =SphericCoordinate.createSphericCoordinate(1.0, Math.PI/2, Math.PI);
	}
	
	//*************************************************************************
	//				SphericCoordinate.constructors
	//*************************************************************************
	@Test
	public void testDefaultConstructor() {
		assertEquals(0.0, defaultCoordinate.getRadius(), 0.0);
		assertEquals(0.0, defaultCoordinate.getLongitude(), 0.0);
		assertEquals(0.0, defaultCoordinate.getLatitude(), 0.0);
	}
	
	@Test
	public void testParameterizedConstructor() {
		assertEquals(1.0, parameterizedCoordinate.getRadius(), 0.0);
		assertEquals(Math.PI/2, parameterizedCoordinate.getLongitude(), 0.0);
		assertEquals(Math.PI, parameterizedCoordinate.getLatitude(), 0.0);
	}
	
	@Test
	public void testObjectCreation() throws CoordinateException {
		SphericCoordinate sphericCoordinate1 = SphericCoordinate.createSphericCoordinate(1.0, 1.0, 1.0);
		SphericCoordinate sphericCoordinate2 = SphericCoordinate.createSphericCoordinate(1.0, 1.0, 1.0);
		assertEquals(sphericCoordinate1,sphericCoordinate2);
	}
	
	//*************************************************************************
	//				SphericCoordinate.set-/get-
	//*************************************************************************
	@Test
	public void testSetterAndGetter() throws CoordinateException {
		SphericCoordinate sphericCoordinate = SphericCoordinate.createSphericCoordinate(3, Math.PI/4, Math.PI/2);
		assertEquals(3.0, sphericCoordinate.getRadius(), 0.0);
		assertEquals(Math.PI/4, sphericCoordinate.getLongitude(), 0.0);
		assertEquals(Math.PI/2, sphericCoordinate.getLatitude(), 0.0);
	}
	
	//*************************************************************************
	//				SphericCoordinate.getDistance
	//*************************************************************************
	@Test(expected = CoordinateException.class)
	public void testGetDistanceNull() throws CoordinateException {
		//check null value
		defaultCoordinate.getDistance(null);
	}
	
	@Test
	public void testGetDistanceItself() throws CoordinateException {
		assertEquals(0, defaultCoordinate.getDistance(defaultCoordinate), 0.0);
		assertEquals(0, parameterizedCoordinate.getDistance(parameterizedCoordinate), 0.000001);
	}
	
	@Test
	public void testGetDistanceCalculation() throws CoordinateException {		
		SphericCoordinate sphericCoordinate = SphericCoordinate.createSphericCoordinate(1.0, Math.PI/4, Math.PI);
		assertEquals(1, defaultCoordinate.getDistance(sphericCoordinate), 0.000001);
		assertEquals(0.76536686, parameterizedCoordinate.getDistance(sphericCoordinate), 0.000001);
	}
	
	@Test(expected = CoordinateException.class)
	public void testGetCaresianDistanceNull() throws CoordinateException {	
		defaultCoordinate.getCartesianDistance(null);
	}
	
	@Test
	public void testGetCaresianDistanceCalculation() throws CoordinateException {	
		SphericCoordinate sphericCoordinate = SphericCoordinate.createSphericCoordinate( 1, 0, 0);
		assertEquals(1, defaultCoordinate.getCartesianDistance(sphericCoordinate), 0.000001);	
	}
	
	@Test(expected = CoordinateException.class)
	public void testSphericDistanceNull() throws CoordinateException {	
		defaultCoordinate.getSphericDistance(null);
	}
	
	@Test
	public void testGetSphericDistanceCalculation() throws CoordinateException {	
		CartesianCoordinate cartesianCoordinate = CartesianCoordinate.createCartesianCoordinate( 1, 0, 0);
		assertEquals(1, defaultCoordinate.getSphericDistance(cartesianCoordinate), 0.0);	
	}

	//*************************************************************************
	//				SphericCoordinate.asCoordinate methods
	//*************************************************************************
	@Test
	public void testAsCartesianCoordinate() throws CoordinateException {	
		assertEquals(defaultCoordinate, defaultCoordinate.asCartesianCoordinate().asSphericCoordinate());
	}
	
	@Test
	public void testAsSphericCoordinate() throws CoordinateException {	
		assertEquals(defaultCoordinate, defaultCoordinate.asSphericCoordinate());
	}
	//*************************************************************************
	//				SphericCoordinate.isEqual
	//*************************************************************************
	@Test
	public void testIsEqualNull() throws CoordinateException {
		assertFalse(defaultCoordinate.isEqual(null));
	}
	
	@Test
	public void testIsEqualSameObject() throws CoordinateException {
		assertTrue(defaultCoordinate.isEqual(defaultCoordinate));
	}
	
	@Test
	public void testIsEqualNotEqual() throws CoordinateException {
		assertFalse(defaultCoordinate.isEqual(parameterizedCoordinate));
	}
	
	@Test
	public void testIsEqualSameDataDifferentObjects() throws CoordinateException {
		assertTrue(parameterizedCoordinate.isEqual(SphericCoordinate.createSphericCoordinate(1.0, Math.PI/2, Math.PI)));
		SphericCoordinate sphericCoordinate1 = SphericCoordinate.createSphericCoordinate(1.0 + 0.00025, (Math.PI/2) + 0.00025, Math.PI - 0.00025);
		assertFalse(sphericCoordinate1.isEqual(SphericCoordinate.createSphericCoordinate(1.0 + 0.00024, (Math.PI/2) + 0.00024, Math.PI - 0.00024)));
		SphericCoordinate sphericCoordinate2 = SphericCoordinate.createSphericCoordinate(1.0 + 0.000025, (Math.PI/2) + 0.000025, Math.PI - 0.000025);
		assertTrue(sphericCoordinate2.isEqual(SphericCoordinate.createSphericCoordinate(1.0 + 0.000024, (Math.PI/2) + 0.000024, Math.PI - 0.000024)));
	}
	
	//*************************************************************************
	//				SphericCoordinate.equals
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
	public void testEqualNotEqual() throws CoordinateException {
		assertFalse(defaultCoordinate.equals(parameterizedCoordinate));
		assertFalse(parameterizedCoordinate.equals(SphericCoordinate.createSphericCoordinate(2.0, Math.PI/2, Math.PI)));
		assertFalse(parameterizedCoordinate.equals(SphericCoordinate.createSphericCoordinate(1.0, Math.PI, Math.PI)));
		assertFalse(parameterizedCoordinate.equals(SphericCoordinate.createSphericCoordinate(1.0, Math.PI/2, Math.PI/2)));
	}
	
	@Test
	public void testEqualSameDataDifferentObjects() throws CoordinateException {
		assertTrue(parameterizedCoordinate.equals(SphericCoordinate.createSphericCoordinate(1.0, Math.PI/2, Math.PI)));
	}
	
	//*************************************************************************
	//				SphericCoordinate.equals
	//*************************************************************************
	@Test(expected = CoordinateException.class)
	public void testAssertPositiveRadius() throws CoordinateException {
		SphericCoordinate sphericCoordinate = SphericCoordinate.createSphericCoordinate(-1.2, 0, 0);
	}
	
	@Test(expected = CoordinateException.class)
	public void testAssertIsValidLongitude() throws CoordinateException {
		SphericCoordinate sphericCoordinate = SphericCoordinate.createSphericCoordinate(2, -4, 0);
	}
	
	@Test(expected = CoordinateException.class)
	public void testAssertIsValidLatitude() throws CoordinateException {
		SphericCoordinate sphericCoordinate = SphericCoordinate.createSphericCoordinate(2, 2, 4);
	}
		
	//*************************************************************************
	//				SphericCoordinate.hashcode
	//*************************************************************************
	@Test
	public void testHashCode() {
		assertEquals(parameterizedCoordinate.hashCode(), parameterizedCoordinate.hashCode());
	}
}//end of class SphericCoordinateTest
