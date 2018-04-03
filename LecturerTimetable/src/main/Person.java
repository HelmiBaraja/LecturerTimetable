package main;

/**
 * @author ansgar.goeb
 */
public class Person {

	private static int idCounter = 0;
	private int id;
	private String firstName;
	private String lastName;

	public Person(String aFirstName, String aLastName) {
		Person.idCounter = Person.idCounter + 1;
		this.id = Person.idCounter;
		this.firstName = aFirstName;
		this.lastName = aLastName;
	}

	@Override
	public String toString() {
		return this.id + " " + this.firstName + " " + this.lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return String.valueOf(id);
	}
}
