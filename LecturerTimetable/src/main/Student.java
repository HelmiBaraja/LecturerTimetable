package main;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class Student extends Person {


    private String studentId;
    private int semester;
    
    public Student(String aFirstName, String aLastName, String aStudentId, int aSemester) {
        super(aFirstName, aLastName);
        this.studentId = aStudentId;
        this.semester = aSemester;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.studentId + " " + this.semester;
    }

    
}
