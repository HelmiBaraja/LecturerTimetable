package main;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import exceptions.StudentNotFoundException;
import exceptions.WrongActualParameterException;

/**
 * @author ansgar.goeb
 * 
 * This Class is the entry point for the user-interface
 * of the university. The interface shows one form with
 * several tabs representing:
 * 
 * - University
 * - Students
 * - Courses
 * - Class Rooms
 */
public class UniversityGui {

	// the main frame of the application
	private JFrame frame;
	
	// the frame to implement the tabbed-view
	private JTabbedPane tabbedPane;
	
	// reference to the object model of the university
	// university acts as a coordinating object
	private University university;
	
	// the name of the university
	private JTextField nameOfUniversity;
	
	// an info-field located at the right top
	// of most tabs
	private JTextField infoField;
	
	// the following variable a variables that are used
	// in the tab for showing, inserting, deleting students
	private JTable studentsTable;
	private JTextField studentPersonId;
	private JTextField studentFirstName;
	private JTextField studentLastName;
	private JTextField studentId;
	private JTextField semester;

	// ***********************************************************************************
	// method to start the university app
	// ***********************************************************************************

	/**
	 * static main class to start the user interface
	 * it assigns the university as a coordinating class
	 */
	public static void startUniversity(University aUniversity) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// create the windows showing the application
				UniversityGui window = new UniversityGui();
				window.setUniversity(aUniversity);
				
