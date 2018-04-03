import main.University;
import main.UniversityGui;

public class AppMain {

	public static void main(String[] args) {

		University university = new University("UoL Online");

		university.addPerson("First1", "Last1");
		university.addPerson("First2", "Last2");
		university.addPerson("First3", "Last3");
		university.addPerson("First4", "Last4");

		university.addTeacher("TFirst1", "TLast1", "1111", "Prof. IT");
		university.addTeacher("TFirst2", "TLast2", "2222", "Prof. Law");
		university.addTeacher("TFirst3", "TLast3", "3333", "Prof. Medicine");
		university.addTeacher("TFirst4", "TLast4", "4444", "Prof. Physics");

		university.addStudent("SFirst1", "SLast1", "S1111", 1);
		university.addStudent("SFirst2", "SLast2", "S2222", 2);
		university.addStudent("SFirst3", "SLast3", "S3333", 3);
		university.addStudent("SFirst4", "SLast4", "S4444", 2);

		UniversityGui.startUniversity(university);
	}

}
