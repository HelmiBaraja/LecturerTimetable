package main;


interface ClassRoomInterface{
	void addClassRoom(ClassRoomModel classModel);
}

	//put abstract since we don't need to override interface method
	//empty abstract
public abstract class ClassRoomBase implements ClassRoomInterface{}