				// initializes the different parts
				window.initialize();
				window.frame.setVisible(true);
			}
		});
	}

	// ***********************************************************************************
	// methods in relation to the university tab
	// ***********************************************************************************

	/**
	 * initializes the tab for showing information about the
	 * university
	 */
	private void initializeUniversityTab() {
		
		// create a JPanel and add it to the main tapped pain
		JPanel universityTab = new JPanel();
		tabbedPane.addTab("University", null, universityTab, null);
		universityTab.setLayout(null);

		// create a field showing the name of the university 
		nameOfUniversity = new JTextField();
		nameOfUniversity.setBounds(58, 121, 321, 29);
		universityTab.add(nameOfUniversity);
		nameOfUniversity.setColumns(10);

		// adding a label to the field 'name of university'
		JLabel lblNameOfThe = new JLabel("Name of the University");
		lblNameOfThe.setBounds(58, 95, 133, 20);
		universityTab.add(lblNameOfThe);

		// adding a button to save the changed name of the university
		JButton updateUniversity = new JButton("Update");

		// action listener for the update-button 'name of the university'
		updateUniversity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// setting the content of the text field to university 
				// object
				university.setName(nameOfUniversity.getText());
			}
		});

		// setting the size of the button
		updateUniversity.setBounds(58, 176, 89, 23);

		// adding the button to the university frame
		universityTab.add(updateUniversity);

		// set the text of the field 'name of university' to the
		// name of the university (from the university object)
		setUniversityName();

		// add a listener to the tab 'university' - every time 
		// when it is shown, the name of the university is 
		// automatically updated
		universityTab.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				setUniversityName();
			}
		});
	}

	/**
	 * sets the text field of the university
	 * (from the university object)
	 */
	private void setUniversityName() {

		nameOfUniversity.setText(university.getName());
	}

	
	// ***********************************************************************************
	// methods in relation to the students tab
	// ***********************************************************************************

	/**
	 * method to fill the JTable of students in the students tab
	 * all students are loaded from the object model and inserted
	 * into the JTable 
	 */
	private void fillStudentsTable() {

		// get the default table model from studentsTable (JTable)
		DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();

		// remove all existing entry
		model.getDataVector().removeAllElements();

		// get the list of the students from the object model
		List<Student> students = university.getStudents();

		// loop through all students and add the students one by one to the JTable
		for (Student eachStudent : students) {

			// create an array of one object for one record in the JTable
			Object[] row = { eachStudent.getId(), eachStudent.getFirstName(), eachStudent.getLastName(),
					eachStudent.getStudentId(), eachStudent.getSemester() };

			// add the row to the JTable
			model.addRow(row);
		}
	}

	private void initializeStudentsTab() {

		JPanel studentsTab = new JPanel();
		tabbedPane.addTab("Students", null, studentsTab, null);
		studentsTab.setLayout(null);

		infoField = new JTextField();
		infoField.setEditable(false);
		infoField.setBounds(28, 11, 161, 20);
		studentsTab.add(infoField);
		infoField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 521, 392);
		studentsTab.add(scrollPane);

		studentPersonId = new JTextField();
		studentPersonId.setEditable(false);
		studentPersonId.setBounds(28, 66, 86, 20);
		studentsTab.add(studentPersonId);
		studentPersonId.setColumns(10);

		JLabel personIdLabel = new JLabel("Persond ID");
		personIdLabel.setBounds(30, 52, 66, 14);
		studentsTab.add(personIdLabel);

		studentFirstName = new JTextField();
		studentFirstName.setBounds(28, 122, 161, 20);
		studentsTab.add(studentFirstName);
		studentFirstName.setColumns(10);

		studentLastName = new JTextField();
		studentLastName.setBounds(28, 160, 161, 20);
		studentsTab.add(studentLastName);
		studentLastName.setColumns(10);

		studentId = new JTextField();
		studentId.setBounds(28, 203, 161, 20);
		studentsTab.add(studentId);
		studentId.setColumns(10);

		semester = new JTextField();
		semester.setBounds(28, 248, 161, 20);
		studentsTab.add(semester);
		semester.setColumns(10);

		JButton studentBtnSave = new JButton("save");
		studentBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (studentPersonId.getText().isEmpty()) {

					try {

						university.addStudent(studentFirstName.getText(), studentLastName.getText(), studentId.getText(),
								Integer.parseInt(semester.getText()));

						studentPersonId.setText(null);
						studentFirstName.setText(null);
						studentLastName.setText(null);
						studentId.setText(null);
						semester.setText(null);
					
					} catch (NumberFormatException | WrongActualParameterException e) {
						
						JOptionPane.showMessageDialog(null,"one of the input parameter is not filled");
					}
				
				
				} else {

					Student student;
					try {
						student = university.getStudent(studentPersonId.getText());
						
						student.setFirstName(studentFirstName.getText());
						student.setLastName(studentLastName.getText());
						student.setSemester(Integer.valueOf(semester.getText()));
						student.setStudentId(studentId.getText());
						
						studentPersonId.setText(null);
						studentFirstName.setText(null);
						studentLastName.setText(null);
						studentId.setText(null);
						semester.setText(null);

					
					} catch (StudentNotFoundException e) {

						JOptionPane.showMessageDialog(null,"Student could not be found");
						e.printStackTrace();
					}
				}

				fillStudentsTable();
			}
		});
		studentBtnSave.setBounds(54, 312, 89, 23);
		studentsTab.add(studentBtnSave);

		JButton studentBtnDelete = new JButton("delete");
		studentBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
				
					university.deleteStudent(studentPersonId.getText());
					studentPersonId.setText(null);
					studentFirstName.setText(null);
					studentLastName.setText(null);
					studentId.setText(null);
					semester.setText(null);
					fillStudentsTable();
				
				} catch (StudentNotFoundException e) {

					JOptionPane.showMessageDialog(null,"Student could not be found");
					e.printStackTrace();
				}
			}
		});
		studentBtnDelete.setBounds(54, 346, 89, 23);
		studentsTab.add(studentBtnDelete);

		JButton studentBtnCreate = new JButton("create");
		studentBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				studentPersonId.setText(null);
				studentFirstName.setText(null);
				studentLastName.setText(null);
				studentId.setText(null);
				semester.setText(null);

			}
		});
		studentBtnCreate.setBounds(54, 380, 89, 23);
		studentsTab.add(studentBtnCreate);

		JLabel studentFirstNameLabel = new JLabel("Firstname");
		studentFirstNameLabel.setBounds(28, 108, 86, 14);
		studentsTab.add(studentFirstNameLabel);

		JLabel studentLastNameLabel = new JLabel("Lastname");
		studentLastNameLabel.setBounds(28, 147, 86, 14);
		studentsTab.add(studentLastNameLabel);

		JLabel studentIdLabel = new JLabel("Student-ID");
		studentIdLabel.setBounds(28, 191, 86, 14);
		studentsTab.add(studentIdLabel);

		JLabel semesterLabel = new JLabel("Semester");
		semesterLabel.setBounds(28, 234, 86, 14);
		studentsTab.add(semesterLabel);

		studentsTable = new JTable();
		studentsTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "First Name", "Last Name", "Student ID", "Semester" }) 
		                    {private static final long serialVersionUID = 1L;

			                 @Override
			                 public boolean isCellEditable(int row, int column) {
			                     // all cells false
			                 return false;
			                }
		});

		studentsTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				infoField.setText(university.getName());
				fillStudentsTable();
				scrollPane.setViewportView(studentsTable);
			}
		});

		studentsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = studentsTable.getSelectedRow();
				updateStudentsDetail((String) studentsTable.getValueAt(row, 0));
			}
		});

	}

	private void updateStudentsDetail(String aId) {

		try {

			Student student = university.getStudent(aId);
			studentPersonId.setText(student.getId());
			studentFirstName.setText(student.getFirstName());
			studentLastName.setText(student.getLastName());
			studentId.setText(student.getStudentId());
			semester.setText(String.valueOf(student.getSemester()));

		} catch (StudentNotFoundException e) {

			JOptionPane.showMessageDialog(null,"Student could not be located for update");
			e.printStackTrace();
		}
	}

	// ***********************************************************************************
	// method to initialize the different components of the university app
	// ***********************************************************************************
	private void initialize() {

		// create the main JFrame
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// use the standard layout
		frame.getContentPane().setLayout(null);

		// creates the tabbed pain as a container for other frames
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 756, 453);
		frame.getContentPane().add(tabbedPane);

		// initializes all objects for the university tab
		initializeUniversityTab();
		
		// initializes all objects for the students tab
		initializeStudentsTab();
		
		// creates the course object and initializes
		// the tab showing the courses
		CourseTab courseTab = new CourseTab();
		courseTab.initializeCourseTab(tabbedPane, university);
	
		// creates the ClassRoomTab and initializes
		// the tab showing the classrooms 
		ClassRoomTab clssTab = new ClassRoomTab();
		clssTab.initializeClassTab(tabbedPane, university);
	}

	// ***********************************************************************************
	// common methods
	// ***********************************************************************************

	// standard constructor 
	public UniversityGui() {
	}

	/**
	 * setter for the university as entry point to the
	 * university objects
	 */
	public void setUniversity(University university) {
		this.university = university;
	}
}
