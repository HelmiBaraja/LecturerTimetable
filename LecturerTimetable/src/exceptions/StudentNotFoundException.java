package exceptions;

/**
 * @author ansgar.goeb
 * 
 * Exception can be thrown when a student can't be located
 * for example when a student identified by id does not exist
 */
public class StudentNotFoundException extends UException{

	private static final long serialVersionUID = 1L;

	/**
	 * constructor of the exception
	 */
	public StudentNotFoundException(String aErrorMessage) {

		// call the constructor of the super-class
		super(aErrorMessage, "00003");
	}
}
