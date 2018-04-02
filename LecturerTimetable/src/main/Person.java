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

}
