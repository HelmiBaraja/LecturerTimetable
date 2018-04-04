package main;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom extends ClassRoomBase{

	private int idCOunter= 0;

	public List<ClassRoomModel> getClassList() {
		return classList;
	}

	public void setClassList(List<ClassRoomModel> classList) {
		this.classList = classList;
	}

	public String[] getClassRooms()
	{
		String classRooms [] = new String[classList.size()];
		for (int i =0 ; i<classList.size(); i++) {
			classRooms[i]= classList.get(i).getRoomNo();
		}
		
		return classRooms;
	}
	
	private List<ClassRoomModel> classList = new ArrayList<>();

	@Override
	public void addClassRoom(ClassRoomModel classModel) {
		idCOunter++;
		classModel.setId(idCOunter);
		classList.add(classModel);
	}

	public void printClasses()
	{
		for(int i=0; i<classList.size();i++)
		{
			System.out.println(classList.get(i).toString());
		}
	}
	
	public void deleteClassRoomByID(int aId) {

		for (ClassRoomModel eachRoom : classList) {

			if (eachRoom.getId() == aId ) {
				classList.remove(eachRoom);
				return;
			}
		}
	}
}
