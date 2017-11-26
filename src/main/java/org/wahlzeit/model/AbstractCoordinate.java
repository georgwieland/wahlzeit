/*
 * Classname: AbstractCoordinate
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
 * 
 *	Abstract class for all Coordinate types.
 *
 */
public abstract class AbstractCoordinate implements Coordinate {

	/**
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @param coordinate
	 * Other coordinate object for distance calculation.
	 * 
	 * @return
	 * Value for the distance.
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) {
		assertIsCoordinateNull(otherCoordinate);
		return getCartesianDistance(otherCoordinate);
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#getCartesianDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @param coordinate
	 * @return
	 * Value for the distance.
	 */
	@Override
	public double getCartesianDistance(Coordinate otherCoordinate) {
		assertIsCoordinateNull(otherCoordinate);
		return doGetCartesianDistance(otherCoordinate);
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @param coordinate
	 * Other coordinate object for spheric distance calculation.
	 * 
	 * @return
	 * Value for the distance.
	 */
	@Override
	public double getSphericDistance(Coordinate otherCoordinate) {
		assertIsCoordinateNull(otherCoordinate);
		return doGetSphericDistance(otherCoordinate);
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 * 
	 * @methodtype 
	 * conversion method
	 * 
	 * @return
	 * New CartesianCoordinate object.
	 */
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	/**
	 * @see org.wahlzeit.model.Coordinate#asSphericCoordinate()
	 * 
	 * @methodtype 
	 * conversion method
	 * 
	 * @return
	 * New SphericCoordinate object.
	 */
	@Override
	public abstract SphericCoordinate asSphericCoordinate();
		
	/**
	 * 
	 * @methodtype 
	 * bolean query method
	 * 
	 * @param obj
	 * @return
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
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * boolean query method
	 * 
	 * @param coordinate
	 * Other coordinate object for comparisson.
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	@Override
	public boolean isEqual(Coordinate otherCoordinate) {
		if (otherCoordinate == null) {
			return false;
		}
		return doIsEqual(otherCoordinate);
	}
	
	/**
	 * Make sure that the hashCode method has to be overwritten by all subclasses.
	 */
	@Override
	public abstract int hashCode();
	
	/**
	 * 
	 * @param otherCoordinate
	 * @return
	 */
	protected abstract double doGetSphericDistance(Coordinate otherCoordinate);
	
	/**
	 * 
	 * @param otherCoordinate
	 * @return
	 */
	protected abstract double doGetCartesianDistance(Coordinate otherCoordinate);
	
	/**
	 * 
	 * @param otherCoordinate
	 * @return
	 */
	protected abstract boolean doIsEqual(Coordinate otherCoordinate);
	
	
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
	protected boolean compareDoubles(double firstDouble, double secondDouble, double precision) {
		if (Double.isNaN(firstDouble) || Double.isNaN(secondDouble)) {
			return false;
		}
		//first substract and compare absolute value with PRECISION 
		return Math.abs(firstDouble - secondDouble) < precision;
	}
	
	/**
	 * Checks if the specified Coordinate is not null.	 
	 * 
	 * @methodtype
	 * helper method
	 * 
	 * @param otherCoordinate
	 */
	private void assertIsCoordinateNull(Coordinate otherCoordinate) {
		if(otherCoordinate == null) {
            throw new IllegalArgumentException("Coordinate argument shouldn't be null!");
        }
	}
}//end of class AbstractCoordinate
