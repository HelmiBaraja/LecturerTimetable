package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CourseTab {

	JTable courseTable;
	University university;
	
	public void initializeCourseTab(JTabbedPane tabbedPane, University university)
	{
		this.university=university;
		
		JPanel courseTab = new JPanel();
		tabbedPane.addTab("Courses", null, courseTab, null);
		courseTab.setLayout(null);
		
		JTextField infoField = new JTextField();
		infoField.setEditable(false);
		infoField.setBounds(28, 11, 161, 20);
		courseTab.add(infoField);
		infoField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 521, 392);
		courseTab.add(scrollPane);
		
		JLabel courseIDLabel = new JLabel("Course ID");
		courseIDLabel.setBounds(30, 52, 66, 14);
		courseTab.add(courseIDLabel);
		
		JTextField courseIDField = new JTextField();
		courseIDField.setBounds(28, 66, 86, 20);
		courseIDField.setColumns(10);
		courseTab.add(courseIDField);
		
		JLabel courseCodeLabel = new JLabel("Course Code");
		courseCodeLabel.setBounds(28, 108, 86, 14);
		courseTab.add(courseCodeLabel);
		
		JTextField courseCodeField = new JTextField();
		courseCodeField.setBounds(28, 122, 161, 20);
		courseCodeField.setColumns(10);
		courseTab.add(courseCodeField);
		
		JLabel courseNameLabel = new JLabel("Course Name");
		courseNameLabel.setBounds(28, 147, 86, 14);
		courseTab.add(courseNameLabel);
		
		JTextField courseNameField = new JTextField();
		courseNameField.setBounds(28, 160, 161, 20);
		courseTab.add(courseNameField);
		courseNameField.setColumns(10);
		
		JLabel startDateLabel = new JLabel("Start date");
		startDateLabel.setBounds(28, 191, 86, 14);
		courseTab.add(startDateLabel);
		
		JTextField startDateField = new JTextField();
		startDateField.setBounds(28, 203, 161, 20);
		courseTab.add(startDateField);
		startDateField.setColumns(10);
		
		
		JLabel endDateLabel = new JLabel("End Date");
		endDateLabel.setBounds(28, 234, 86, 14);
		courseTab.add(endDateLabel);
		
		JTextField endDateField = new JTextField();
		endDateField.setBounds(28, 248, 161, 20);
		courseTab.add(endDateField);
		endDateField.setColumns(10);
		
		
		JButton courseBtnSave = new JButton("save");
		courseBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		courseBtnSave.setBounds(54, 312, 89, 23);
		courseTab.add(courseBtnSave);

		JButton courseBtnDelete = new JButton("delete");
		courseBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		courseBtnDelete.setBounds(54, 346, 89, 23);
		courseTab.add(courseBtnDelete);

		JButton courseBtnCreate = new JButton("create");
		courseBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		courseBtnCreate.setBounds(54, 380, 89, 23);
		courseTab.add(courseBtnCreate);
		
		courseTable = new JTable();
		courseTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Course Code", "Course Name", "Start Date", "End Date" }));
				
		courseTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fillCourseTable();
				infoField.setText(university.getName());
				scrollPane.setViewportView(courseTable);

			}
		});
	}
	
	private void fillCourseTable() {

		DefaultTableModel model = (DefaultTableModel) courseTable.getModel();

		model.getDataVector().removeAllElements();

		List<CourseModel> courses = university.getCourses();
		System.out.println(courses.size()+"");
		for (CourseModel eachCourse : courses) {
			Object[] row = { eachCourse.getId(), eachCourse.getCode(), eachCourse.getName(),
					eachCourse.getStartDate(), eachCourse.getEndDate() };

			model.addRow(row);

		}

	}

}
