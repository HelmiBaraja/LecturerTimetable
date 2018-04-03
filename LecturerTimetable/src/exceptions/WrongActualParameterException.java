package exceptions;

/**
 * 
 * @author ansgar.goeb
 * 
 * Exception can be thrown when a message is sent to a 
 * method and not all parameters are filled or not
 * correctly filled
  */
public class WrongActualParameterException extends UException{

	private static final long serialVersionUID = 1L;
	
	public WrongActualParameterException(String aErrorMessage) {

		// call the constructor of the super-class
		super(aErrorMessage, "00002");
	}
}
