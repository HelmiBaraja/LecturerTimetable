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
	 * @wbp.parser.entryPoint
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


	/**
	 * creates the students tab and adds it to the 
	 * jtabbed pane
	 */
	private void initializeStudentsTab() {

		// creates a JPanel for students and adds it to
		// tabbed pane
		JPanel studentsTab = new JPanel();
		tabbedPane.addTab("Students", null, studentsTab, null);
		studentsTab.setLayout(null);
		

		// adds an info field to the left top of the frame
		// the name of the university will be shown
		infoField = new JTextField();
		infoField.setEditable(false);
		infoField.setBounds(28, 11, 161, 20);
		studentsTab.add(infoField);
		infoField.setColumns(10);

		// adds a scroll pane to the frame that in case the
		// table with students grows an scroll bar appears
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 521, 392);
		studentsTab.add(scrollPane);

		// several text fields are added to show the properties
		// of a student and use it for creating and updating a
		// student
		
		// adds the person id - that is a id that make all persons -
		// teacher and students unique
		studentPersonId = new JTextField();
		studentPersonId.setEditable(false);
		studentPersonId.setBounds(28, 66, 86, 20);
		studentsTab.add(studentPersonId);
		studentPersonId.setColumns(10);

		// adds a label for the person ID
		JLabel personIdLabel = new JLabel("Person ID");
		personIdLabel.setBounds(30, 52, 66, 14);
		studentsTab.add(personIdLabel);

		// adds a field for the first name 
		studentFirstName = new JTextField();
		studentFirstName.setBounds(28, 122, 161, 20);
		studentsTab.add(studentFirstName);
		studentFirstName.setColumns(10);

		// create the label for the field first name
		JLabel studentFirstNameLabel = new JLabel("Firstname");
		studentFirstNameLabel.setBounds(28, 108, 86, 14);
		studentsTab.add(studentFirstNameLabel);


		// adds a field for the last name
		studentLastName = new JTextField();
		studentLastName.setBounds(28, 160, 161, 20);
		studentsTab.add(studentLastName);
		studentLastName.setColumns(10);
		
        // create the label for the field last name
		JLabel studentLastNameLabel = new JLabel("Lastname");
		studentLastNameLabel.setBounds(28, 147, 86, 14);
		studentsTab.add(studentLastNameLabel);


		// adds a field for the student ID
		studentId = new JTextField();
		studentId.setBounds(28, 203, 161, 20);
		studentsTab.add(studentId);
		studentId.setColumns(10);
		
		// create the table for the field student id
		JLabel studentIdLabel = new JLabel("Student-ID");
		studentIdLabel.setBounds(28, 191, 86, 14);
		studentsTab.add(studentIdLabel);

		// adds a filed for the semester
		semester = new JTextField();
		semester.setBounds(28, 248, 161, 20);
		studentsTab.add(semester);
		semester.setColumns(10);

        // create the label for the column semester
		JLabel semesterLabel = new JLabel("Semester");
		semesterLabel.setBounds(28, 234, 86, 14);
		studentsTab.add(semesterLabel);

		
		// adds a button to save a new or a changed student
		JButton studentBtnSave = new JButton("save");
		studentBtnSave.setBounds(54, 312, 89, 23);
		studentsTab.add(studentBtnSave);

		
		
		// adds a listener for pressing the button 'save'
		studentBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// in case the person ID is not yet filled the student is not
				// yet saved in the person database, therefore a new student needs
				// to be created
				if (studentPersonId.getText().isEmpty()) {

					try {

						// calls the method of the coordinating object to create a new student
						university.addStudent( studentFirstName.getText()
								             , studentLastName.getText()
								             , studentId.getText()
								             , Integer.parseInt(semester.getText()));

						// delete the text of all text fields and prepare them for the
						// next new student or a selection out of the list of students
						// it needs to be set inside the if because when the operation
						// fails the old values need be still visible - otherwise the
						// user needs to enter all again
						studentPersonId.setText(null);
						studentFirstName.setText(null);
						studentLastName.setText(null);
						studentId.setText(null);
						semester.setText(null);
					
					} // in case the input parameter are not filled correctly a message is shown
					  // to the user that the operation was not successfully
					  catch (NumberFormatException | WrongActualParameterException e) {
						
						JOptionPane.showMessageDialog(null,"one of the input parameter is not filled");
					}
				
				
				} // the person id is filled - the student already exists in the database instead of 
				  // creating a student, the existing student can be updated
				  else {

					// get the object of the student from the 'database' and update the
					// the properties of the student
					Student student;
					try {
						
						// get the student with the known person id
						student = university.getStudent(studentPersonId.getText());
						
						// set the properties
						student.setFirstName(studentFirstName.getText());
						student.setLastName(studentLastName.getText());
						student.setSemester(Integer.valueOf(semester.getText()));
						student.setStudentId(studentId.getText());

						// delete the text of all text fields and prepare them for the
						// next new student or a selection out of the list of students
						// it needs to be set inside the if because when the operation
						// fails the old values need be still visible - otherwise the
						// user needs to enter all again
						studentPersonId.setText(null);
						studentFirstName.setText(null);
						studentLastName.setText(null);
						studentId.setText(null);
						semester.setText(null);

					
					} // in case the student could not be found in the 'database', getStudent
					  // will raise an exception - this should be rarely happen because the
					  // interface also takes care of it
					  catch (StudentNotFoundException e) {

						// show an error message to the user
						JOptionPane.showMessageDialog(null,"Student could not be found");
						e.printStackTrace();
					}
				}

				// reload the table of students
				fillStudentsTable();
			}
		});
		
		
        // create a button to delete a student from the database
		// for this the student needs to be selected out of the
		// students tables
		JButton studentBtnDelete = new JButton("delete");
		studentBtnDelete.setBounds(54, 346, 89, 23);
		studentsTab.add(studentBtnDelete);

		
		// adding an action listener to the button, that is executed
		// when the button is pressed
		studentBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				
					// call the method from the coordinating class to
					// delete the student
					university.deleteStudent(studentPersonId.getText());
					
					// set all text fields to null to prepare this area for
					// the next operation
					studentPersonId.setText(null);
					studentFirstName.setText(null);
					studentLastName.setText(null);
					studentId.setText(null);
					semester.setText(null);
					
					// update the students table - the deleted student needs to be
					// excluded from the list
					fillStudentsTable();
				
				} // in case the student could not be found in the database an error 
				  // message is shown to the user
				  catch (StudentNotFoundException e) {

					JOptionPane.showMessageDialog(null,"Student could not be found");
					e.printStackTrace();
				}
			}
		});

		// create a button to prepare the form for creating a new
		// student
		JButton studentBtnCreate = new JButton("create");
		studentBtnCreate.setBounds(54, 380, 89, 23);
		studentsTab.add(studentBtnCreate);
		
		JLabel lblNewLabel = new JLabel("(Semester must be > 0)");
		lblNewLabel.setBounds(28, 269, 161, 14);
		studentsTab.add(lblNewLabel);


		// create an action listener in case the create button is
		// pressed - all text fields are deleted that the user can
		// enter the data of a new student - subsequent the user 
		// needs to press the save button
		studentBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// make all fields empty to prepare for a new student
				studentPersonId.setText(null);
				studentFirstName.setText(null);
				studentLastName.setText(null);
				studentId.setText(null);
				semester.setText(null);

			}
		});


		// create the table for showing all students
		studentsTable = new JTable();
		
		// create the model for showing all students
		studentsTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "First Name", "Last Name", "Student ID", "Semester" }) 
		                    {private static final long serialVersionUID = 1L;

		                     // set all columns of the table not editable, it's only allowed
		                     // to update a student when using the fields on the left side
			                 @Override
			                 public boolean isCellEditable(int row, int column) {
			                     // all cells false
			                 return false;
			                }
		});

		// add an event to the students tab, that every time when
		// the tab is shown will be executed
		studentsTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				// set the text field for the university name
				infoField.setText(university.getName());

				// update the students table with correct data
				fillStudentsTable();
				
				// add the scroll pane to the students table
				scrollPane.setViewportView(studentsTable);
			}
		});

		// add an event to the student table, the event is fired
		// when a mouse click appears on the table
		studentsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				// get the row of the table that received the mouse
				// click
				int row = studentsTable.getSelectedRow();
				
				// update the student details (left side of the form) with
				// the students details, it is executed with the persons id
				// which is the first column in the table
				updateStudentsDetail((String) studentsTable.getValueAt(row, 0));
			}
		});

	}

	/**
	 * updates the student details (text fields on the left of the
	 * students tab)
	 */
	private void updateStudentsDetail(String aId) {

		try {

			// get the actual student from the database
			Student student = university.getStudent(aId);
			
			// update the student fields with the properties
			// of the student
			studentPersonId.setText(student.getId());
			studentFirstName.setText(student.getFirstName());
			studentLastName.setText(student.getLastName());
			studentId.setText(student.getStudentId());
			semester.setText(String.valueOf(student.getSemester()));

		} // in case the student could not be found in the database an
		  // error message is shown to the user
		  catch (StudentNotFoundException e) {

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
		
		TeachingTab teachingTab = new TeachingTab();
		teachingTab.initializeTeachingTab(tabbedPane, university);
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
