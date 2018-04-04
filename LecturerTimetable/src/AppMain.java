import exceptions.WrongActualParameterException;
import main.ClassRoom;
import main.ClassRoomModel;
import main.Course;
import main.CourseModel;
import main.Teaching;
import main.TeachingModel;
import main.University;
import main.UniversityGui;
import main.ClassRoomModel.Size;
import misc.Util;

public class AppMain {

	public static void main(String[] args) {

		University university = new University("UoL Online");

		university.addPerson("First1", "Last1");
		university.addPerson("First2", "Last2");
		university.addPerson("First3", "Last3");
		university.addPerson("First4", "Last4");

		university.addTeacher("Vladimir", "Gubanov", "1213", "Prof. IT");


		try {
			university.addStudent("Ansgar", "Gaib", "S1111", 1);
			university.addStudent("Helmi", "Hasan", "S2222", 2);
			university.addStudent("Chan", "Yue", "S3333", 3);
			
		} catch (WrongActualParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 	Course course  = new Course();
	    course.addOfflineCourse(new CourseModel("Object Oriented Programming", Util.parseDate("2017-05-12"), 
	    		Util.parseDate("2017-05-12"), "CK1923"));
	    
	    course.addOnlineCourse(new CourseModel("Introduction to Java", Util.parseDate("2017-05-12"), 
	    		Util.parseDate("2017-05-12"), "CK3323"));
	    
	    course.addOnlineCourse(new CourseModel("Introduction to C", Util.parseDate("2017-04-12"), 
	    		Util.parseDate("2017-06-12"), "CD233"));
	    
	    university.setCourse(course);
	    
	    
	    ClassRoom classRoom  = new ClassRoom();
	 	
	    classRoom.addClassRoom(new ClassRoomModel("13A", Size.BIG));
	    classRoom.addClassRoom(new ClassRoomModel("23B", Size.SMALL));
	    classRoom.addClassRoom(new ClassRoomModel("1B", Size.MEDIUM));
	 	
	    university.setClassRoom(classRoom);

	    Teaching teaching = new Teaching();
	    teaching.addTeaching(new TeachingModel("Vladimir", 
	    		course.getCourseByID(1).getCode(), 
	    		classRoom.getClassList().get(1).getRoomNo()));

	    university.setTeaching(teaching);

	    
		UniversityGui.startUniversity(university);
	}

}
