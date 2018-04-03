package main;

import java.util.Date;

public class CourseModel {
	
	@Override
	public String toString() {
		return "CourseModel [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", code=" + code
				+ ", isOnlineCourse=" + isOnlineCourse + "]";
	}
	public CourseModel(String name, Date startDate, Date endDate, String code) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.code = code;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isOnlineCourse() {
		return isOnlineCourse;
	}
	public void setOnlineCourse(boolean isOnlineCourse) {
		this.isOnlineCourse = isOnlineCourse;
	}
	private Date startDate;
	private Date endDate;
	private String code;
	private boolean isOnlineCourse;
}
