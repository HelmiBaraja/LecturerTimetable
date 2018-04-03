package main;

import misc.Util;

public class TestCourse {

    public static void main(String[] args) {

    	Course course  = new Course();
    course.addOfflineCourse(new CourseModel("Object Oriented Programming", Util.parseDate("2017-05-12"), 
    		Util.parseDate("2017-05-12"), "CK1923"));
    
    course.addOnlineCourse(new CourseModel("Introduction to Java", Util.parseDate("2017-05-12"), 
    		Util.parseDate("2017-05-12"), "CK3323"));
    
    course.addOnlineCourse(new CourseModel("Introduction to C", Util.parseDate("2017-04-12"), 
    		Util.parseDate("2017-06-12"), "CD233"));
    
    course.printCourses();
    }
}
