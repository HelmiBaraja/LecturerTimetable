package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ansgar.goeb
 * 
 * Class to represent a teacher of the university.
 */
public class Teacher extends Person {

	// staff ID of the teacher
	private String exmplyeeId;
	
	// the function of the teach e.g. instructor, dean, ...
	private String function;

	/**
	 * constructor of a teacher object 
	 */
	public Teacher(String aFirstName, String aLastName, String aEmplyeeId, String aFunction) {
		
		// call the constructor of the super-class
		super(aFirstName, aLastName);
		this.exmplyeeId = aEmplyeeId;
		this.function = aFunction;
	}

	/**
	 * returns the teacher object as a string
	 */
	@Override
	public String toString() {
		return super.toString() + " " + this.exmplyeeId + " " + this.function;
	}

	/**
	 * returns the staff ID
	 */
	public String getExmplyeeId() {
		return exmplyeeId;
	}

	/**
	 * sets the staff ID
	 */
	public void setExmplyeeId(String exmplyeeId) {
		this.exmplyeeId = exmplyeeId;
	}

	/**
	 * returns the function of the teacher
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * sets the function of the teacher
	 */
	public void setFunction(String function) {
		this.function = function;
	}
}