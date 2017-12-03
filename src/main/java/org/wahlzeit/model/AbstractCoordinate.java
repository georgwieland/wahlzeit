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
	 * @invariant is specified by subclass
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
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) {
		//check class invariant by calling abstract assertClassInvariants method which will be implemented by the subclasses
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		//precondition argument not null
		assertIsCoordinateArgumentNull(otherCoordinate);
		
		double tempDistance = doGetCartesianDistance(otherCoordinate);
		
		//postcondition distance greater than zero
		assertIsDistanceGreaterThanZero(tempDistance);
		
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
	 * @invariant is specified by subclass
	 * 
	 * @precondition (arg != null)
	 * 
	 * @postcondition (distance >= zero)
	 * 
	 * @param coordinate
	 * @return
	 * Value for the distance.
	 */
	@Override
	public double getCartesianDistance(Coordinate otherCoordinate) {
		//check class invariants by calling abstract assertClassInvariants method which will be implemented by the subclasses
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		//precondition argument not null
		assertIsCoordinateArgumentNull(otherCoordinate);
		
		double tempDistance = doGetCartesianDistance(otherCoordinate);
		
		//postcondition distance greater than zero
		assertIsDistanceGreaterThanZero(tempDistance);
		
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
	 * @invariant is specified by subclass
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
	 */
	@Override
	public double getSphericDistance(Coordinate otherCoordinate) {
		//check class invariants by calling abstract assertClassInvariants method which will be implemented by the subclasses
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		//precondition argument not null
		assertIsCoordinateArgumentNull(otherCoordinate);
		
		double tempDistance = doGetSphericDistance(otherCoordinate);
		
		//postcondition distance greater than zero
		assertIsDistanceGreaterThanZero(tempDistance);
		
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
	 * @invariant is specified by subclass
	 *  
	 * @postcondition (coordinate != null)
	 * 
	 * @return
	 * New CartesianCoordinate object.
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		//check class invariant by calling abstract assertClassInvariants method which will be implemented by the subclasses
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		CartesianCoordinate cartesianCoordinate = doAsCartesianCoordinate();
		
		//postcondition returned coordinate object not null
		assertIsCoordinateResultNull(cartesianCoordinate);
		
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
	 * @invariant is specified by subclass
	 *  
	 * @postcondition (coordinate != null)
	 * 
	 * @return
	 * New SphericCoordinate object.
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		//check class invariant by calling abstract assertClassInvariants method which will be implemented by the subclasses
		//therefore a check will only be done in the superclass AbstractCoordinate
		assertClassInvariants();
		
		SphericCoordinate sphericCoordinate = doAsSphericCoordinate();
		
		//postcondition returned coordinate object not null
		assertIsCoordinateResultNull(sphericCoordinate);
		
		//check class invariant again
		assertClassInvariants();
		
		return sphericCoordinate;
	}
		
	/**
	 * 
	 * @methodtype 
	 * bolean query method
	 * 
	 * @invariant is specified by subclass
	 *  
	 * @param obj
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	@Override
	public boolean equals(Object obj) {
		//check class invariant by calling abstract assertClassInvariants method which will be implemented by the subclasses
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
		boolean result = this.isEqual((Coordinate) obj);
		
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
	 * @invariant is specified by subclass
	 * 
	 * @param coordinate
	 * Other coordinate object for comparisson.
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	@Override
	public boolean isEqual(Coordinate otherCoordinate) {
		//check class invariant by calling abstract assertClassInvariants method which will be implemented by the subclasses
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
	 */
	protected abstract double doGetSphericDistance(Coordinate otherCoordinate);
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @param otherCoordinate
	 * @return
	 */
	protected abstract double doGetCartesianDistance(Coordinate otherCoordinate);
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @param otherCoordinate
	 * @return
	 */
	protected abstract boolean doIsEqual(Coordinate otherCoordinate);
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @return
	 */
	protected abstract SphericCoordinate doAsSphericCoordinate();
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @methodproperties
	 * primitive, hook
	 * 
	 * @return
	 */
	protected abstract CartesianCoordinate doAsCartesianCoordinate();
	
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
		assert (coordinate != null);
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
		assert (distance >= 0);
	}
	

}//end of class AbstractCoordinate
