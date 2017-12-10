/*
 * Classname: Location
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
 *	Location represents a location where a photo was taken.
 */
public class Location {
	//CartesianCoordinate member
	private Coordinate coordinate;
	
	
	/**
	 * Constructs a Location object.
	 */
	public Location() {	
	}
	
	/**
	 * Constructs a Location object with the given argument.
	 * 
	 * @param cartesianCoordinate
	 * CartesianCoordinate object for initialization.
	 * 
	 * @precondition (arg != null)
	 */
	public Location(Coordinate otherCoordinate) {
		assertIsCoordinateArgumentNull(otherCoordinate);
		
		this.coordinate = otherCoordinate;
	}

	/**
	 * Get method for the coordinates.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Returns the coordinates.
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * Set method for the coordinates.
	 * 
	 * @methodtype
	 * set method
	 * 
	 * @param cartesianCoordinate
	 * CartesianCoordinate object for setting the coordinates.
	 * 
	 * @precondition (arg != null)
	 */
	public void setCoordinate(Coordinate otherCoordinate) {
		assertIsCoordinateArgumentNull(otherCoordinate);
		
		this.coordinate = otherCoordinate;
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
		if (!(obj instanceof Location)) {
			return false;
		}
		
		//comparing data		
		Location other = (Location) obj;
		return coordinate.equals(other.coordinate);
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
		result = prime * result + ((coordinate == null) ? 0 : coordinate.hashCode());
		return result;
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
} //end of class Location
