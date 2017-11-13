/*
 * Classname: Fish
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
 * Representation of a fish.
 *
 */
public class Fish {

	//name of the fish
	private String name;
		
	//average size in 
	private double size;
	
	//flag if predator or not
	private boolean predator;
	
	
	/**
	 * @methodtype constructor
	 * @methodproperties convenience
	 */
	public Fish() {
		this("", 0.0, false);
	}
	
	/**
	 * @methodtype constructor
	 * @methodproperties convenience
	 * @param name
	 */
	public Fish(String name) {
		this(name, 0.0, false);
	}
	
	/**
	 * @methodtype constructor
	 * @param name
	 * @param averageSize
	 * @param predator
	 */
	public Fish(String name, double averageSize, boolean predator) {
		this.name = name;
		this.size = averageSize;
		this.predator = predator;
	}
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Size of the fish.
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @methodtype 
	 * set method
	 * 
	 * @param averageSize
	 * Size of the fish.
	 */
	public void setAverageSize(double averageSize) {
		this.size = averageSize;
	}
	
	/**
	 * @methodtype 
	 * bolean query method
	 * 
	 * @return
	 * True if predator otherwise false.
	 */
	public boolean isPredator() {
		return predator;
	}

	/**
	 * @methodtype 
	 * set method
	 * 
	 * @param predator
	 */
	public void setPredator(boolean predator) {
		this.predator = predator;
	}

	/**
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * Name of the fish.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @methodtype 
	 * set method
	 * 
	 * @param name
	 * Name of the fish.
	 */
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Argument for name shouldn't be null.");
		}
		this.name = name;
	}
}// end of Fish
