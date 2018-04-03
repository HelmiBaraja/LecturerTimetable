package main;

import java.util.ArrayList;
import java.util.List;

import exceptions.StudentNotFoundException;
import exceptions.WrongActualParameterException;

/**
 * @author ansgar.goeb 
 * (and contribution from Chan and Helmi to
 *  implemented their project-work)
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
		
		// add the student ot the list of persons
		persons.add(student);
	}

	/**
	 * Adds a teacher to the list of persons.
	 * (not exception will be thrown not to damage Chan's program) 
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
	 * (not exception will be thrown not to damage Chan's program) 
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

	public List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();

		for (Person eachPerson : persons) {

			persons.add(eachPerson);
		}
		return persons;
	}

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

	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();

		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student) {
				students.add((Student) eachPerson);
			}
		}

		return students;
	}

	public List<Teacher> getTeachers() {
		List<Teacher> teacher = new ArrayList<Teacher>();

		for (Person eachPerson : persons) {

			if (eachPerson instanceof Teacher) {
				teacher.add((Teacher) eachPerson);
			}
		}

		return teacher;
	}

	public void printPersons() {
		for (Person eachPerson : persons) {

			System.out.println(eachPerson);

		}
	}

	public void printStudents() {
		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student) {
				System.out.println(eachPerson);
			}
		}
	}

	public void printTeacher() {

		for (Person eachPerson : persons) {

			if (eachPerson instanceof Teacher) {
				System.out.println(eachPerson);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourses() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
