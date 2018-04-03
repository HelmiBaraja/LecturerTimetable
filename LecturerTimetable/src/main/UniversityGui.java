package main;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
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

/**
 * @author ansgar.goeb
 */
public class UniversityGui {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private University university;
	private JTextField nameOfUniversity;
	private JTextField infoField;
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
	 * @wbp.parser.entryPoint
	 */
	public static void startUniversity(University aUniversity) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				UniversityGui window = new UniversityGui();
				window.setUniversity(aUniversity);
				window.initialize();
				window.frame.setVisible(true);
			}
		});
	}

	// ***********************************************************************************
	// methods in relation to the university tab
	// ***********************************************************************************

	private void initializeUniversityTab() {
		JPanel universityTab = new JPanel();
		tabbedPane.addTab("University", null, universityTab, null);
		universityTab.setLayout(null);

		nameOfUniversity = new JTextField();
		nameOfUniversity.setBounds(58, 121, 321, 29);
		universityTab.add(nameOfUniversity);
		nameOfUniversity.setColumns(10);

		JLabel lblNameOfThe = new JLabel("Name of the University");
		lblNameOfThe.setBounds(58, 95, 133, 20);
		universityTab.add(lblNameOfThe);

		JButton updateUniversity = new JButton("Update");

		updateUniversity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				university.setName(nameOfUniversity.getText());
			}
		});

		updateUniversity.setBounds(58, 176, 89, 23);
		universityTab.add(updateUniversity);

		setUniversityName();

		universityTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				setUniversityName();
			}
		});
	}

	// ***********************************************************************************
	// methods in relation to the students tab
	// ***********************************************************************************

	private void fillStudentsTable() {

		DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();

		model.getDataVector().removeAllElements();

		List<Student> students = university.getStudents();

		for (Student eachStudent : students) {
			Object[] row = { eachStudent.getId(), eachStudent.getFirstName(), eachStudent.getLastName(),
					eachStudent.getStudentId(), eachStudent.getSemester() };

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

					university.addStudent(studentFirstName.getText(), studentLastName.getText(), studentId.getText(),
							Integer.parseInt(semester.getText()));
				} else {

					Student student = university.getStudent(studentPersonId.getText());
					student.setFirstName(studentFirstName.getText());
					student.setLastName(studentLastName.getText());
					student.setSemester(Integer.valueOf(semester.getText()));
					student.setStudentId(studentId.getText());
				}

				studentPersonId.setText(null);
				studentFirstName.setText(null);
				studentLastName.setText(null);
				studentId.setText(null);
				semester.setText(null);

				fillStudentsTable();
			}
		});
		studentBtnSave.setBounds(54, 312, 89, 23);
		studentsTab.add(studentBtnSave);

		JButton studentBtnDelete = new JButton("delete");
		studentBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				university.deleteStudent(studentPersonId.getText());
				studentPersonId.setText(null);
				studentFirstName.setText(null);
				studentLastName.setText(null);
				studentId.setText(null);
				semester.setText(null);
				fillStudentsTable();
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

		Student student = university.getStudent(aId);

		studentPersonId.setText(student.getId());
		studentFirstName.setText(student.getFirstName());
		studentLastName.setText(student.getLastName());
		studentId.setText(student.getStudentId());
		semester.setText(String.valueOf(student.getSemester()));
	}

	// ***********************************************************************************
	// method to initialize the different components of the university app
	// ***********************************************************************************
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 792, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 756, 453);
		frame.getContentPane().add(tabbedPane);

		initializeUniversityTab();
		initializeStudentsTab();
	}

	// ***********************************************************************************
	// common methods
	// ***********************************************************************************

	public UniversityGui() {
	}

	private void setUniversityName() {

		nameOfUniversity.setText(university.getName());
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}
