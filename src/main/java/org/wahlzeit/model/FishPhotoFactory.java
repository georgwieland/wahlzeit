/*
 * Classname: FishPhotoFactory
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

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/**
 * 
 * This class extends the {@link PhotoFactory} class. A FishPhotoFactory class creates fish photos and related objects
 *
 */
public class FishPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(FishPhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static FishPhotoFactory instance = null;
	
	
	/**
	 * @methodtype constructor
	 */
	protected FishPhotoFactory() {
		super();
	}
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 * 
	 * @methodtype 
	 * initialization method 
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * Public singleton access method.
	 * 
	 * @methodtype 
	 * get method 
	 */
	public static synchronized FishPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic FishPhotoFactory").toString());
			setInstance(new FishPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of FishPhotoFactory.
	 * 
	 * @methodtype 
	 * set method
	 */
	protected static synchronized void setInstance(FishPhotoFactory fishPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize FishPhotoFactory twice");
		}

		instance = fishPhotoFactory;
	}

	
	/**
	 *  @methodtype factory method
	 * 
	 * @return 
	 * Created FishPhoto object.
	 */
	@Override
	public FishPhoto createPhoto() {
		return new FishPhoto();
	}
	
	/**
	 * @methodtype factory method
	 * 
	 * @return 
	 * Created FishPhoto object.
	 */
	@Override
	public FishPhoto createPhoto(PhotoId id) {
		return new FishPhoto(id);
	}
}//end of FishPhotoFactory
