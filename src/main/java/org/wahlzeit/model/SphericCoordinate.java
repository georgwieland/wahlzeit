/*
 * Classname: SphericCoordinate
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
 * SphericCoordinate is represented by radius, longitude and latitude.
 *
 */
public class SphericCoordinate implements Coordinate {

	//radius which is the radial distance to the origin
	private double radius;
		
	//longitude 
	private double longitude;
		
	//latitude
	private double latitude;
	
	//Precision for double equality comparison
	private static final double PRECISION = 1E-5;
	
	
	/**
	 * Constructs a SphericCoordinate object.
	 * 
	 * @methodtype constructor
	 * @methodproperties convenience
	 */
	public SphericCoordinate() {
		this(0.0, 0.0, 0.0);
	}


	/**
	 * Constructs a SphericCoordinate object with the given arguments.
	 * 
	 * @methodtype constructor
	 */
	public SphericCoordinate(double radius, double longitude, double latitude) {
		this.setRadius(radius);
		this.setLongitude(longitude);
		this.setLatitude(latitude);
	}
	
	
	/**
	 * Copy constructor
	 * 
	 * @methodtype constructor
	 * @methodproperties convenience
	 * @param otherCoordinate
	 * SphericCoordinate object to copy.
	 */
	public SphericCoordinate(SphericCoordinate otherCoordinate) {
		this(otherCoordinate.getRadius(), otherCoordinate.getLongitude(), otherCoordinate.getLatitude());
	}
	
	
	/**
	 * Get method for radius
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Return radius value.
	 */
	public double getRadius() {
		return radius;
	}


	/**
	 * Set method for radius
	 * 
	 * @methodtype 
	 * set method
	 * 
	 * @param radius
	 * Radius value which will be set
	 */
	public void setRadius(double radius) {
		assertIsPositiveRadius(radius);
		this.radius = radius;
	}

	/**
	 * Get method for longitude
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Return longitude value.
	 */
	public double getLongitude() {	
		return longitude;
	}

	/**
	 * Set method for longitude
	 * 
	 * @methodtype 
	 * set method
	 * 
	 * @param longitude
	 * Longitude value which will be set
	 */
	public void setLongitude(double longitude) {
		assertIsValidLongitude(longitude);
		this.longitude = longitude;
	}

	/**
	 * Get method for latitude
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Return latitude value
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Set method for latitude
	 * 
	 * @methodtype 
	 * set method
	 * 
	 * @param latitude
	 * Latitude value which will be set
	 */
	public void setLatitude(double latitude) {
		assertIsValidLatitude(latitude);
		this.latitude = latitude;
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype boolean query method
	 */
	@Override
	public boolean isEqual(Coordinate otherCoordinate) {
		
		if (otherCoordinate == null) {
			return false;
		}
		
		//get cartesian cartseian representation
		SphericCoordinate sphericCoordinate = otherCoordinate.asSphericCoordinate();
		
		return ((compareDoubles(this.radius, sphericCoordinate.getRadius())) && 
				(compareDoubles(this.longitude, sphericCoordinate.getLongitude())) && 
				(compareDoubles(this.latitude, sphericCoordinate.getLatitude())));
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype get method
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) {
		//check for Null value
		if (otherCoordinate == null) {
			return Double.NaN;
		}
		
		return this.asCartesianCoordinate().getCartesianDistance(otherCoordinate);
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#getCartesianDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype get method
	 */
	@Override
	public double getCartesianDistance(Coordinate otherCoordinate) {
		return this.asCartesianCoordinate().getDistance(otherCoordinate);
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#asCartestianDistance()
	 * 
	 * @methodtype conversion method
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
		double y = this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
		double z = this.radius * Math.cos(this.longitude);
		
		return new CartesianCoordinate(x, y, z);
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype get method
	 */
	@Override
	public double getSphericDistance(Coordinate otherCoordinate) {
		//check for Null value
		if (otherCoordinate == null) {
			return Double.NaN;
		}
		
		SphericCoordinate sphericCoordinate = otherCoordinate.asSphericCoordinate();
		//using getDistance of class CartesianCoordinate
		double thisRadius = this.radius * this.radius;
		double otherRadius = sphericCoordinate.getRadius() * sphericCoordinate.getRadius();
		double angle = 	2 * this.radius * sphericCoordinate.getRadius() * 
						(Math.sin(this.longitude) * Math.sin(sphericCoordinate.getLongitude()) * Math.cos(this.latitude - sphericCoordinate.getLatitude()) +
						Math.cos(this.longitude) * Math.cos(sphericCoordinate.getLongitude()));
		return Math.sqrt(thisRadius + otherRadius - angle);
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#asSphericDistance()
	 * 
	 * @methodtype conversion method
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return new SphericCoordinate(this);
	}
		
	/**
	 * Check if radius value is greater than zero.
	 * 
	 * @methodtype
	 * helper method
	 * 
	 * @param radius
	 * Radius value which will be checked
	 */
	private void assertIsPositiveRadius(double radius) {
		if (radius < 0.0) {
			throw new IllegalArgumentException("Radius has to be greater than zero.");
		}
	}
	
	/**
	 * Check if longitude value is between -pi and +pi.
	 * 
	 * @methodtype
	 * helper method
	 * 
	 * @param longitude
	 * Longitude value which will be checked
	 */
	private void assertIsValidLongitude(double longitude) {
		if ((longitude < -Math.PI) || (longitude > Math.PI)) {
			throw new IllegalArgumentException("Longitude has to be between negative and positive pi.");
		}
	}
	
	/**
	 * Check if latitude is greater than zero and less than +pi.
	 * 
	 * @methodtype
	 * helper method
	 * 
	 * @param latitude
	 * Latitude value which will be checked
	 */
	private void assertIsValidLatitude(double latitude) {
		if ((latitude < 0.0) || (latitude > Math.PI)) {
			throw new IllegalArgumentException("Latitude has to be between zero and pi.");
		}
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
				
		//Check if obj is an instance of class SphericCoordinate
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
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
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
}//end of class SphericCoordinate
