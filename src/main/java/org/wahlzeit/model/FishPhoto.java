/*
 * Classname: FishPhoto
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

import com.googlecode.objectify.annotation.Subclass;

/**
 * 
 * FishPhoto extends the class {@link Photo} an represents an uploaded photo of a fish.
 *
 */
@Subclass
public class FishPhoto extends Photo {

	private Fish fish;
	
	/**
	 * Constructs a FishPhoto object.
	 * @methodtype constructor
	 */
	public FishPhoto() {
		super();
	}

	/**
	 * Constructs a FishPhoto object with the given PhotoId.
	 * 
	 * @methodtype constructor
	 * @param myId
	 * Id of the FishPhoto object.
	 */
	public FishPhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
	 * Constructs a FishPhoto object with the given fish object.
	 * 
	 * @methodtype constructor
	 * @param fish
	 */
	public FishPhoto(Fish fish) {
		super();
		this.fish = fish;
	}
	
	/**
	 * Constructs a FishPhoto object with the given fish object.
	 * 
	 * @methodtype constructor
	 * @param fish
	 */
	public FishPhoto(PhotoId myId, Fish fish) {
		super(myId);
		this.fish = fish;
	}

	/**
	 * @methodtype 
	 * get method
	 * 
	 * @return
	 * fish object.
	 */
	public Fish getFish() {
		return fish;
	}

	/**
	 * @methodtype 
	 * set method
	 * 
	 * @param fish
	 * fish object.
	 */
	public void setFish(Fish fish) {
		if (fish == null) {
			throw new IllegalArgumentException("Argument for fish shouldn't be null.");
		}
		this.fish = fish;
	}
	

}//end of class FishPhoto
