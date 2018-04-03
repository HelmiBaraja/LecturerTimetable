package Main;

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
 * @author chan.yue
 */
public class UniversityGUIChan {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private University university;
	private JTextField nameOfUniversity;
	private JTextField infoField;
	private JTable teachersTable;
	private JTextField teacherPersonId;
	private JTextField teacherFirstName;
	private JTextField teacherLastName;
	private JTextField exmplyeeId;
	private JTextField function;

	// ***********************************************************************************
	// method to start the university app
	// ***********************************************************************************

	public static void startUniversity(University aUniversity) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				UniversityGUIChan window = new UniversityGUIChan();
				window.setUniversity(aUniversity);
				window.initialize();
				window.frame.setVisible(true);
			}
		});
	}

	// ***********************************************************************************
	// methods in relation to the teachers tab
	// ***********************************************************************************

	private void fillTeachersTable() {

		DefaultTableModel model = (DefaultTableModel) teachersTable.getModel();

		model.getDataVector().removeAllElements();

		List<Teacher> teachers = university.getTeacher();

		for (Teacher eachTeacher : teachers) {
			Object[] row = { eachTeacher.getId(), eachTeacher.getFirstName(), eachTeacher.getLastName(),
					eachTeacher.getExmplyeeId(), eachTeacher.getFunction() };

			model.addRow(row);

		}

	}

	private void initializeTeachersTab() {

		JPanel teachersTab = new JPanel();
		tabbedPane.addTab("Teachers", null, teachersTab, null);
		teachersTab.setLayout(null);

		infoField = new JTextField();
		infoField.setEditable(false);
		infoField.setBounds(28, 11, 161, 20);
		teachersTab.add(infoField);
		infoField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 521, 392);
		teachersTab.add(scrollPane);

		teacherPersonId = new JTextField();
		teacherPersonId.setEditable(false);
		teacherPersonId.setBounds(28, 66, 86, 20);
		teachersTab.add(teacherPersonId);
		teacherPersonId.setColumns(10);

		JLabel personIdLabel = new JLabel("Persond ID");
		personIdLabel.setBounds(30, 52, 66, 14);
		teachersTab.add(personIdLabel);

		teacherFirstName = new JTextField();
		teacherFirstName.setBounds(28, 122, 161, 20);
		teachersTab.add(teacherFirstName);
		teacherFirstName.setColumns(10);

		teacherLastName = new JTextField();
		teacherLastName.setBounds(28, 160, 161, 20);
		teachersTab.add(teacherLastName);
		teacherLastName.setColumns(10);

		exmplyeeId = new JTextField();
		exmplyeeId.setBounds(28, 203, 161, 20);
		teachersTab.add(exmplyeeId);
		exmplyeeId.setColumns(10);

		function = new JTextField();
		function.setBounds(28, 248, 161, 20);
		teachersTab.add(function);
		function.setColumns(10);

		JButton teacherBtnSave = new JButton("save");
		teacherBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (teacherPersonId.getText().isEmpty()) {

					university.addTeacher(teacherFirstName.getText(), teacherLastName.getText(), exmplyeeId.getText(),function.getText());
				} else {

					Teacher teacher = university.getTeacher(teacherPersonId.getText());
					teacher.setFirstName(teacherFirstName.getText());
					teacher.setLastName(teacherLastName.getText());
					teacher.setExmplyeeId(exmplyeeId.getText());
					teacher.setFunction(function.getText());
				}
                teacherPersonId.setText(null);
                teacherFirstName.setText(null);
                teacherLastName.setText(null);
                exmplyeeId.setText(null);
				function.setText(null);

				fillTeachersTable();
			}
		});
		teacherBtnSave.setBounds(54, 312, 89, 23);
		teachersTab.add(teacherBtnSave);

		JButton teacherBtnDelete = new JButton("delete");
		teacherBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				university.deleteTeacher(teacherPersonId.getText());
				teacherPersonId.setText(null);
				teacherFirstName.setText(null);
				teacherLastName.setText(null);
				exmplyeeId.setText(null);
				function.setText(null);
				fillTeachersTable();
			}
		});
		teacherBtnDelete.setBounds(54, 346, 89, 23);
		teachersTab.add(teacherBtnDelete);

		JButton teacherBtnCreate = new JButton("create");
		teacherBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				teacherPersonId.setText(null);
				teacherFirstName.setText(null);
				teacherLastName.setText(null);
				exmplyeeId.setText(null);
				function.setText(null);

			}
		});
		teacherBtnCreate.setBounds(54, 380, 89, 23);
		teachersTab.add(teacherBtnCreate);

		JLabel teacherFirstNameLabel = new JLabel("Firstname");
		teacherFirstNameLabel.setBounds(28, 108, 86, 14);
		teachersTab.add(teacherFirstNameLabel);

		JLabel teacherLastNameLabel = new JLabel("Lastname");
		teacherLastNameLabel.setBounds(28, 147, 86, 14);
		teachersTab.add(teacherLastNameLabel);

		JLabel exmplyeeIdLabel = new JLabel("Exmplyee-ID");
		exmplyeeIdLabel.setBounds(28, 191, 86, 14);
		teachersTab.add(exmplyeeIdLabel);

		JLabel functionLabel = new JLabel("Function");
		functionLabel.setBounds(28, 234, 86, 14);
		teachersTab.add(functionLabel);

		teachersTable = new JTable();
		teachersTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "First Name", "Last Name", "Exmplyee ID", "Function" }));

		teachersTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				infoField.setText(university.getName());
				fillTeachersTable();
				scrollPane.setViewportView(teachersTable);
			}
		});

		teachersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = teachersTable.getSelectedRow();
				updateTeachersDetail((String) teachersTable.getValueAt(row, 0));
			}
		});

	}

	private void updateTeachersDetail(String aId) {

		Teacher teacher = university.getTeacher(aId);

		teacherPersonId.setText(teacher.getId());
		teacherFirstName.setText(teacher.getFirstName());
		teacherLastName.setText(teacher.getLastName());
        exmplyeeId.setText(teacher.getExmplyeeId());
		function.setText(teacher.getFunction());
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

		initializeTeachersTab();
	}

	// ***********************************************************************************
	// common methods
	// ***********************************************************************************

	public UniversityGUIChan() {
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}

