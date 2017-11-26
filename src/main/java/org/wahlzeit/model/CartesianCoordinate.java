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

/**
 * CartesianCoordinate is represented by a x, y and cartesian coordinate.
 */
public class CartesianCoordinate implements Coordinate{
	
	//x coordinate
	private double x;
	
	//y coordinate
	private double y;
	
	//z coordinate
	private double z;
	
	//Precision for double equality comparison
	private static final double PRECISION = 1E-5;
	
	
	/**
	 * Constructs a CartesianCoordinate.
	 * 
	 * @methodtype constructor
	 * @methodproperties convenience
	 */
	public CartesianCoordinate() {
		this(0.0, 0.0, 0.0);
	}
	
	/**
	 * Constructs a CartesianCoordinate object with the given arguments.
	 * 
	 * @methodtype constructor
	 * @param x
	 * x coordinate for initialization.
	 * 
	 * @param y
	 * y coordinate for initialization.
	 * 
	 * @param z
	 * z coordinate for initialization.
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Copy constructor
	 * 
	 * @methodtype constructor
	 * @methodproperties convenience
	 * @param otherCoordinate
	 * CartesianCoordinate object to copy.
	 */
	public CartesianCoordinate(CartesianCoordinate otherCoordinate) {
		this(otherCoordinate.getX(), otherCoordinate.getY(), otherCoordinate.getZ());
	}
	
	/**
	 * Get method for x coordinate.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Return x coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * Set method for x coordinate.
	 * 
	 * @methodtype 
	 * set method
	 * 
	 * @param x
	 * x coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Get method for y coordinate.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Return y coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * Set method for y coordinate.
	 * 
	 * @methodtype 
	 * set method
	 * 
	 * @param y
	 * y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Get method for z coordinate.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Return z coordinate
	 */
	public double getZ() {
		return z;
	}

	/**
	 * Set method for z coordinate.
	 * 
	 * @methodtype 
	 * set method
	 * 
	 * @param z
	 * z coordinate
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Calculates the cartesian distance.
	 * 
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @param otherCoordinate
	 * Other CartesianCoordinate object for distance calculation.
	 * 
	 * @return
	 * Calculated cartesian distance.
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) {
		//check for Null value
		if (otherCoordinate == null) {
			return Double.NaN;
		}
		
		return this.getCartesianDistance(otherCoordinate);
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#getCartesianDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype get method
	 */
	@Override
	public double getCartesianDistance(Coordinate otherCoordinate) {
		
		//check for Null value
		if (otherCoordinate == null) {
			return Double.NaN;
		}
		
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
	 * @see org.wahlzeit.model.Coordinate#asCartestianCoordinate()
	 * 
	 * @methodtype conversion method
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate(this);
	}

	/**
	 * 
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype get method
	 */
	@Override
	public double getSphericDistance(Coordinate otherCoordinate) {
		return this.asSphericCoordinate().getDistance(otherCoordinate);
	}

	/**
	 * 
	 * @see org.wahlzeit.model.Coordinate#asSphericCoordinate()
	 * 
	 * @methodtype conversion method
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		//radius
		double radius = Math.sqrt((this.x*this.x) + (this.y*this.y) + (this.z*this.z));
		
		//check for zero and NaN value
		if (compareDoubles(radius, 0.0) || Double.isNaN(radius)) {
			return new SphericCoordinate();
		}

		//longitude ->  horizontal meaning east-west axis
		double longitude = Math.acos(this.z / radius);
		
		//latitude -> vertical meaning north-south axis
		double latitude = Math.atan2(this.y , this.x); 	//using atan2 because you can pass two arguments and don't have to worry about division by zero
		
		return new SphericCoordinate(radius, longitude, latitude);
	}
	
	/**
	 * Compares two CartesianCoordinate objects for equality.
	 * 
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * bolean query method
	 * 
	 * @param otherCoordinate
	 * Other CartesianCoordinate object for comparison.
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	@Override
	public boolean isEqual(Coordinate otherCoordinate) {
		if (otherCoordinate == null) {
			return false;
		}
		
		//get cartesian cartseian representation
		CartesianCoordinate cartesianCoordinate = otherCoordinate.asCartesianCoordinate();
		
		return ((compareDoubles(this.x, cartesianCoordinate.getX())) && 
				(compareDoubles(this.y, cartesianCoordinate.getY())) && 
				(compareDoubles(this.z, cartesianCoordinate.getZ())));
	}

	/**
	 * Overriding equals method.
	 * 
	 * @methodtype 
	 * bolean query method
	 */
	@Override
	public boolean equals(Object obj) {	
		
		//check for comparison with itself
		if (obj == this) {
			return true;
		}
		
		//check for Null value
		if (obj == null) {
			return false;
		}
		
		//Check if obj is an instance of class CartesianCoordinate
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		
		//comparing data by using isEqual-method
		return this.isEqual((Coordinate) obj);
	}
	
	/**
	 * It is recommended to override the hashcode method when overriding the equals method 
	 * because equal objects may get different hash-values. This may lead to not properly 
	 * working hash based collections.
	 */
	@Override
	public int hashCode() {
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
	 * Comparing two doubles taking rounding error into account.
	 * 
	 * @method type
	 * bolean query method
	 * 
	 * @param firstDouble
	 * First double value for comparison.
	 * 
	 * @param secondDouble
	 * Second double value for comparison.
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	private static boolean compareDoubles(double firstDouble, double secondDouble) {
		if (Double.isNaN(firstDouble) || Double.isNaN(secondDouble)) {
			return false;
		}
		//first substract and compare absolute value with PRECISION 
		return Math.abs(firstDouble - secondDouble) < PRECISION;
	}
}//end of class CartesianCoordinate

