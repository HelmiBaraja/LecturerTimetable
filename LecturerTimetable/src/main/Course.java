package main;

import java.util.ArrayList;
import java.util.List;

public class Course extends CourseBase{

	List<CourseModel> coursesList = new ArrayList<>();
	
	@Override
	public void addOnlineCourse(CourseModel courseModel) {
		// TODO Auto-generated method stub
		courseModel.setOnlineCourse(true);
		coursesList.add(courseModel);
	}

	@Override
	public void addOfflineCourse(CourseModel courseModel) {
		// TODO Auto-generated method stub
		courseModel.setOnlineCourse(false);
		coursesList.add(courseModel);
	}

	public void printCourses()
	{
		for(int i=0; i<coursesList.size();i++)
		{
			System.out.println(coursesList.get(i).toString());
		}
	}
	
}
