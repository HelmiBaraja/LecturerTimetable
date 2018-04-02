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

}
