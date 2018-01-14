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

	/**
	 * Size of fish
	 */
	private double size;
	
	/**
	 * Type of fish
	 */
	private FishType fishType = null;
	
	/**
	 * 
	 */
	private long id;

	
	/**
	 * @methodtype constructor
	 * @param name
	 * @param averageSize
	 * @param predator
	 */
	public Fish(long id, FishType fishType, double size) {
		if (fishType == null) {
			throw new IllegalArgumentException("fishType shouldn't be null!");
		}
		
		this.id = id;
		this.fishType = fishType;
		this.size = size;
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
	 * @param size
	 * Size of the fish.
	 */
	public void setSize(double size) {
		if (Double.isNaN(size)) {
			throw new IllegalArgumentException("size shouldn't be NaN");
		}
		
		this.size = size;
	}
	
	/**
	 * @methodtype
	 * get method
	 * 
	 * @return
	 * Type of fish
	 */
	public FishType getFishType() {
		return fishType;
	}

	/**
	 * @methodtype
	 * set method
	 * 
	 * @param fishType
	 * Type of fish 
	 */
	public void setFishType(FishType fishType) {
		this.fishType = fishType;
	}
	
	/**
	 * @Methodtype
	 * get method
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * @methodtype
	 * set method
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fishType == null) ? 0 : fishType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fish other = (Fish) obj;
		if (fishType == null) {
			if (other.fishType != null)
				return false;
		} else if (!fishType.equals(other.fishType))
			return false;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		return true;
	}
	
	
}// end of Fish
