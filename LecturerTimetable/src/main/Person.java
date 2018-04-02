package main;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class Person {
    private String firstName;
    private String lastName;
    
    public Person(String aFirstName, String aLastName) {
        this.firstName = aFirstName;
        this.lastName = aLastName;
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
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
}
