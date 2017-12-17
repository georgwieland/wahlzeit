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

import org.wahlzeit.utils.DoubleUtil;

/**
 * SphericCoordinate is represented by radius, longitude and latitude.
 *
 */
public class SphericCoordinate extends AbstractCoordinate {

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
	public SphericCoordinate() throws CoordinateException{
		this(0.0, 0.0, 0.0);
	}


	/**
	 * Constructs a SphericCoordinate object with the given arguments.
	 * 
	 * @methodtype constructor
	 * 
	 * @invariant will be checked after instantiation
	 * 
	 */
	public SphericCoordinate(double radius, double longitude, double latitude) throws CoordinateException {		
		this.setRadius(radius);
		this.setLongitude(longitude);
		this.setLatitude(latitude);
			
		//Check class invariants after instantiation. 
		//Not necessary for other constructors because they are just convenience constructors which call this one
		assertImplementationClassInvariant();
	}
	
	
	/**
	 * Copy constructor
	 * 
	 * @methodtype constructor
	 * @methodproperties convenience
	 * @param otherCoordinate
	 * SphericCoordinate object to copy.
	 */
	public SphericCoordinate(SphericCoordinate otherCoordinate) throws CoordinateException{
		this(otherCoordinate.getRadius(), otherCoordinate.getLongitude(), otherCoordinate.getLatitude());
	}
	
	
	/**
	 * Get method for radius
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant since object state will not be changed and the
	 * method is not that complex invariant check is not necessary
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
	 * @invariant {@link SphericCoordinate#assertImplementationClassInvariant}
	 * 
	 * @precondition (value != NaN) || (radius >= zero)
	 *  
	 * @param radius
	 * Radius value which will be set
	 */
	public void setRadius(double radius) throws CoordinateException {
		//check class invariant before changing objects state
		assertImplementationClassInvariant();
		try {
			assertIsValidCoordinateValue(longitude);
			assertIsPositiveRadius(radius);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
	
		this.radius = radius;
		
		//check class invariant after changing objects state
		assertImplementationClassInvariant();
	}

	/**
	 * Get method for longitude
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant since object state will not be changed and the
	 * method is not that complex invariant check is not necessary
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
	 * @invariant {@link SphericCoordinate#assertClassInvariants}
	 * 
	 * @precondition (value != NaN) || (longitude >= -Math.PI) || (longitude <= Math.PI)
	 *  
	 * @param longitude
	 * Longitude value which will be set
	 */
	public void setLongitude(double longitude) throws CoordinateException {
		//check class invariant before changing objects state
		assertImplementationClassInvariant();
		
		try {
			assertIsValidCoordinateValue(longitude);
			assertIsValidLongitude(longitude);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		this.longitude = longitude;
		
		//check class invariant after changing objects state
		assertImplementationClassInvariant();
	}

	/**
	 * Get method for latitude
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant since object state will not be changed and the
	 * method is not that complex invariant check is not necessary
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
	 * @invariant {@link SphericCoordinate#assertClassInvariants}
	 * 
	 * @precondition (value != NaN) || (latitude >= 0.0) || (latitude <= Math.PI)
	 *   
	 * @param latitude
	 * Latitude value which will be set
	 */
	public void setLatitude(double latitude) throws CoordinateException {
		//check class invariant before changing objects state
		assertImplementationClassInvariant();
		
		try {
			assertIsValidCoordinateValue(latitude);
			assertIsValidLatitude(latitude);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		this.latitude = latitude;
		
		//check class invariant after changing objects state
		assertImplementationClassInvariant();
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
		return this.asCartesianCoordinate().getDistance(otherCoordinate);
	}
	
	/**
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
	 * @throws CoordinateException 
	 * @see org.wahlzeit.model.Coordinate#asCartestianDistance()
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
		double x = this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
		double y = this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
		double z = this.radius * Math.cos(this.longitude);
		
		return new CartesianCoordinate(x, y, z);
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#asSphericDistance()
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
	protected SphericCoordinate doAsSphericCoordinate() throws CoordinateException {
		return new SphericCoordinate(this);
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype boolean query method
	 * 
	 * @invariant will be checked by AbstractCoordinate
	 * 
	 * @precondition will be checked by AbstractCoordinate
	 * 
	 * @postcondition will be checked by AbstractCoordinate
	 * 
	 */
	@Override
	protected boolean doIsEqual(Coordinate otherCoordinate) throws CoordinateException {
		//get cartesian cartseian representation
		SphericCoordinate sphericCoordinate = otherCoordinate.asSphericCoordinate();
		
		return ((DoubleUtil.compareDoubles(this.radius, sphericCoordinate.getRadius(), PRECISION)) && 
				(DoubleUtil.compareDoubles(this.longitude, sphericCoordinate.getLongitude(), PRECISION)) && 
				(DoubleUtil.compareDoubles(this.latitude, sphericCoordinate.getLatitude(), PRECISION)));
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
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		//check class invariant after 
		assertImplementationClassInvariant();
		
		return result;
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
	 * 		(radius >= zero) || !Double.isNaN(radius)
	 * 		(longitude >= -Math.PI) || (longitude <= Math.PI) || !Double.isNaN(radius)
	 * 		(latitude >= zero) || (latitude <= Math.PI) || !Double.isNaN(radius)
	 * 
	 * @methodtype assertion
	 */
	@Override
	protected void assertImplementationClassInvariant() {
		//check radius
		assert ((radius >= 0.0) || !Double.isNaN(radius));
		
		//check longitude
		assert ((longitude >= -Math.PI) || (longitude <= Math.PI) || !Double.isNaN(radius));
		
		//check latitude
		assert ((latitude >= 0.0) || (latitude <= Math.PI) || !Double.isNaN(radius));
	}
}//end of class SphericCoordinate
