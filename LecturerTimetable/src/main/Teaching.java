package main;

import java.util.ArrayList;
import java.util.List;

public class Teaching extends TeachingBase{

	private int idCOunter= 0;
	
	public int getIdCOunter() {
		return idCOunter;
	}

	public void setIdCOunter(int idCOunter) {
		this.idCOunter = idCOunter;
	}

	public List<TeachingModel> getTeachinglist() {
		return teachinglist;
	}

	public void setTeachinglist(List<TeachingModel> teachinglist) {
		this.teachinglist = teachinglist;
	}

	private List<TeachingModel> teachinglist  = new ArrayList<>();

	@Override
	public void addTeaching(TeachingModel teachingModel) {
		idCOunter++;
		teachingModel.setId(idCOunter);
		teachinglist.add(teachingModel);
	} 
	
	public void printCourses()
	{
		for(int i=0; i<teachinglist.size();i++)
		{
			System.out.println(teachinglist.get(i).toString());
		}
	}
	
	public void deleteTeachingByID(int aId) {

		for (TeachingModel eachTeaching : teachinglist) {

			if (eachTeaching.getId() == aId ) {
				teachinglist.remove(eachTeaching);
				return;
			}
		}
	}
}
