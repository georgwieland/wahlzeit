/*
 * Classname: ModelTestSuite
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.model.persistence.PersistenceModelTestSuite;

/**
 * Test Suite for Package {@link org.wahlzeit.model}. Junit will invoke the tests in the classes:
 * 
 * 		{@link AccessRightsTest},
 * 		{@link CoordinateTest},
 * 		{@link FlagReasonTest},
 * 		{@link GenderTest},
 * 		{@link GuestTest},
 * 		{@link LocationTest},
 *		{@link PhotoFilterTest},
 *		{@link TagsTest},
 *		{@link UserStatusTest},
 *		{@link ValueTest},
 *		{@link PersistenceModelTestSuite}
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	//Test classes
	AccessRightsTest.class, 
	CoordinateTest.class, 
	FlagReasonTest.class, 
	GenderTest.class, 
	GuestTest.class,
	LocationTest.class, 
	PhotoFilterTest.class, 
	TagsTest.class, 
	UserStatusTest.class, 
	ValueTest.class, 
	
	//Test suites
	PersistenceModelTestSuite.class
})

public class ModelTestSuite {
	/** do nothing **/
}