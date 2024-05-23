import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Lead Author(s):Zhanhang Xiao
 * Fermin Garduno
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley. 
 * 
 * <<add more references here>>
 *  
 * Version/date: May 23, 2024
 * 
 * Responsibilities of class:
 * Page that pops up when a staff wants to make a new course
 * Contains stuff to make a new course for users to enroll in
 * Subclass of CreateScreen
 */
public class CreateCoursePage extends CreateScreen {

    public CreateCoursePage(JFrame parentFrame, ArrayList<Course> listOfCourses) {
        super("Create Course", parentFrame, listOfCourses);
    }

    /**
	 * adds the visual content to the window
	 * @param panel
	 */
    @Override
    protected void addComponentsToPanel(JPanel panel) {
        panel.setLayout(new GridLayout(6, 2));

        nameField = new JTextField();
        infoField = new JTextField();
        dateField = new JTextField();
        timeField = new JTextField();

        JLabel nameLabel = new JLabel("Course Name:");
        JLabel infoLabel = new JLabel("Course Info:");
        JLabel dateLabel = new JLabel("Course Date (YYYY-MM-DD):");
        JLabel timeLabel = new JLabel("Course Time (HH:MM):");

        JButton createButton = new JButton("Create");
        JButton goBackButton = new JButton("Go Back");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(infoLabel);
        panel.add(infoField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(createButton);
        panel.add(goBackButton);

        /**
    	 * Logic for create button on the course page
    	 */
        createButton.addActionListener(e -> {
        	/**
        	 * runs info through a method located in GUITools that tests if the info is legible
        	 * then creates the course given input info and adds it to master list of courses
        	 * refresh the screen showing courses and then closes window
        	 */
            try {
                GUITools.validateCourseInput(nameField.getText(), infoField.getText(), dateField.getText(), timeField.getText());
                Course newCourse = new Course(nameField.getText(), infoField.getText(), LocalDate.parse(dateField.getText()), LocalTime.parse(timeField.getText()));
                ((ArrayList<Course>) listOfItems).add(newCourse);
                ((StaffLoggedInPage) parentFrame).refreshCourses();
                dispose();
            }
            /**
        	 * If error, return this message in a smaller window
        	 */
            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
    	 * Go back button just closes the popup for course creation
    	 */
        goBackButton.addActionListener(e -> dispose());
    }

    /**
	 * Action listeners are added in addComponentsToPanel
	 */
    @Override
    protected void addActionListeners() {
    }
}