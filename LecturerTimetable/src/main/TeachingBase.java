package main;

interface TeachingInterface{
	void addTeaching(TeachingModel teachingModel);
}

	//put abstract since we don't need to override interface method
	//empty abstract
public abstract class TeachingBase implements TeachingInterface{}
