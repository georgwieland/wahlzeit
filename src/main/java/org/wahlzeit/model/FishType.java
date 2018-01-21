/*
 * Classname: FishType
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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.googlecode.objectify.annotation.Serialize;

/**
 * 
 * ObjectType: FishType represents the object type class for fish instances
 *
 */
public class FishType {

	/**
	 * Supertype of fish type
	 */
	@Serialize
	protected FishType superType = null;
	
	/**
	 * Subtype of fish type
	 */
	@Serialize
	protected Set<FishType> subTypes = new HashSet<FishType>();
	
	
	/**
	 * name of the fish
	 */
	private String name;
	
	/**
	 * flag if predator or not
	 */
	private boolean predator;
	
	
	/**
	 * @methodtype constructor
	 * 
	 * @param name 
	 * Name of the FishType
	 * 
	 * @param predator
	 * Is fish type predator or not
	 */
	public FishType(String name, boolean predator) {
		if (name == null) {
			throw new IllegalArgumentException("name shouldn't be null");
		}
		
		this.name = name;
		this.predator = predator;
	}
	
	/**
	 * @methodtype constructor
	 * 
	 * @param name 
	 * Name of the FishType
	 * 
	 * @param predator
	 * Is fish type predator or not
	 */
	public FishType(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name shouldn't be null");
		}
		
		this.name = name;
		this.predator = false;
	}
	
	/**
	 * @methodtype boolean query method^
	 * 
	 * @return
	 * True if subtype otherwise false
	 */
	public boolean isSubtype() {
		if (superType != null) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @methodtype boolean query method^
	 * 
	 * @return
	 * True if subtype otherwise false
	 */
	public boolean isSubtype(FishType fishType) {
		if (fishType == null) {
			return false;
		}
		
		if (fishType == this) {
			return true;
		}
		
		for(FishType type: this.subTypes) {
			if(type.isSubtype(fishType)) {
				return true;
			}
		}
		
		return false;
	}	
	
	/**
	 * @methodtype
	 * get method
	 * 
	 * @return
	 * Super type as FishType
	 */
	public FishType getSuperType() {
		return superType;
	}
	
	/**
	 * @methodtype
	 * set method
	 * 
	 * @param fishType
	 * Fish type for super type
	 */
	protected void setSuperType(FishType fishType) {
		this.superType = fishType;
	}
	
	/**
	 * Add sub type to this fish type
	 * 
	 * @param fishType
	 * fish type which is subtype of this fish type
	 */
	public void addSubType(FishType fishType) {
		if (fishType == null) {
			throw new IllegalArgumentException("fishType shouldn't be null!");
		}
		fishType.setSuperType(this);
		subTypes.add(fishType);
	}
	
	
	/**
	 * Remove sub type of this fish type
	 * 
	 * @param fishType
	 * fish type which is subtype of this fish type
	 */
	public void removeSubType(FishType fishType) {
		if (fishType == null) {
			throw new IllegalArgumentException("fishType shouldn't be null!");
		}
		fishType.setSuperType(null);
		subTypes.remove(fishType);
	}
	
	
	/**
	 * @methodtype
	 * factory method
	 * 
	 * @param size
	 * size of the fish
	 * 
	 * @return
	 * New fish object
	 */
	public Fish createInstance(long id, double size) {
		return new Fish(id, this, size);
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

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (predator ? 1231 : 1237);
		result = prime * result + ((subTypes == null) ? 0 : subTypes.hashCode());
		result = prime * result + ((superType == null) ? 0 : superType.hashCode());
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
		FishType other = (FishType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (predator != other.predator)
			return false;
		if (subTypes == null) {
			if (other.subTypes != null)
				return false;
		} else if (!subTypes.equals(other.subTypes))
			return false;
		if (superType == null) {
			if (other.superType != null)
				return false;
		} else if (!superType.equals(other.superType))
			return false;
		return true;
	}
} // end of class FishType
