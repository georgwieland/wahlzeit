/*
 * Classname: DoubleUtil
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

/**
 * 
 * Provides methods for double comparison.
 *
 */
public class DoubleUtil {
	
	/**
	 * Comparing two doubles taking rounding error into account.
	 * 
	 * @methodtype
	 * bolean query method
	 * 
	 * @param firstDouble
	 * First double value for comparison.
	 * 
	 * @param secondDouble
	 * Second double value for comparison.
	 * 
	 * @return
	 * True if equal otherwise false.
	 */
	public static boolean compareDoubles(double firstDouble, double secondDouble, double precision) {
		if (Double.isNaN(firstDouble) || Double.isNaN(secondDouble) || Double.isNaN(precision)) {
			return false;
		}
		//first substract and compare absolute value with PRECISION 
		return Math.abs(firstDouble - secondDouble) < precision;
	}
	
	/**
	 * 
	 * @param value
	 * @param precision
	 * @return
	 */
	public static int trimDoubleValue(double value, double precision) {
		if (precision == 0.0) {
			throw new IllegalArgumentException("Value shouldn't be zero!");
		}
		
		double tempResult = (value*Math.round(1/precision));
		int resultAsInt = (int)tempResult;
		
		return resultAsInt;
	}
	
} //end of class DoubleUtil
