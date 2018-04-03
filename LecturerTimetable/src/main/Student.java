package main;

/**
 * @author ansgar.goeb
 * 
 * Class to represent a student of the university.
 * In the first version students are only registered
 * by name. In a future version it will be possible
 * to attach students to courses.
 */
public class Student extends Person {

	// student ID as given by the student-administration system
	private String studentId;
	
	// the semester the students studies
	private int semester;

	// constructor of a student object
	public Student(String aFirstName, String aLastName, String aStudentId, int aSemester) {
		
		// call the constructor of the super-class
		super(aFirstName, aLastName);
		
		this.studentId = aStudentId;
		this.semester = aSemester;
	}

	/**
	 * returns a student object as a string
	 */
	@Override
	public String toString() {
		return super.toString() + " " + this.studentId + " " + this.semester;
	}

	/**
	 * returns the student ID
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * sets the student ID
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/*
	 * returns the semester the student studies
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * sets the semester the student studies
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
}
