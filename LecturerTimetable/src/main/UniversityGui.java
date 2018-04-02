package main;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UniversityGui {

    private JFrame frame;
    private JTabbedPane tabbedPane;
    private University university;
    private JTextField nameOfUniversity;
    private JTextField textField;

    public void setUniversity(University university) {
        this.university = university;
    }

    
    /**
     * Launch the application.
     * @wbp.parser.entryPoint
     */
    public static void startUniversity(University aUniversity){
    	
    	UniversityGui window = new UniversityGui();
    	window.setUniversity(aUniversity);
    	window.initialize();
    	window.frame.setVisible(true);
        window.setUniversity(aUniversity);
    }

    /**
     * Create the application.
     * @wbp.parser.entryPoint
     */
    public UniversityGui() {
    }

    private void setUniversityName(){
    	
    	nameOfUniversity.setText( university.getName() );
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
    	frame = new JFrame();
        frame.setBounds(100, 100, 792, 514);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 756, 453);
        frame.getContentPane().add(tabbedPane);
        
        JTabbedPane teacherTab = new JTabbedPane(JTabbedPane.TOP);

        initializeUniversityTab();
        initializePersonsTab();
    }
    
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
    
    private void initializePersonsTab() {

        JPanel personsTab = new JPanel();
        tabbedPane.addTab("New tab", null, personsTab, null);
        personsTab.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(157, 81, 86, 20);
        personsTab.add(textField);
        textField.setColumns(10);

        
    	
    }
}
