package main;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TeacherTab {

	JTable classRoomTable;
	University university;
	
	
	public void initializeTeacherTab(JTabbedPane tabbedPane, University university)
	{
	this.university=university;
		
		JPanel teacherTab = new JPanel();
		tabbedPane.addTab("Teachers", null, teacherTab, null);
		teacherTab.setLayout(null);
	}
}
