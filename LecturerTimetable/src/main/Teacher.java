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

	public String getExmplyeeId() {
		return exmplyeeId;
	}

	public void setExmplyeeId(String exmplyeeId) {
		this.exmplyeeId = exmplyeeId;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
}
