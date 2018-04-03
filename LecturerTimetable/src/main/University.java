package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ansgar.goeb
 */
public class University {

	private String name;

	// use a List because the guarantee to provide a unique list
	// is ensured by the user-interface
	private List<Person> persons = new ArrayList<Person>();
	private Course course;
	
	public University(String aName) {
		this.name = aName;
	}

	public void addPerson(String aFirstName, String aLastName) {
		Person person = new Person(aFirstName, aLastName);
		persons.add(person);
	}

	public void addStudent(String aFirstName, String aLastName, String aStudenId, int aSemester) {
		Student student = new Student(aFirstName, aLastName, aStudenId, aSemester);
		persons.add(student);
	}

	public void addTeacher(String aFirstName, String aLastName, String aEmplyeeId, String aFunction) {
		Teacher teacher = new Teacher(aFirstName, aLastName, aEmplyeeId, aFunction);
		persons.add(teacher);
	}

	public void deleteStudent(String aId) {

		Person person;
		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student && eachPerson.getId().equals(aId)) {
				person = eachPerson;
				persons.remove(person);
				return;
			}
		}
	}

	public void deleteTeacher(String aId) {

		Person person;
		for (Person eachPerson : persons) {

			if (eachPerson instanceof Teacher && eachPerson.getId().equals(aId)) {
				person = eachPerson;
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

	public Student getStudent(String aId) {

		Student student;
		for (Person eachPerson : persons) {

			if (eachPerson instanceof Student && eachPerson.getId().equals(aId)) {
				student = (Student) eachPerson;
				return student;
			}
		}

		return null;

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
