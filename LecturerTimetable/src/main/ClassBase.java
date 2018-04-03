package main;


interface ClassRoomInterface{
	void addClassRoom(ClassModel classModel);
}

	//put abstract since we don't need to override interface method
	//empty abstract
public abstract class ClassBase implements ClassRoomInterface{}

