/*
 * Classname: DoubleUtilTest
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
package org.wahlzeit.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Test class for {@link DoubleUtil} contains all test cases.
 *
 */
public class DoubleUtilTest {

	private static final double PRECISION = 1E-5;
	
	@Test
	public void testCompareDoubles() {
		assertTrue(DoubleUtil.compareDoubles(0.0005, 0.0005, PRECISION));
		assertTrue(DoubleUtil.compareDoubles(0.00001, 0.00001, PRECISION));
		assertTrue(DoubleUtil.compareDoubles(0.000002, 0.000001, PRECISION));
		assertFalse(DoubleUtil.compareDoubles(0.00002, 0.00001, PRECISION));
	}
	
	@Test
	public void testTrimDouble() {
		assertEquals(123456, DoubleUtil.trimDoubleValue(1.234567, PRECISION));
		assertEquals(123456, DoubleUtil.trimDoubleValue(1.23456799999, PRECISION));
		assertEquals(123400, DoubleUtil.trimDoubleValue(1.234, PRECISION));
	}
}
