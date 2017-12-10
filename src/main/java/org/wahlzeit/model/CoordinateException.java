/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author dpgwieland
 *
 */
public class CoordinateException extends Exception {

	/**
	 * 
	 */
	public CoordinateException() {
	}

	/**
	 * 
	 * @param message
	 */
	public CoordinateException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param cause
	 */
	public CoordinateException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public CoordinateException(String message, Throwable cause) {
		super(message, cause);
	}
}
