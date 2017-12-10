/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author dpgwieland
 *
 */
public class IllegalCoordinateResultException extends RuntimeException {

	/**
	 * 
	 */
	public IllegalCoordinateResultException() {
	}

	/**
	 * @param message
	 */
	public IllegalCoordinateResultException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IllegalCoordinateResultException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalCoordinateResultException(String message, Throwable cause) {
		super(message, cause);
	}
}
