package main;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ansgar.goeb
 *
 */
public class University {

    private String name;
    
    // use a List because the guarantee to provide a unique list
    // is ensured by the user-interface 
    private List<Person> persons = new ArrayList(); 
    
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

    // return a new list because there should be no reference
    // to the internal list
    // to-do - check immutable list
    public List<Person> getPersons() {
    	List<Person> persons = new ArrayList();
    	
        for(Person eachPerson : persons) {
            
        	persons.add(eachPerson);
        }
        return persons;
    }

    
    public List<Student> getStudents() {
    	List<Student> students = new ArrayList();
    	
        for(Person eachPerson : persons) {
            
            if (eachPerson instanceof Student) {
                students.add((Student) eachPerson);
            }
        }

        return students;
    }
    

    public List<Teacher> getTeacher() {
    	List<Teacher> teacher = new ArrayList();
    	
        for(Person eachPerson : persons) {
            
            if (eachPerson instanceof Teacher) {
                teacher.add((Teacher) eachPerson);
            }
        }

        return teacher;
    }
    
    public void printPersons() {
        for(Person eachPerson : persons) {
     
            System.out.println(eachPerson);
            
        }
    }
    
    public void printStudents() {
        for(Person eachPerson : persons) {
            
            if (eachPerson instanceof Student) {
                System.out.println(eachPerson);
            }
        }
    }
    
    public void printTeacher() {

        for(Person eachPerson : persons) {
        
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
    
}
