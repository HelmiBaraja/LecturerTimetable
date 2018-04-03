package main;

import main.ClassModel.Size;
import misc.Util;

public class TestCourseAndClass {

    public static void main(String[] args) {

    	Course course  = new Course();
    course.addOfflineCourse(new CourseModel("Object Oriented Programming", Util.parseDate("2017-05-12"), 
    		Util.parseDate("2017-05-12"), "CK1923"));
    
    course.addOnlineCourse(new CourseModel("Introduction to Java", Util.parseDate("2017-05-12"), 
    		Util.parseDate("2017-05-12"), "CK3323"));
    
    course.addOnlineCourse(new CourseModel("Introduction to C", Util.parseDate("2017-04-12"), 
    		Util.parseDate("2017-06-12"), "CD233"));
    
    course.printCourses();
    
    
 	Class clss  = new Class();
 	
 	clss.addClassRoom(new ClassModel("13A", Size.BIG));
 	clss.addClassRoom(new ClassModel("23B", Size.SMALL));
 	clss.addClassRoom(new ClassModel("1B", Size.MEDIUM));

 	
    clss.printClasses();
    
    
    }
}
