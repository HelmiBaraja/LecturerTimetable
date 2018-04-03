package main;


interface CourseMethod{
	void addOnlineCourse(CourseModel couseModel);
	void addOfflineCourse(CourseModel couseModel);

}

//put abstract since we don't need to override interface method
//empty abstract
public abstract class CourseBase implements CourseMethod{}
