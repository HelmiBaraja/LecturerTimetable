package main;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class Teacher extends Person {

    private String exmplyeeId;
    private String function;
    
    public Teacher(String aFirstName, String aLastName, String aEmplyeeId, String aFunction) {
        super(aFirstName, aLastName);
        this.exmplyeeId = aEmplyeeId;
        this.function = aFunction;
    }

    @Override
    public String toString() {
        return super.toString() + " "+ this.exmplyeeId + " " + this.function;
    }
    
}
