/*
 * Classname: WahlzeitTestSuite
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
package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.HandlerTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

/**
 * Test Suite for all Packages. Junit will invoke the tests in the classes:
 * 
 * 		{@link HandlerTestSuite},
 * 		{@link ModelTestSuite},
 *		{@link ServicesTestSuite},
 *		{@link UtilsTestSuite}
 */
@RunWith(Suite.class)
@SuiteClasses({
	HandlerTestSuite.class,
	ModelTestSuite.class,
	ServicesTestSuite.class,
	UtilsTestSuite.class
})

public class WahlzeitTestSuite {
	/** do nothing **/
}
