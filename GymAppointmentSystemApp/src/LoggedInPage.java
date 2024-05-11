import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class LoggedInPage extends JFrame {
	private ArrayList<Course> availableCourses;
    private JList<Course> courseList;
    private DefaultListModel<Course> listModel;
	
    public LoggedInPage(String username, String password, LoginMainScreen loginMainScreen, ArrayList<Course> courses) {
    	super("Welcome");
        this.availableCourses = courses;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        
        // Create a DefaultListModel to hold the courses
        listModel = new DefaultListModel<>();
        for (Course course : availableCourses) {
            listModel.addElement(course);
        }
        
        // Create a JList to display the courses
        courseList = new JList<>(listModel);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(courseList);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> {
            Course selectedCourse = courseList.getSelectedValue();
            if (selectedCourse != null) {
                // Implement the sign-up logic here
                // You can call a method in Account or Course class to sign up for the selected course
            }
        });

        panel.add(welcomeLabel);
        panel.add(scrollPane);
        panel.add(signUpButton);

        add(panel);
    }
}