package main;

/**
 * @author ansgar.goeb
 * 
 * Represents the most basic class that can be
 * used to represent a person. The class is also
 * used as a base-class for Teacher and Student
 * In a future version the university app will
 * use all three classes. 
 */
public class Person {

	private static int idCounter = 0;
	private int id;
	private String firstName;
	private String lastName;

	// Constructor for creating a person
	public Person(String aFirstName, String aLastName)  {
		
		// a static value is used to create a unique value 
		// for a person (teacher, student)
		Person.idCounter = Person.idCounter + 1;
		
		// the static counter initializes the object parameter
		this.id = Person.idCounter;
		
		this.firstName = aFirstName;
		this.lastName = aLastName;
	}

	/**
	 * returns the object as a string
	 */
	@Override
	public String toString() {
		return this.id + " " + this.firstName + " " + this.lastName;
	}

	/**
	 * returns the first name of the person 
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets the first name of the person
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * returns the last name of the person
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets the last name of the person
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * returns the ID of the person as string 
	 */
	public String getId() {
		return String.valueOf(id);
	}
}
