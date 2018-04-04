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

import main.ClassRoomModel.Size;
import misc.Util;

public class ClassRoomTab {
	JTable classRoomTable;
	University university;
	JTextField classRoomIDField;
	JTextField classRoomNoField;
	JComboBox<String> classSizeCombo;
	
	public void initializeClassTab(JTabbedPane tabbedPane, University university)
	{
		this.university=university;
		
		JPanel classRoomTab = new JPanel();
		tabbedPane.addTab("Class Rooms", null, classRoomTab, null);
		classRoomTab.setLayout(null);
		
		JTextField infoField = new JTextField();
		infoField.setEditable(false);
		infoField.setBounds(28, 11, 161, 20);
		classRoomTab.add(infoField);
		infoField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 11, 521, 392);
		classRoomTab.add(scrollPane);
		
		JLabel classRoomIDLabel = new JLabel("Room ID");
		classRoomIDLabel.setBounds(30, 52, 66, 14);
		classRoomTab.add(classRoomIDLabel);
		
		classRoomIDField = new JTextField();
		classRoomIDField.setBounds(28, 66, 86, 20);
		classRoomIDField.setColumns(10);
		classRoomIDField.setEditable(false);
		classRoomTab.add(classRoomIDField);
		
		JLabel classRoomNoLabel = new JLabel("Room No");
		classRoomNoLabel.setBounds(28, 108, 86, 14);
		classRoomTab.add(classRoomNoLabel);
		
		classRoomNoField = new JTextField();
		classRoomNoField.setBounds(28, 122, 161, 20);
		classRoomNoField.setColumns(10);
		classRoomTab.add(classRoomNoField);
		
		JLabel classRoomSizeLabel = new JLabel("Size");
		classRoomSizeLabel.setBounds(28, 147, 86, 14);
		classRoomTab.add(classRoomSizeLabel);
		
		classSizeCombo = new JComboBox<String>(Size.sizes);
		classSizeCombo.setBounds(28, 160, 161, 20);
		classRoomTab.add(classSizeCombo);

		
		JButton courseBtnSave = new JButton("save");
		courseBtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!classRoomIDField.getText().isEmpty()) {
					ClassRoomModel classModel = university.getClassRoom().getClassList().get(Integer.parseInt(classRoomIDField.getText().toString()));
					classModel.setRoomNo(classRoomNoField.getText().toString());
					classModel.setSize(classSizeCombo.getSelectedIndex());

										
				}
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnSave.setBounds(54, 312, 89, 23);
		classRoomTab.add(courseBtnSave);

		JButton courseBtnDelete = new JButton("delete");
		courseBtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				university.getClassRoom().deleteClassRoomByID(Integer.parseInt(classRoomIDField.getText().toString()));

				
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnDelete.setBounds(54, 346, 89, 23);
		classRoomTab.add(courseBtnDelete);

		JButton courseBtnCreate = new JButton("create");
		courseBtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClassRoomModel classModel = new ClassRoomModel(classRoomIDField.getText().toString(), 
						classSizeCombo.getSelectedIndex());
				
				university.getClassRoom().addClassRoom(classModel);
				
				clearFields();
				fillCourseTable();
			}
		});
		courseBtnCreate.setBounds(54, 380, 89, 23);
		classRoomTab.add(courseBtnCreate);
		
		
		classRoomTable = new JTable();
		classRoomTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Room No", "Size" }));
				
		classRoomTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = classRoomTable.getSelectedRow();
				updateCourseDetail( (int) classRoomTable.getValueAt(row, 0) -1);
			}
		});
		
		classRoomTab.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fillCourseTable();
				infoField.setText(university.getName());
				scrollPane.setViewportView(classRoomTable);

			}
		});
	}
	
	private void updateCourseDetail(int aId) {
		ClassRoomModel classModel = university.getClassRoom().getClassList().get(aId);

		updateCourseDetail(classModel);
	}
	
	private void updateCourseDetail(ClassRoomModel classModel)
	{
		classRoomIDField.setText(classModel.getId()+"");
		classRoomNoField.setText(classModel.getRoomNo());
		classSizeCombo.setSelectedIndex(classModel.getSizeIndex());	
	}
	
	private void fillCourseTable() {

		DefaultTableModel model = (DefaultTableModel) classRoomTable.getModel();

		model.getDataVector().removeAllElements();

		List<ClassRoomModel> classRoom = university.getClassRoom().getClassList();
		System.out.println(classRoom.size()+"");
		for (ClassRoomModel eachClassRoom : classRoom) {
			Object[] row = { eachClassRoom.getId(), eachClassRoom.getRoomNo(), eachClassRoom.getSizeString() };

			model.addRow(row);

		}

	}
	
	private void clearFields() {
		classRoomNoField.setText("");
		classRoomIDField.setText("");
		
	}
}
