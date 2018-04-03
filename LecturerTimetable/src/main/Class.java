package main;

import java.util.ArrayList;
import java.util.List;

public class Class extends ClassBase{

	List<ClassModel> classList = new ArrayList<>();

	@Override
	public void addClassRoom(ClassModel classModel) {
		classList.add(classModel);
	}

	public void printClasses()
	{
		for(int i=0; i<classList.size();i++)
		{
			System.out.println(classList.get(i).toString());
		}
	}
}
