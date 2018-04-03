package exceptions;

/**
 * 
 * @author ansgar.goeb
 *
 * Exception that can be thrown when no classroom can be found 
 */
public class ClassRoomFullException extends UException{

	private static final long serialVersionUID = 1L;
	
	/**
	 * constructor of the exception
	 */
	public ClassRoomFullException(String aErrorMessage) {

		// call the constructor of the super-class
		super(aErrorMessage, "0001");
	}
}
