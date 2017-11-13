/*
 * Classname: Coordinate
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
 * Coordinate is represented by a x, y and cartesian coordinate.
 */
public class Coordinate {
	
	//x coordinate
	private double x = 0.0;
	
	//y coordinate
	private double y = 0.0;
	
	//z coordinate
	private double z = 0.0;
	
	//Precision for double equality comparison
	private static final double PRECISION = 1E-5;
	
	/**
	 * Constructs a Coordinate.
	 */
	public Coordinate() {

	}
	
	/**
	 * Constructs a Coordinate object with the given arguments.
	 * 
	 * @param x
	 * x coordinate for initialization.
	 * 
	 * @param y
	 * y coordinate for initialization.
	 * 
	 * @param z
	 * z coordinate for initialization.
	 */
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	 * @methodtype 
	 * get method
	 * 
	 * @param otherCoordinate
	 * Other Coordinate object for distance calculation.
	 * 
	 * @return
	 * Calculated cartesian distance.
	 */
	public double getDistance(Coordinate otherCoordinate) {
		
		//check for Null value
		if (otherCoordinate == null) {
			return Double.NaN;
		}
		
		//calculate difference for x
		double tempDeltaX = otherCoordinate.getX() - this.x;
		//calculate difference for y
		double tempDeltaY = otherCoordinate.getY() - this.y;
		//calculate difference for z
		double tempDeltaZ = otherCoordinate.getZ() - this.z;
		
		//calculate and return cartesian distance
		return Math.sqrt((tempDeltaX*tempDeltaX) + (tempDeltaY*tempDeltaY) + (tempDeltaZ*tempDeltaZ));
	}
	

	/**
	 * Checks if the two coordinate object are equal.
	 * 
	 * @methodtype 
	 * bolean query method
	 * 
	 * @param otherCoordinate
	 * Other Coordinate object for comparison.
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	public boolean isEqual(Coordinate otherCoordinate) {
		if (otherCoordinate == null) {
			return false;
		}
		
		return ((compareDoubles(this.x, otherCoordinate.getX())) && (compareDoubles(this.y, otherCoordinate.getY())) && (compareDoubles(this.z, otherCoordinate.getZ())));
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
		
		//Check if obj is an instance of class Coordinate
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
}//end of class Coordinate

