/*
 * Classname: CartesianCoordinate
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

import java.util.HashMap;

import org.wahlzeit.utils.DoubleUtil;

/**
 * CartesianCoordinate is represented by a x, y and cartesian coordinate.
 */
public final class CartesianCoordinate extends AbstractCoordinate {
	
	//x coordinate
	private final double x;
	
	//y coordinate
	private final double y;
	
	//z coordinate
	private final double z;
	
	//Precision for double equality comparison
	private static final double PRECISION = 1E-5;
	
	//holds all existing cartesiancoordinate value objects
	private static final HashMap<Integer, CartesianCoordinate> sharedCartesianCoordinate = new HashMap<>();
	
	/**
	 * Constructs a CartesianCoordinate.
	 * @throws CoordinateException 
	 * 
	 * @methodtype constructor
	 * @methodproperties convenience
	 */
	private CartesianCoordinate() throws CoordinateException {
		this(0.0, 0.0, 0.0);
	}
	
	/**
	 * Constructs a CartesianCoordinate object with the given arguments.
	 * 
	 * @methodtype constructor
	 * 
	 * @invariant will be checked after instantiation
	 * 
	 * @precondition (value != NaN)
	 * 
	 * @param x
	 * x coordinate for initialization.
	 * 
	 * @param y
	 * y coordinate for initialization.
	 * 
	 * @param z
	 * z coordinate for initialization.
	 * @throws CoordinateException 
	 */
	private CartesianCoordinate(double x, double y, double z) throws CoordinateException {
		try {
			assertIsValidCoordinateValue(x);
			assertIsValidCoordinateValue(y);
			assertIsValidCoordinateValue(z);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		//Check class invariants after instantiation. 
		//Not necessary for other constructors because they are just convenience constructors which call this one
		assertImplementationClassInvariant();
	}
	
	
	/**
	 * 
	 * @methodtype factory
	 * 
	 * @param radius
	 * @param longitude
	 * @param latitude
	 * @return
	 * new or existing reference to sphericcoordinate object
	 * 
	 * @throws CoordinateException
	 */
	static public synchronized CartesianCoordinate createCartesianCoordinate(double x, double y, double z) throws CoordinateException {
		double tempX = DoubleUtil.trimDoubleValue(x, PRECISION);
		double tempY = DoubleUtil.trimDoubleValue(y, PRECISION);;
		double tempZ = DoubleUtil.trimDoubleValue(z, PRECISION);;
		
		Integer hash = calculateHashCode(tempX, tempY, tempZ);
		CartesianCoordinate newCartesianCoordinate = sharedCartesianCoordinate.get(hash);
		
		try {
			if (newCartesianCoordinate == null) {
				newCartesianCoordinate =  new CartesianCoordinate(x, y, z);
				sharedCartesianCoordinate.put(hash, newCartesianCoordinate);
				return newCartesianCoordinate;
			} else {
				return sharedCartesianCoordinate.get(hash);
			}
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
	}
	
	/**
	 * @methodtype factory
	 * 
	 * @methodproperties convenience
	 * 
	 * @return
	 * new or existing reference to sphericcoordinate object
	 * 
	 * @throws CoordinateException
	 */
	static public synchronized CartesianCoordinate createCartesianCoordinate() throws CoordinateException {
		return createCartesianCoordinate(0.0, 0.0, 0.0);
	}
	
	/**
	 * Get method for x coordinate.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant since object state will not be changed and the
	 * method is not that complex invariant check is not necessary
	 * 
	 * @return
	 * Return x coordinate
	 */
	public double getX() {
		return x;
	}


	/**
	 * Get method for y coordinate.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant since object state will not be changed and the
	 * method is not that complex invariant check is not necessary
	 * 
	 * @return
	 * Return y coordinate
	 */
	public double getY() {
		return y;
	}


	/**
	 * Get method for z coordinate.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant since object state will not be changed and the
	 * method is not that complex invariant check is not necessary
	 * 
	 * @return
	 * Return z coordinate
	 */
	public double getZ() {
		return z;
	}

	
	/**
	 * @throws CoordinateException 
	 * @see org.wahlzeit.model.Coordinate#getCartesianDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype get method
	 * 
	 * @invariant will be checked by AbstractCoordinate
	 * 
	 * @precondition will be checked by AbstractCoordinate
	 * 
	 * @postcondition will be checked by AbstractCoordinate
	 * 
	 */
	@Override
	protected double doGetCartesianDistance(Coordinate otherCoordinate) throws CoordinateException {		
		//get cartesian cartseian representation
		CartesianCoordinate cartesianCoordinate = otherCoordinate.asCartesianCoordinate();
		
		//calculate difference for x
		double tempDeltaX = cartesianCoordinate.getX() - this.x;
		//calculate difference for y
		double tempDeltaY = cartesianCoordinate.getY() - this.y;
		//calculate difference for z
		double tempDeltaZ = cartesianCoordinate.getZ() - this.z;
		
		//calculate and return cartesian distance
		return Math.sqrt((tempDeltaX*tempDeltaX) + (tempDeltaY*tempDeltaY) + (tempDeltaZ*tempDeltaZ));
	}
	
	/**
	 * 
	 * @throws CoordinateException 
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype get method
	 * 
	 * @invariant will be checked by AbstractCoordinate
	 * 
	 * @precondition will be checked by AbstractCoordinate
	 * 
	 * @postcondition will be checked by AbstractCoordinate
	 * 
	 */
	@Override
	protected double doGetSphericDistance(Coordinate otherCoordinate) throws CoordinateException {
		return this.asSphericCoordinate().getDistance(otherCoordinate);
	}
	
	/**
	 *
	 * @throws CoordinateException 
	 * @see org.wahlzeit.model.Coordinate#asCartestianCoordinate()
	 * 
	 * @methodtype conversion method
	 * 
	 * @invariant will be checked by AbstractCoordinate
	 * 
	 * @precondition will be checked by AbstractCoordinate
	 * 
	 * @postcondition will be checked by AbstractCoordinate
	 * 
	 */
	@Override
	protected CartesianCoordinate doAsCartesianCoordinate() throws CoordinateException {
		return CartesianCoordinate.createCartesianCoordinate(this.x, this.y, this.z);
	}
	
	/**
	 * 
	 * @see org.wahlzeit.model.Coordinate#asSphericCoordinate()
	 * 
	 * @methodtype conversion method
	 * 
	 * @invariant will be checked by AbstractCoordinate
	 * 
	 * @precondition will be checked by AbstractCoordinate
	 * 
	 * @postcondition will be checked by AbstractCoordinate
	 * 
	 */
	@Override
	protected SphericCoordinate doAsSphericCoordinate() throws CoordinateException{
		//radius
		double radius = Math.sqrt((this.x*this.x) + (this.y*this.y) + (this.z*this.z));
		
		//check for zero and NaN value
		if (DoubleUtil.compareDoubles(radius, 0.0, PRECISION) || Double.isNaN(radius)) {
			return SphericCoordinate.createSphericCoordinate(0.0, 0.0, 0.0);
		}

		//longitude ->  horizontal meaning east-west axis
		double longitude = Math.acos(this.z / radius);
		
		//latitude -> vertical meaning north-south axis
		double latitude = Math.atan2(this.y , this.x); 	//using atan2 because you can pass two arguments and don't have to worry about division by zero
		
		return SphericCoordinate.createSphericCoordinate(radius, longitude, latitude);
	}
	
	/**
	 * Compares two CartesianCoordinate objects for equality.
	 *  
	 * @methodtype 
	 * bolean query method
	 * 
	 * @invariant will be checked by AbstractCoordinate
	 * 
	 * @precondition will be checked by AbstractCoordinate
	 * 
	 * @postcondition will be checked by AbstractCoordinate
	 *   
	 * @param otherCoordinate
	 * Other CartesianCoordinate object for comparison.
	 * 
	 * @return
	 * True if equal otherwise false.
	 * @throws CoordinateException 
	 */
	@Override
	protected boolean doIsEqual(Coordinate otherCoordinate) throws CoordinateException {
		//get cartesian representation
		CartesianCoordinate cartesianCoordinate = otherCoordinate.asCartesianCoordinate();
		
		return this == cartesianCoordinate;
	}


	/**
	 * It is recommended to override the hashcode method when overriding the equals method 
	 * because equal objects may get different hash-values. This may lead to not properly 
	 * working hash based collections.
	 */
	@Override
	public int hashCode() {
		//check class invariant before
		assertImplementationClassInvariant();
		
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		//check class invariant after
		assertImplementationClassInvariant();
		
		return result;
	}	
	
	/**
	 * Calculates hashcode for the specified arguments.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 * Hash value.
	 */
	private static int calculateHashCode(double x, double y, double z) {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
				
		return result;
	}
	
	/**
	 * Check if value is not NaN
	 * 
	 * @param value
	 * Value which will be checked
	 */
	private void assertIsValidCoordinateValue(double value) {
		if (Double.isNaN(value)) {
			throw new IllegalArgumentException("Value should not be NaN.");
		}
	}
	
	/**
	 * Checks if 
	 * 		x != NaN
	 * 		y != NaN
	 * 		z != NaN
	 * 
	 * @methodtype assertion
	 */
	@Override
	protected void assertImplementationClassInvariant() {
		//check radius
		assert (!Double.isNaN(x));
		
		//check longitude
		assert (!Double.isNaN(y));
		
		//check latitude
		assert (!Double.isNaN(z));
	}
}//end of class CartesianCoordinate

