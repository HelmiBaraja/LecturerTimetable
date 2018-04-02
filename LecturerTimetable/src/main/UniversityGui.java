package main;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;

public class UniversityGui {

    private JFrame frame;
    private University university;

    public void setUniversity(University university) {
        this.university = university;
    }



    /**
     * Launch the application.
     */
    public static void startUniversity(University aUniversity){

        
               
                    UniversityGui window = new UniversityGui();
                    window.frame.setVisible(true);
       window.setUniversity(aUniversity);
    }

    
    
    /**
     * Create the application.
     */
    public UniversityGui() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 514);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(38, 40, 532, 344);
        frame.getContentPane().add(tabbedPane);
        
        JPanel Persons = new JPanel();
        tabbedPane.addTab("Persons", null, Persons, null);
        
        JList list = new JList();
        list.setBackground(Color.WHITE);
        list.setVisibleRowCount(20);
        Persons.add(list);
        DefaultListModel dlm = new DefaultListModel();
        
        
        
        
        dlm.addElement("Ansgar");
        dlm.addElement("Casper");
        list.setModel(dlm);
    }
}
