package main;

import java.util.ArrayList;
import java.util.List;

import exceptions.StudentNotFoundException;
import exceptions.WrongActualParameterException;

/**
 * @author ansgar.goeb 
 * (contributions from Chan and Helmi 
 *  -> Course other tabs than University, Students)
 *  
 *   The University class represents the whole university.
 *   Mainly it is used as a coordinating object for all
 *   the other classes. The class serves as an entry point
 *   to the university for the user-interface. The design
 *   is chosen to separate between object model and user-
 *   interface to introduce as less as possible dependencies.
 */
public class University {

	// the name of the university
	private String name;

    // a list of person objects (it is used to store persons,
	// teachers and students) An ArrayList is chosen because
	// a simple list is necessary where objects can be added
	// and deleted. The uniqueness of the list is maintained
	// via the user-interface
	private List<Person> persons = new ArrayList<Person>();
	
	// a taught course of the university
	private Course course;
	private ClassRoom classRoom;
	private Teaching teaching;
	/**
	 * Constructor of the university
	 */
	public University(String aName) {
		this.name = aName;
	}

	/**
	 * method to add a person to the list of persons 
	 */
	public void addPerson(String aFirstName, String aLastName) {
		
		// construct a person object
		Person person = new Person(aFirstName, aLastName);
		
		// add the person object to the list of persons
		persons.add(person);
	}

	/**
	 * Adds a student to the list of persons. 
	 * It throws an exception when not all parameter
	 * are set. 
	 */
	public void addStudent(String aFirstName, String aLastName, String aStudentId, int aSemester) throws WrongActualParameterException {
		
		// check whether all parameters are set
		if(   aFirstName.isEmpty() 
		   || aLastName.isEmpty()
		   || aStudentId.isEmpty()
		   || aSemester <= 0) {
			
			// throw an exception when parameters are not set and 
			// prevent further processing
			throw new WrongActualParameterException("Firstname, LastName, Student ID or Semester is empty");
		}
		
		// call the constructor of a student object
		Student student = new Student(aFirstName, aLastName, aStudentId, aSemester);
		
		// add the student to the list of persons
		persons.add(student);
	}

	/**
	 * Adds a teacher to the list of persons.
	 * (no exception will be thrown not to damage Chan's program) 
	 */
	public void addTeacher(String aFirstName, String aLastName, String aEmplyeeId, String aFunction) {
		
		// call the constructor of a teacher object
		Teacher teacher = new Teacher(aFirstName, aLastName, aEmplyeeId, aFunction);
		
		// add the teacher to the list of persons
		persons.add(teacher);
	}

	/**
	 * Deletes a student from the list of persons.
	 * In case the person identified by ID could not be located,
	 * an exception shall be thrown. 
	 */
	public void deleteStudent(String aId) throws StudentNotFoundException {

		Person person;
		for (Person eachPerson : persons) {

			// check all entries whether it is a student and can be identified
			// by the given ID
			if (eachPerson instanceof Student && eachPerson.getId().equals(aId)) {
				person = eachPerson;

				// the correct person is found an can be removed from the list
				persons.remove(person);
				return;
			}
		}
		
		// no person could be located with the correct ID, an exception shall
		// be thrown
		throw new StudentNotFoundException("Student could not located for update");
	}

 
	/**
	 *  Deletes a teacher from the list of persons.
	 * (no exception will be thrown not to damage Chan's program) 
	 */
	public void deleteTeacher(String aId) {

		Person person;
		for (Person eachPerson : persons) {

			// check all entries whether it is a teacher and can be identified
			// by the given ID
			if (eachPerson instanceof Teacher && eachPerson.getId().equals(aId)) {
				person = eachPerson;
				
				// teacher found, delete the teacher from the list of persons
				persons.remove(person);
				return;
			}
		}
	}

	/**
	 * returns a list of all persons, delivers an empty
	 * list when no persons are available
	 */
	public List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();

		for (Person eachPerson : persons) {

			persons.add(eachPerson);
		}
		return persons;
	}

	/**
	 * returns a student object for the given ID
	 * an exception is raised when the student for the given
	 * ID does not exist 
	 */
	public Student getStudent(String aId) throws StudentNotFoundException {

		Student student;
		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student && eachPerson.getId().equals(aId)) {
				student = (Student) eachPerson;
				return student;
			}
		}
		
		throw new StudentNotFoundException("Student does not exist");
	}

	/**
	 * returns a teacher object for the given ID
	 * no exception is raised when the teacher for the given
	 * ID does not exist  
	 */
	public Teacher getTeacher(String aId) {

		Teacher teacher;
		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student && eachPerson.getId().equals(aId)) {
				teacher = (Teacher) eachPerson;
				return teacher;
			}
		}
		return null;
	}

	/**
	 * returns a list of students - in case there are
	 * no students an empty list is returned
	 */
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();

		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student) {
				students.add((Student) eachPerson);
			}
		}

		return students;
	}

	/**
	 * returns a list of teachers - in case there are
	 * no teachers an empty list is returned
	 */
	public List<Teacher> getTeachers() {
		List<Teacher> teacher = new ArrayList<Teacher>();

		for (Person eachPerson : persons) {

			if (eachPerson instanceof Teacher) {
				teacher.add((Teacher) eachPerson);
			}
		}

		return teacher;
	}

	/** 
	 * prints a list of all persons to the standard
	 * output
	 */
	public void printPersons() {
		for (Person eachPerson : persons) {

			System.out.println(eachPerson);

		}
	}

	/**
	 * prints a list of students to the standard
	 * output
	 */
	public void printStudents() {
		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student) {
				System.out.println(eachPerson);
			}
		}
	}

	/**
	 * prints a list of teachers to the standard
	 * output
	 */
	public void printTeacher() {

		for (Person eachPerson : persons) {

			if (eachPerson instanceof Teacher) {
				System.out.println(eachPerson);
			}
		}
	}

	/**
	 * returns the name of the university
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the university
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns a course object
	 */
	public Course getCourses() {
		return course;
	}

	/**
	 * setter for the course 
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * returns a ClassRoom object
	 */
	public ClassRoom getClassRoom() {
		return classRoom;
	}

	/**
	 *  setter for the ClassRoom
	 */
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	
	public void setTeaching(Teaching teaching) {
		this.teaching = teaching;
	}
	
	public Teaching getTeaching()
	{
		return teaching;
	}
}
