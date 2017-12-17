/*
 * Classname: CartesianCoordinateTest
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
 * Test class for {@link CartesianCoordinate} which contains all test cases.
 *
 */
public class CartesianCoordinateTest {
	CartesianCoordinate defaultCoordinate;
	CartesianCoordinate parameterizedCoordinate;
	
	@Before
	public void setupCoordinates() throws CoordinateException {
		defaultCoordinate = CartesianCoordinate.createCartesianCoordinate();
		parameterizedCoordinate = CartesianCoordinate.createCartesianCoordinate(1.0, 2.0, 3.0);
	}
	
	//*************************************************************************
	//							CartesianCoordinate.constructors
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
	
	@Test
	public void testObjectCreation() throws CoordinateException {
		CartesianCoordinate cartesianCoordinate1 = CartesianCoordinate.createCartesianCoordinate(1.0, 1.0, 1.0);
		CartesianCoordinate cartesianCoordinate2 = CartesianCoordinate.createCartesianCoordinate(1.0, 1.0, 1.0);
		assertEquals(cartesianCoordinate1, cartesianCoordinate2);
	}
			
	//*************************************************************************
	//							CartesianCoordinate.set-/get-
	//*************************************************************************
	@Test
	public void testSetterAndGetter() throws CoordinateException {
		assertEquals(1.0, parameterizedCoordinate.getX(), 0.0);
		assertEquals(2.0, parameterizedCoordinate.getY(), 0.0);
		assertEquals(3.0, parameterizedCoordinate.getZ(), 0.0);
	}
	
	
	//*************************************************************************
	//							CartesianCoordinate.getDistance
	//*************************************************************************
	@Test(expected = CoordinateException.class)
	public void testGetDistanceNull() throws CoordinateException {
		//check null value
		defaultCoordinate.getDistance(null);
	}
	
	@Test
	public void testGetDistanceItself() throws CoordinateException {
		assertEquals(0, defaultCoordinate.getDistance(defaultCoordinate), 0.0);
		assertEquals(0, parameterizedCoordinate.getDistance(parameterizedCoordinate), 0.0);
	}
	
	@Test
	public void testGetDistanceCalculation() throws CoordinateException {		
		assertEquals(3.741657, defaultCoordinate.getDistance(parameterizedCoordinate), 0.000001);	
		assertEquals(3.741657, parameterizedCoordinate.getDistance(defaultCoordinate), 0.000001);
	}
	
	@Test(expected = CoordinateException.class)
	public void testGetCaresianDistanceNull() throws CoordinateException {	
		defaultCoordinate.getCartesianDistance(null);
	}
	
	@Test
	public void testGetCaresianDistanceCalculation() throws CoordinateException {		
		assertEquals(3.741657, defaultCoordinate.getCartesianDistance(parameterizedCoordinate), 0.000001);	
		assertEquals(3.741657, parameterizedCoordinate.getCartesianDistance(defaultCoordinate), 0.000001);
	}
	
	@Test(expected = CoordinateException.class)
	public void testSphericDistanceNull() throws CoordinateException {	
		defaultCoordinate.getSphericDistance(null);
	}
	
	@Test
	public void testGetSphericDistanceCalculation() throws CoordinateException {	
		CartesianCoordinate coordinateIncrXYZ = CartesianCoordinate.createCartesianCoordinate( 1, 0, 0);
		assertEquals(1, defaultCoordinate.getSphericDistance(coordinateIncrXYZ), 0.000001);	
	}
	
	//*************************************************************************
	//							CartesianCoordinate.asCoordinate methods
	//*************************************************************************
	@Test
	public void testAsSphericCoordinate() throws CoordinateException {	
		assertEquals(defaultCoordinate, defaultCoordinate.asSphericCoordinate().asCartesianCoordinate());
	}
	
	@Test
	public void testAsCartesianCoordinate() throws CoordinateException {	
		assertEquals(defaultCoordinate, defaultCoordinate.asCartesianCoordinate());
	}
	
	//*************************************************************************
	//							CartesianCoordinate.isEqual
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
		assertTrue(parameterizedCoordinate.isEqual(CartesianCoordinate.createCartesianCoordinate(1.0, 2.0, 3.0)));
		CartesianCoordinate cartesianCoordinate1 = CartesianCoordinate.createCartesianCoordinate(1.00025, 2.00025, 3.00025);
		assertFalse(cartesianCoordinate1.isEqual(CartesianCoordinate.createCartesianCoordinate(1.00024, 2.00024, 3.00024)));
		CartesianCoordinate cartesianCoordinate2 = CartesianCoordinate.createCartesianCoordinate(1.000025, 2.000025, 3.000025);
		assertTrue(cartesianCoordinate2.isEqual(CartesianCoordinate.createCartesianCoordinate(1.000024, 2.000024, 3.000024)));
	}
	
	//*************************************************************************
	//							CartesianCoordinate.equals
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
		assertFalse(parameterizedCoordinate.equals(CartesianCoordinate.createCartesianCoordinate(2.0, 2.0, 3.0)));
		assertFalse(parameterizedCoordinate.equals(CartesianCoordinate.createCartesianCoordinate(1.0, 1.0, 3.0)));
		assertFalse(parameterizedCoordinate.equals(CartesianCoordinate.createCartesianCoordinate(1.0, 2.0, 2.0)));
	}
	
	@Test
	public void testEqualSameDataDifferentObjects() throws CoordinateException {
		assertTrue(parameterizedCoordinate.equals(CartesianCoordinate.createCartesianCoordinate(1.0, 2.0, 3.0)));
	}

	//*************************************************************************
	//		CartesianCoordinate.hashcode
	//*************************************************************************
	@Test
	public void testHashCode() {
		assertEquals(parameterizedCoordinate.hashCode(), parameterizedCoordinate.hashCode());
	}

} //end of class CartesianCoordinateTest
