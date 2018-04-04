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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import exceptions.StudentNotFoundException;
import exceptions.TeacherNotFoundException;
import exceptions.WrongActualParameterException;

public class TeacherTab {

	JTable classRoomTable;
	University university;
	JTextField teacherIDField;
	JTextField firstNameField;
	JTextField lastNameField;
	JTextField employeeIDField; 
	JTextField titleField;
	JTable teacherTable;
	
	public void initializeTeacherTab(JTabbedPane tabbedPane, University university)
	{
	this.university=university;
		
		JPanel teacherTab = new JPanel();
		tabbedPane.addTab("Teachers", null, teacherTab, null);
		teacherTab.setLayout(null);
		
		JTextField infoField = new JTextField();
		infoField.setEditable(false);
		infoField.setBounds(28, 11, 161, 20);
		teacherTab.add(infoField);
		infoField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 521, 392);
		teacherTab.add(scrollPane);
		
		JLabel teacherIDLabel = new JLabel("ID");
		teacherIDLabel.setBounds(30, 52, 66, 14);
		teacherTab.add(teacherIDLabel);
		
		teacherIDField = new JTextField();
		teacherIDField.setBounds(28, 66, 86, 20);
		teacherIDField.setColumns(10);
		teacherTab.add(teacherIDField);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(28, 108, 86, 14);
		teacherTab.add(firstNameLabel);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(28, 122, 161, 20);
		firstNameField.setColumns(10);
		teacherTab.add(firstNameField);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(28, 147, 86, 14);
		teacherTab.add(lastNameLabel);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(28, 160, 161, 20);
		lastNameField.setColumns(10);
		teacherTab.add(lastNameField);
		
		JLabel employeeIDLabel = new JLabel("Employee ID");
		employeeIDLabel.setBounds(28, 191, 86, 14);
		teacherTab.add(employeeIDLabel);
		
		employeeIDField = new JTextField();
		employeeIDField.setBounds(28, 203, 161, 20);
		teacherTab.add(employeeIDField);
		employeeIDField.setColumns(10);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(28, 234, 86, 14);
		teacherTab.add(titleLabel);
		
		titleField = new JTextField();
		titleField.setBounds(28, 248, 161, 20);
		teacherTab.add(titleField);
		titleField.setColumns(10);
		
		JButton teacherBtnSave = new JButton("save");
		teacherBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// in case the person ID is not yet filled the teacher is not
				// yet saved in the person database, therefore a new teacher needs
				// to be created
				if (teacherIDField.getText().isEmpty()) {

					try {

						// calls the method of the coordinating object to create a new student
						university.addTeacher(firstNameField.getText()
								             , lastNameField.getText()
								             , employeeIDField.getText()
								             , titleField.getText());

				
					
					} // in case the input parameter are not filled correctly a message is shown
					  // to the user that the operation was not successfully
					  catch (NumberFormatException e) {
						
						JOptionPane.showMessageDialog(null,"one of the input parameter is not filled");
					}
				
				
				} // the person id is filled - the teacher already exists in the database instead of 
				  // creating a teacher, the existing teacher can be updated
				  else {

					// get the object of the student from the 'database' and update the
					// the properties of the student
					Teacher teacher;
					// get the student with the known person id
					teacher = university.getTeacher(teacherIDField.getText());
					
					// set the properties
					teacher.setFirstName(firstNameField.getText());
					teacher.setLastName(lastNameField.getText());
					teacher.setExmplyeeId(employeeIDField.getText());
					teacher.setFunction(titleField.getText());
				}
				clearFields();
				fillTeacherTable();
			}
				
		});
		teacherBtnSave.setBounds(54, 312, 89, 23);
		teacherTab.add(teacherBtnSave);

		JButton teacherBtnDelete = new JButton("delete");
		teacherBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				university.getCourses().deleteCourseByID(Integer.parseInt(courseIDField.getText().toString()));
				
				// call the method from the coordinating class to
				// delete the teacher
				university.deleteTeacher(teacherIDField.getText());
			
				clearFields();
				fillTeacherTable();
			}
		});
		teacherBtnDelete.setBounds(54, 346, 89, 23);
		teacherTab.add(teacherBtnDelete);

		JButton teacherBtnCreate = new JButton("create");
		teacherBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				university.addTeacher(firstNameField.getText()
			             , lastNameField.getText()
			             , employeeIDField.getText()
			             , titleField.getText());
				
				clearFields();
				fillTeacherTable();
			}
		});
		teacherBtnCreate.setBounds(54, 380, 89, 23);
		teacherTab.add(teacherBtnCreate);
		
		teacherTable = new JTable();
		teacherTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "First Name", "Last Name", "Employee ID", "Title"}));
				
		teacherTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = teacherTable.getSelectedRow();
				updateTeacherDetail( (String) teacherTable.getValueAt(row, 0));
			}
		});
		
		teacherTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fillTeacherTable();
				infoField.setText(university.getName());
				scrollPane.setViewportView(teacherTable);

			}
		});
	}
	
	private void updateTeacherDetail(String aId) {
		System.out.println(aId+" d");
		Teacher teacher = university.getTeacher(aId);

		teacherIDField.setText(teacher.getId()+"");
		firstNameField.setText(teacher.getFirstName());
		lastNameField.setText(teacher.getLastName());
		employeeIDField.setText(teacher.getExmplyeeId());
		titleField.setText(teacher.getFunction());
	}
	
	private void fillTeacherTable() {

		DefaultTableModel model = (DefaultTableModel) teacherTable.getModel();

		model.getDataVector().removeAllElements();

		List<Teacher> teachers = university.getTeachers();
		for (Teacher eachTeacher : teachers) {
			Object[] row = { eachTeacher.getId(), eachTeacher.getFirstName(), eachTeacher.getLastName(),
					eachTeacher.getExmplyeeId(), eachTeacher.getFunction()};

			model.addRow(row);

		}

	}
	
	private void clearFields() {
		teacherIDField.setText("");
		firstNameField.setText("");
		lastNameField.setText("");
		employeeIDField.setText("");
		titleField.setText("");
	}
}
