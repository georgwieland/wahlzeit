/*
 * Classname: FishManager
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

import java.util.HashMap;

import org.wahlzeit.services.ObjectManager;

/**
 * 
 * The FishManager class manages Fish and FishType objects.
 *
 */
public class FishManager extends ObjectManager {

	/**
	 * Single instance of FishManager
	 */
	private static FishManager instance = new FishManager();
	
	/**
	 * fishTypes stores all exisiting fishtype objects
	 */
	private HashMap<String, FishType> fishTypes = new HashMap<String, FishType>();
	
	/**
	 * fishes stores all existing fish objects
	 */
	private HashMap<Long, Fish> fishes = new HashMap<Long, Fish>();
	
	/**
	 * @methodtype
	 * Constructor
	 */
	private FishManager() {
		
	}
	
	/**
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * single instance of FishManager
	 */
	public static FishManager getInstance() {
		return instance;
	}
	
	/**
	 * @methodtype
	 * factory method
	 * 	
	 * @param fishId
	 * @param typeName
	 * @param size
	 * @return
	 * New fish object or already existing one
	 */
	public Fish createFish(long fishId, String typeName, double size) {
		if (typeName == null) {
			throw new IllegalArgumentException("typeName shouldn't be null!");
		}
		
		FishType fishType = getFishType(typeName);
		Fish fish = fishType.createInstance(fishId, size);
		fishes.put(fish.getId(), fish);
		
		return fish;
	}


	/**
	 * @methodtype
	 * get method
	 * 
	 * @param typeName
	 * @return
	 * New fishtype object or already existing one
	 */
	public FishType getFishType(String typeName) {
		if (typeName == null) {
			throw new IllegalArgumentException("typeName shouldn't be null!");
		}
		
		if (fishTypes.containsKey(typeName)) {
			return fishTypes.get(typeName);
		} else {
			FishType newFishtype = new FishType(typeName);
			fishTypes.put(typeName, newFishtype);
			return newFishtype;
		}
	}
	
	/**
	 * @methodtype
	 * factory method
	 * 
	 * @param typeName
	 * @param predator
	 * @return
	 * New fishtype object or already existing one
	 */
	public FishType createFishType(String typeName, boolean predator) {
		if (typeName == null) {
			throw new IllegalArgumentException("typeName shouldn't be null!");
		}
		
		if (fishTypes.containsKey(typeName)) {
			return fishTypes.get(typeName);
		} else {
			FishType newFishtype = new FishType(typeName, predator);
			fishTypes.put(typeName, newFishtype);
			return newFishtype;
		}	
	}
	
} // end of class FishManager
