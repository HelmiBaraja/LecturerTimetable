package exceptions;

/**
 * @author ansgar.goeb
 * 
 *  Exception can be thrown when a teacher can't be located 
 *  for example when a teacher identified by id does not exist
 */
public class TeacherNotFoundException extends UException {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor of the exception
	 */
	public TeacherNotFoundException(String aErrorMessage) {

		// call the constructor of the super-class
		super(aErrorMessage, "00004");
	}
}
