package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import misc.Util;

public class CourseTab {

	JTable courseTable;
	University university;
	JTextField courseIDField;
	JTextField courseCodeField;
	JTextField courseNameField ;
	JTextField courseEndDateField ;
	JTextField courseStartDateField ;

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
		
		courseIDField = new JTextField();
		courseIDField.setBounds(28, 66, 86, 20);
		courseIDField.setColumns(10);
		courseTab.add(courseIDField);
		
		JLabel courseCodeLabel = new JLabel("Course Code");
		courseCodeLabel.setBounds(28, 108, 86, 14);
		courseTab.add(courseCodeLabel);
		
		courseCodeField = new JTextField();
		courseCodeField.setBounds(28, 122, 161, 20);
		courseCodeField.setColumns(10);
		courseTab.add(courseCodeField);
		
		JLabel courseNameLabel = new JLabel("Course Name");
		courseNameLabel.setBounds(28, 147, 86, 14);
		courseTab.add(courseNameLabel);
		
		courseNameField = new JTextField();
		courseNameField.setBounds(28, 160, 161, 20);
		courseTab.add(courseNameField);
		courseNameField.setColumns(10);
		
		JLabel courseStartDateLabel = new JLabel("Start date");
		courseStartDateLabel.setBounds(28, 191, 86, 14);
		courseTab.add(courseStartDateLabel);
		
		courseStartDateField = new JTextField();
		courseStartDateField.setBounds(28, 203, 161, 20);
		courseTab.add(courseStartDateField);
		courseStartDateField.setColumns(10);
		
		
		JLabel courseEndDateLabel = new JLabel("End Date");
		courseEndDateLabel.setBounds(28, 234, 86, 14);
		courseTab.add(courseEndDateLabel);
		
		courseEndDateField = new JTextField();
		courseEndDateField.setBounds(28, 248, 161, 20);
		courseTab.add(courseEndDateField);
		courseEndDateField.setColumns(10);
		
		
		JButton courseBtnSave = new JButton("save");
		courseBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!courseIDField.getText().isEmpty()) {
					CourseModel courseModel = university.getCourses().getCourseByID(Integer.parseInt(courseIDField.getText().toString()));
					
					courseModel.setName(courseNameField.getText().toString());
					courseModel.setCode(courseCodeField.getText().toString());
					courseModel.setStartDate(Util.parseDate(courseStartDateField.getText().toString()));
					courseModel.setEndDate(Util.parseDate(courseEndDateField.getText().toString()));
					
										
				}
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnSave.setBounds(54, 312, 89, 23);
		courseTab.add(courseBtnSave);

		JButton courseBtnDelete = new JButton("delete");
		courseBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				university.getCourses().deleteCourseByID(Integer.parseInt(courseIDField.getText().toString()));
				
				
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnDelete.setBounds(54, 346, 89, 23);
		courseTab.add(courseBtnDelete);

		JButton courseBtnCreate = new JButton("create");
		courseBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CourseModel courseModel = new CourseModel(courseNameField.getText().toString(), 
						Util.parseDate(courseStartDateField.getText().toString()), 
						Util.parseDate(courseEndDateField.getText().toString()), 
						courseCodeField.getText().toString());
				
				university.getCourses().addOfflineCourse(courseModel);
				
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnCreate.setBounds(54, 380, 89, 23);
		courseTab.add(courseBtnCreate);
		
		courseTable = new JTable();
		courseTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Course Code", "Course Name", "Start Date", "End Date" }));
				
		courseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = courseTable.getSelectedRow();
				updateCourseDetail( (int) courseTable.getValueAt(row, 0));
			}
		});
		
		courseTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fillCourseTable();
				infoField.setText(university.getName());
				scrollPane.setViewportView(courseTable);

			}
		});
		
		
	}
	
	private void updateCourseDetail(int aId) {

		CourseModel course = university.getCourses().getCourseByID(aId);

		courseIDField.setText(course.getId()+"");
		courseCodeField.setText(course.getCode());
		courseNameField.setText(course.getName());
		courseStartDateField.setText(Util.getStringDate(course.getStartDate()));
		courseEndDateField.setText(Util.getStringDate(course.getEndDate()));
	}
	
	private void fillCourseTable() {

		DefaultTableModel model = (DefaultTableModel) courseTable.getModel();

		model.getDataVector().removeAllElements();

		List<CourseModel> courses = university.getCourses().getCoursesList();
		System.out.println(courses.size()+"");
		for (CourseModel eachCourse : courses) {
			Object[] row = { eachCourse.getId(), eachCourse.getCode(), eachCourse.getName(),
					eachCourse.getStartDate(), eachCourse.getEndDate() };

			model.addRow(row);

		}

	}
	
	private void clearFields() {
		courseIDField.setText("");
		courseCodeField.setText("");
		courseNameField.setText("");
		courseStartDateField.setText("");
		courseEndDateField.setText("");
	}
}
