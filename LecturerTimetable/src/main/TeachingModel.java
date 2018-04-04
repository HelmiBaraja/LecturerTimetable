package main;

public class TeachingModel {
	
	
	public TeachingModel(String teacherName, String courseCode, String classRoom) {
		super();
		this.teacherName = teacherName;
		this.courseCode = courseCode;
		this.classRoom = classRoom;
	}
	private int id;
	private String teacherName;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String courseCode;
	private String classRoom;
}
