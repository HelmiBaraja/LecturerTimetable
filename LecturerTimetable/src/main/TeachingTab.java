package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TeachingTab {

	JTable teachingTable;
	University university;
	
	JTextField teachingIDField;
	JComboBox<String> teacherCombo;
	JComboBox<String> courseCombo;
	JComboBox<String> classRoomCombo;
	int selectedIndex;

	public void initializeTeachingTab(JTabbedPane tabbedPane, University university)
	{
		this.university=university;
		
		JPanel teachingTab = new JPanel();
		tabbedPane.addTab("Teaching", null, teachingTab, null);
		teachingTab.setLayout(null);
		
		JTextField infoField = new JTextField();
		infoField.setEditable(false);
		infoField.setBounds(28, 11, 161, 20);
		teachingTab.add(infoField);
		infoField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 521, 392);
		teachingTab.add(scrollPane);
		
		JLabel teachingIDLabel = new JLabel("ID");
		teachingIDLabel.setBounds(30, 52, 66, 14);
		teachingTab.add(teachingIDLabel);
		
		teachingIDField = new JTextField();
		teachingIDField.setBounds(28, 66, 86, 20);
		teachingIDField.setColumns(10);
		teachingIDField.setEditable(false);
		teachingTab.add(teachingIDField);
		
		JLabel teacherLabel = new JLabel("Teacher");
		teacherLabel.setBounds(28, 108, 86, 14);
		teachingTab.add(teacherLabel);
		
		teacherCombo = new JComboBox<String>(university.getTeacherArray());
		teacherCombo.setBounds(28, 122, 161, 20);
		teachingTab.add(teacherCombo);
		
		JLabel courseLabel = new JLabel("Course");
		courseLabel.setBounds(28, 147, 86, 14);
		teachingTab.add(courseLabel);
		
		courseCombo = new JComboBox<String>(university.getCourses().getCourseCodes());
		courseCombo.setBounds(28, 160, 161, 20);
		teachingTab.add(courseCombo);

		JLabel classRoomLabel = new JLabel("Class Room");
		classRoomLabel.setBounds(28, 191, 86, 14);
		teachingTab.add(classRoomLabel);
		
		classRoomCombo = new JComboBox<String>(university.getClassRoom().getClassRooms());
		classRoomCombo.setBounds(28, 203, 161, 20);
		teachingTab.add(classRoomCombo);
		
		JButton courseBtnSave = new JButton("save");
		courseBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!teachingIDField.getText().isEmpty()) {
					TeachingModel teachingModel = university.getTeaching().getTeachinglist().get(selectedIndex);
					teachingModel.setTeacherName((String) teacherCombo.getSelectedItem());
					teachingModel.setCourseCode((String)courseCombo.getSelectedItem());
					teachingModel.setClassRoom((String)classRoomCombo.getSelectedItem());

										
				}
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnSave.setBounds(54, 312, 89, 23);
		teachingTab.add(courseBtnSave);

		JButton courseBtnDelete = new JButton("delete");
		courseBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				university.getTeaching().deleteTeachingByID(Integer.parseInt(teachingIDField.getText().toString()));

				
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnDelete.setBounds(54, 346, 89, 23);
		teachingTab.add(courseBtnDelete);

		JButton courseBtnCreate = new JButton("create");
		courseBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeachingModel teachingModel = new TeachingModel((String)teacherCombo.getSelectedItem(), 
						(String)courseCombo.getSelectedItem(), 
						(String) classRoomCombo.getSelectedItem());
				
				university.getTeaching().addTeaching(teachingModel);
				
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnCreate.setBounds(54, 380, 89, 23);
		teachingTab.add(courseBtnCreate);
		
		
		teachingTable = new JTable();
		teachingTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Teacher", "Course", "Class Room No" }));
				
		teachingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selectedIndex= teachingTable.getSelectedRow();
				updateCourseDetail( (int) teachingTable.getValueAt(selectedIndex, 0) - 1 );
			}
		});
		
		teachingTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fillCourseTable();
				infoField.setText(university.getName());
				scrollPane.setViewportView(teachingTable);

			}
		});
	}
	
	private void updateCourseDetail(int aId) {
		TeachingModel teachingModel = university.getTeaching().getTeachinglist().get(aId);

		updateTeachingeDetail(teachingModel);
	}
	
	private void updateTeachingeDetail(TeachingModel teachingModel)
	{
		teachingIDField.setText(teachingModel.getId()+"");
		teacherCombo.setSelectedIndex(0);		
		courseCombo.setSelectedIndex(0);		
		classRoomCombo.setSelectedIndex(0);		

	}
	
	private void fillCourseTable() {

		DefaultTableModel model = (DefaultTableModel) teachingTable.getModel();

		model.getDataVector().removeAllElements();

		List<TeachingModel> teachingList = university.getTeaching().getTeachinglist();

		for (TeachingModel eachTeaching : teachingList) {
			Object[] row = { eachTeaching.getId(), eachTeaching.getTeacherName(), eachTeaching.getCourseCode(),eachTeaching.getClassRoom() };

			model.addRow(row);

		}

	}
	
	private void clearFields() {
		teachingIDField.setText("");
		teacherCombo.setSelectedIndex(0);
		courseCombo.setSelectedIndex(0);
		classRoomCombo.setSelectedIndex(0);
		
	}
}
