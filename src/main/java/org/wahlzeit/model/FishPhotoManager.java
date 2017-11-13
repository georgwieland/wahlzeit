/*
 * Classname: FishPhotoManager
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
 * This class extends the {@link PhotoManager} class. A FishPhotoManager provides access to and manages fish photos.
 *
 */
public class FishPhotoManager extends PhotoManager {

	/**
	 * 
	 */
	protected FishPhotoManager instance = new FishPhotoManager();
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public FishPhotoManager() {
		photoTagCollector = FishPhotoFactory.getInstance().createPhotoTagCollector();
	}
	

	/**
	 * @methodtype get method
	 * @methodproperties composed method
	 */
	@Override
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = FishPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}

}// end of FishPhotoManager
