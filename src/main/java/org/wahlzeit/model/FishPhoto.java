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

import org.wahlzeit.handlers.UploadPhotoFormHandler;
import org.wahlzeit.main.ModelMain;
import org.wahlzeit.services.OfyService;

import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Subclass;

/**
 * 
 * FishPhoto extends the class {@link Photo} an represents an uploaded photo of a fish.
 * 
 * ######################################################################################
 * Documentation of object creation of a fish photo object:
 * 
 * 		Sequence of calls to create a fish photo object:
 * 		''''''''''''''''''''''''''''''''''''''''''
 * 			During startup:
 * 			1.	{@link FishPhotoManager} class is instantiated and initialized in 
 * 				{@link ModelMain} startUp
 * 			2. During initialization the {@link PhotoManager#loadPhotos()} method is called
 * 			3. Photos will be loaded and instantiated by {@link OfyService}}
 * 			
 * 			Via user interaction:
 * 			1. {@link UploadPhotoFormHandler} doHandlePost will be called
 * 			2. Inside the method {@link FishPhotoManager#createPhoto(String, com.google.appengine.api.images.Image)}
 * 			   is called which is inherited from {@link PhotoManager} class
 * 			3. Afterwards the {@link PhotoUtil#createPhoto(String, PhotoId, com.google.appengine.api.images.Image)}
 * 			   will be called 
 * 			4. {@link FishPhotoFactory#createPhoto(PhotoId)} will be called to create a FishPhoto object
 * 			5. Constructor of {@link FishPhoto} instantiates the FishPhoto
 * 
 * 		Documentation of object creation solution as a point in the solution space:
 * 		'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
 * 			Delegation:	seperate object -> {@link FishPhotoFactory#createPhoto(PhotoId)} creates a FishPhoto
 * 			Selection:	subclassing -> {@link FishPhotoFactory} subclass of {@link PhotoFactory}
 * 			Configuration:	in code
 * 			Instantiation:	in code -> via constructor call
 * 			Initialization: default -> via constructor arguments
 * 			Building:	default
 * ######################################################################################
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
	 * @precondition (arg != null)
	 */
	public FishPhoto(Fish fish) {
		super();
		
		assertIsFishArgumentNull(fish);
		
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
		
		assertIsFishArgumentNull(fish);
		
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
	 * 
	 * @precondition (arg != null)
	 */
	public void setFish(Fish fish) {
		assertIsFishArgumentNull(fish);
		this.fish = fish;
	}
	
	/**
	 * Checks if the specified Fish is not null.	 
	 * 
	 * @methodtype
	 * helper method
	 * 
	 * @param otherCoordinate
	 */
	private void assertIsFishArgumentNull(Fish otherFish) {
		if(otherFish == null) {
            throw new IllegalArgumentException("Fish argument shouldn't be null!");
        }
	}
}//end of class FishPhoto
