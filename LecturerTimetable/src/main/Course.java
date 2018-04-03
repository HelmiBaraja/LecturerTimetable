package main;

import java.util.ArrayList;
import java.util.List;

public class Course extends CourseBase{
	
	private int idCOunter= 0;
	private List<CourseModel> coursesList = new ArrayList<>();

	public List<CourseModel> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<CourseModel> coursesList) {
		this.coursesList = coursesList;
	}

	
	@Override
	public void addOnlineCourse(CourseModel courseModel) {
		// TODO Auto-generated method stub
		idCOunter++;
		courseModel.setId(idCOunter);
		courseModel.setOnlineCourse(true);
		coursesList.add(courseModel);
	}

	@Override
	public void addOfflineCourse(CourseModel courseModel) {
		// TODO Auto-generated method stub
		idCOunter++;
		courseModel.setId(idCOunter);
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
