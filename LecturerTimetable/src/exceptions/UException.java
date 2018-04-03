package exceptions;

/**
 * @author ansgar.goeb
 * 
 * Base Exception Class for the University System
 */
public abstract class UException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorId;

	/**
	 * constructor for classes that extend this class
	 */
	public UException(String aErrorMessage, String aErrorId) {
		this.errorMessage = aErrorMessage;
		this.errorId = aErrorId;
	}

	/**
	 * returns the error message of the exception
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * sets the error message of an exception
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * returns the error ID of the exception
	 */
	public String getErrorId() {
		return errorId;
	}

	/**
	 * sets the error id of the exception
	 */
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	/**
	 * returns the object as string
	 */
	public String toString() {
		return ("Error IDr = " + errorId + " " + errorMessage);
	}
}
