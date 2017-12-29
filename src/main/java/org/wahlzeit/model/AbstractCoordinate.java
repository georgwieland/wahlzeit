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

import org.wahlzeit.utils.PatternInstance;

/**
 * 
 *	Abstract class for all Coordinate types.
 *
 */
@PatternInstance (
		patternName = "Template Method",
		participants = {"AbstractCoordinate, CartesianCoordinate, SphericCoordinate"},
		relatedPatterns = {"Strategy, Factory Method"}  // see "Gamma, E.; Helm, R.; Johnson, R.; Vlissides, J. (1995): Design Patterns" Chapter 1
	)
public abstract class AbstractCoordinate implements Coordinate {

	/**
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant will call the specific class invariant
	 * 
	 * @precondition (arg != null)
	 * 
	 * @postcondition (distance >= zero)
	 * 
	 * @param coordinate
	 * Other coordinate object for distance calculation.
	 * 
	 * @return
	 * Value for the distance.
	 * @throws CoordinateException 
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) throws CoordinateException {
		//check class invariant by calling assertClassInvariants method which calls the assertImplementationClassInvariant of a specific coordinate class
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		//precondition argument not null
		try {
			assertIsCoordinateArgumentNull(otherCoordinate);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		double tempDistance = doGetCartesianDistance(otherCoordinate);
		
		//postcondition distance greater than zero
		try {
			assertIsDistanceGreaterThanZero(tempDistance);
		} catch (IllegalCoordinateResultException ex) {
			throw new CoordinateException(ex);
		}
		
		//check class invariant again
		assertClassInvariants();
		return tempDistance;
	}

	/**
	 * @see org.wahlzeit.model.Coordinate#getCartesianDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant will call the specific class invariant
	 * 
	 * @precondition (arg != null)
	 * 
	 * @postcondition (distance >= zero)
	 * 
	 * @param coordinate
	 * @return
	 * Value for the distance.
	 * @throws CoordinateException 
	 */
	@Override
	public double getCartesianDistance(Coordinate otherCoordinate) throws CoordinateException {
		//check class invariant by calling assertClassInvariants method which calls the assertImplementationClassInvariant of a specific coordinate class
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		//precondition argument not null
		try {
			assertIsCoordinateArgumentNull(otherCoordinate);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		
		double tempDistance = doGetCartesianDistance(otherCoordinate);
		
		//postcondition distance greater than zero
		try {
			assertIsDistanceGreaterThanZero(tempDistance);
		} catch (IllegalCoordinateResultException ex) {
			throw new CoordinateException(ex);
		}
		
		
		//check class invariant again
		assertClassInvariants();
		
		return tempDistance;
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @invariant will call the specific class invariant
	 * 
	 * @precondition (arg != null)
	 * 
	 * @postcondition (distance >= zero)
	 *  
	 * @param coordinate
	 * Other coordinate object for spheric distance calculation.
	 * 
	 * @return
	 * Value for the distance.
	 * @throws CoordinateException 
	 */
	@Override
	public double getSphericDistance(Coordinate otherCoordinate) throws CoordinateException {
		//check class invariant by calling assertClassInvariants method which calls the assertImplementationClassInvariant of a specific coordinate class
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		//precondition argument not null
		try {
			assertIsCoordinateArgumentNull(otherCoordinate);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		double tempDistance = doGetSphericDistance(otherCoordinate);
		
		//postcondition distance greater than zero
		try {
			assertIsDistanceGreaterThanZero(tempDistance);
		} catch (IllegalCoordinateResultException ex) {
			throw new CoordinateException(ex);
		}
		
		//check class invariant again
		assertClassInvariants();
		return tempDistance;
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 * 
	 * @methodtype 
	 * conversion method
	 * 
	 * @invariant will call the specific class invariant
	 *  
	 * @postcondition (coordinate != null)
	 * 
	 * @return
	 * New CartesianCoordinate object.
	 * @throws CoordinateException 
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws CoordinateException {
		//check class invariant by calling assertClassInvariants method which calls the assertImplementationClassInvariant of a specific coordinate class
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		CartesianCoordinate cartesianCoordinate = doAsCartesianCoordinate();
		
		//postcondition returned coordinate object not null		
		try {
			assertIsCoordinateResultNull(cartesianCoordinate);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		//check class invariant again
		assertClassInvariants();
		
		return cartesianCoordinate;
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#asSphericCoordinate()
	 * 
	 * @methodtype 
	 * conversion method
	 * 
	 * @invariant will call the specific class invariant
	 *  
	 * @postcondition (coordinate != null)
	 * 
	 * @return
	 * New SphericCoordinate object.
	 * @throws CoordinateException 
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws CoordinateException {
		//check class invariant by calling assertClassInvariants method which calls the assertImplementationClassInvariant of a specific coordinate class
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		SphericCoordinate sphericCoordinate = doAsSphericCoordinate();
		
		//postcondition returned coordinate object not null
		try {
			assertIsCoordinateResultNull(sphericCoordinate);
		} catch (IllegalArgumentException ex) {
			throw new CoordinateException(ex);
		}
		
		//check class invariant again
		assertClassInvariants();
		
		return sphericCoordinate;
	}
		
	/**
	 * 
	 * @methodtype 
	 * bolean query method
	 * 
	 * @invariant will call the specific class invariant
	 *  
	 * @param obj
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	@Override
	public boolean equals(Object obj) {
		//check class invariant by calling assertClassInvariants method which calls the assertImplementationClassInvariant of a specific coordinate class
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
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
		boolean result = false;
		try {
			result = this.isEqual((Coordinate) obj);
		} catch (CoordinateException ex) {
			ex.printStackTrace();
		}
		
		
		//check class invariant again
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 * 
	 * @methodtype 
	 * boolean query method
	 * 
	 * @invariant will call the specific class invariant
	 * 
	 * @param coordinate
	 * Other coordinate object for comparisson.
	 * 
	 * @return
	 * True if equal otherwise false.
	 * @throws CoordinateException 
	 */
	@Override
	public boolean isEqual(Coordinate otherCoordinate) throws CoordinateException{
		//check class invariant by calling assertClassInvariants method which calls the assertImplementationClassInvariant of a specific coordinate class
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		if (otherCoordinate == null) {
			return false;
		}
		
		boolean result =  doIsEqual(otherCoordinate);
		
		//check class invariant again
		assertClassInvariants();
		return result;
	}
	
	/**
	 * Make sure that the hashCode method has to be overwritten by all subclasses.
	 */
	@Override
	public abstract int hashCode();
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @param otherCoordinate
	 * @return
	 * @throws CoordinateException 
	 */
	protected abstract double doGetSphericDistance(Coordinate otherCoordinate) throws CoordinateException;
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @param otherCoordinate
	 * @return
	 * @throws CoordinateException 
	 */
	protected abstract double doGetCartesianDistance(Coordinate otherCoordinate) throws CoordinateException;
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @param otherCoordinate
	 * @return
	 * @throws CoordinateException 
	 */
	protected abstract boolean doIsEqual(Coordinate otherCoordinate) throws CoordinateException;
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @return
	 * @throws CoordinateException 
	 */
	protected abstract SphericCoordinate doAsSphericCoordinate() throws CoordinateException;
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @return
	 * @throws CoordinateException 
	 */
	protected abstract CartesianCoordinate doAsCartesianCoordinate() throws CoordinateException;
	
	/**
	 * Class invariant will be implemented by specific coordinate classes.
	 * 
	 * @methodtype assertionmethod
	 * @methodproperties hookmethod
	 */
	protected abstract void assertImplementationClassInvariant();
	
	
	/**
	 * Class invariant for AbstractCoordinate class.
	 * 
	 * @methodtype assertionmethod
	 * @methodproperties hookmethod
	 */
	private void assertClassInvariants() {
		assertImplementationClassInvariant();
	}
			
	/**
	 * Checks if the specified Coordinate is not null.	 
	 * 
	 * @methodtype
	 * helper method
	 * 
	 * @param otherCoordinate
	 */
	private void assertIsCoordinateArgumentNull(Coordinate otherCoordinate) {
		if(otherCoordinate == null) {
            throw new IllegalArgumentException("Coordinate argument shouldn't be null!");
        }
	}
	
	/**
	 * Checks if result is null
	 * 
	 * @methodtype 
	 * assertion method
	 * 
	 * @param coordinate
	 */
	private void assertIsCoordinateResultNull(Coordinate coordinate) {
		//coordinate shouldn't be null
		if (coordinate == null) {
			throw new IllegalCoordinateResultException("Coordinate result should not be null!");
		}
	}
	
	/**
	 * Checks if distance is greater than zero
	 * 
	 * @methodtype 
	 * assertion method
	 * 
	 * @param distance
	 */
	private void assertIsDistanceGreaterThanZero(double distance) {
		//distance hast to be greater than zero
		if (distance < 0) {
			throw new IllegalCoordinateResultException("Coordinate distance should not be less than zero!");
		}
	}
	

}//end of class AbstractCoordinate
