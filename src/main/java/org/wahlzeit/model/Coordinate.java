/*
 * Interfacename: Coordinate
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
 * Interface for Coordinate classes.
 *
 */
public interface Coordinate {

	/**
	 * Compares two coordinate objects for equality.
	 * 
	 * @methodtype 
	 * boolean query method
	 * 
	 * @param coordinate
	 * Other coordinate object for comparisson.
	 * 
	 * @return
	 * True if equal otherwise false.
	 * @throws CoordinateException 
	 */
	public boolean isEqual(Coordinate otherCoordinate) throws CoordinateException;
	
	/**
	 * Calculates the distance between two coordinate objects.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @param coordinate
	 * Other coordinate object for distance calculation.
	 * 
	 * @return
	 * Value for the distance.
	 * @throws CoordinateException 
	 */
	public double getDistance(Coordinate otherCoordinate) throws CoordinateException;
	
	/**
	 * Calculates the cartesian distance between two Coordinate objects.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @param coordinate
	 * @return
	 * Value for the distance.
	 * @throws CoordinateException 
	 */
	public double getCartesianDistance(Coordinate otherCoordinate) throws CoordinateException;
	
	/**
	 * Creates a coordinate object in cartesian representation.
	 * 
	 * @methodtype 
	 * conversion method
	 * 
	 * @return
	 * New CartesianCoordinate object.
	 * @throws CoordinateException 
	 */
	public CartesianCoordinate asCartesianCoordinate() throws CoordinateException;

	/**
	 * Calculates the spheric distance between two Coordinate objects.
	 * 
	 * @methodtype 
	 * get method
	 * 
	 * @param coordinate
	 * Other coordinate object for spheric distance calculation.
	 * 
	 * @return
	 * Value for the distance.
	 * @throws CoordinateException 
	 */
	public double getSphericDistance(Coordinate otherCoordinate) throws CoordinateException;
	
	/**
	 * Creates a coordinate object in spheric representation.
	 * 
	 * @methodtype 
	 * conversion method
	 * 
	 * @return
	 * New SphericCoordinate object.
	 * @throws CoordinateException 
	 */
	public SphericCoordinate asSphericCoordinate() throws CoordinateException;
}//end of interface Coordinate
