import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
 * Page that opens when the user wants to see what courses they are currently enrolled in
 * Contains only a table of courses that the logged in user is enrolled in
 */
public class EnrolledCoursesPage extends JFrame {
    private Account loggedInAccount;
    private LoggedInPage loggedInPage;
    private DefaultTableModel tableModel;
    private ArrayList<Course> enrolledCourses;

    /**
	 * EnrolledCoursesPage constructor
	 * @param account
	 * @param loggedInPage
	 */
    public EnrolledCoursesPage(Account account, LoggedInPage loggedInPage) {
        super("Enrolled Courses");
        this.loggedInAccount = account;
        this.loggedInPage = loggedInPage;
        this.enrolledCourses = new ArrayList<>(account.getCoursesEnrolledIn());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        /**
    	 * Creates Strings for the tableModel
    	 */
        String[] columnNames = {"Name", "Course Info", "Date", "Time", "Enrolled"};
        tableModel = new DefaultTableModel(columnNames, 0);

        /**
    	 * Method to add courses to tableModel
    	 */
        GUITools.populateCourseTable(tableModel, enrolledCourses);

        /**
    	 * The part that shows the course info in an excel fashion
    	 */
        JTable enrolledCoursesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(enrolledCoursesTable);

        /**
    	 * Logic for go back button
    	 */
        JButton backButton = new JButton("Back to Course Selection");
        backButton.addActionListener(e -> {
            loggedInPage.setVisible(true);
            dispose();
        });

        /**
    	 * Creates the dropdown menu in the top right that allows the user
    	 * to sort the courses by name/date/time/number of people enrolled
    	 * Uses sorting methods from GUITools
    	 */
        String[] sortingOptions = {"Sort by Name", "Sort by Date", "Sort by Time", "Sort by Enrolled"};
        JComboBox<String> sortingComboBox = new JComboBox<>(sortingOptions);
        sortingComboBox.addActionListener(e -> {
            String selectedOption = (String) sortingComboBox.getSelectedItem();
            if (selectedOption != null) {
                switch (selectedOption) {
                    case "Sort by Name":
                    	GUITools.sortCoursesByName(enrolledCourses);
                        break;
                    case "Sort by Date":
                    	GUITools.sortCoursesByDate(enrolledCourses);
                        break;
                    case "Sort by Time":
                    	GUITools.sortCoursesByTime(enrolledCourses);
                        break;
                    case "Sort by Enrolled":
                    	GUITools.sortCoursesByEnrolled(enrolledCourses);
                        break;
                }
                GUITools.populateCourseTable(tableModel, enrolledCourses);
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(sortingComboBox, BorderLayout.EAST);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
    }
}