import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
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
 * Page that user sees when they login
 * Contains tools for user to sign up for a course
 */
public class LoggedInPage extends JFrame {
    private ArrayList<Course> availableCourses;
    private JTable courseTable;
    private DefaultTableModel tableModel;
    private Account loggedInAccount;
    private ArrayList<Course> listOfCourses;
    private LoginMainScreen loginMainScreen;

    /**
     * LoggedInPage constructor
     * @param account
     * @param loginMainScreen
     * @param courses
     */
    public LoggedInPage(Account account, LoginMainScreen loginMainScreen, ArrayList<Course> courses) {
        super("Welcome");
        this.loggedInAccount = account;
        this.loginMainScreen = loginMainScreen;
        this.listOfCourses = courses;
        this.availableCourses = filterAvailableCourses(courses, account);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome, " + account.getName() + "!");

        String[] columnNames = {"Name", "Course Info", "Date", "Time", "Enrolled"};
        tableModel = GUITools.createTableModel(columnNames);

        GUITools.populateCourseTable(tableModel, availableCourses);

        courseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(courseTable);

        /**
    	 * Logic for signing up for a course
    	 */
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> {
            int selectedRow = courseTable.getSelectedRow();
            if (selectedRow != -1) {
                Course selectedCourse = availableCourses.get(selectedRow);
                /**
            	 * Adds the course object to the loggedInAccount ArrayList of courses
            	 * then refreshes the table so you don't see the same course again
            	 */
                try {
                    loggedInAccount.addCourse(selectedCourse);
                    JOptionPane.showMessageDialog(this, "You have signed up for the course: " + selectedCourse.getCourseName(), "Sign Up Successful", JOptionPane.INFORMATION_MESSAGE);
                    availableCourses = filterAvailableCourses(listOfCourses, loggedInAccount);
                    GUITools.populateCourseTable(tableModel, availableCourses);
                }
                catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
    	 * Logic to view page for enrolled courses
    	 */
        JButton viewEnrolledCoursesButton = new JButton("View Enrolled Courses");
        viewEnrolledCoursesButton.addActionListener(e -> {
            new EnrolledCoursesPage(loggedInAccount, this).setVisible(true);
            setVisible(false);
        });

        /**
    	 * Creates the dropdown menu in the top right that allows the user
    	 * to sort the courses by name/date/time/number of people enrolled
    	 */
        JComboBox<String> sortingComboBox = GUITools.createDropdownMenu(availableCourses, tableModel, availableCourses);

        /**
         * Logic for logout button
         */
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            dispose();
            loginMainScreen.setVisible(true);
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(welcomeLabel, BorderLayout.WEST);
        topPanel.add(sortingComboBox, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(signUpButton);
        bottomPanel.add(viewEnrolledCoursesButton);
        bottomPanel.add(logoutButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }

    /**
     * filters through all courses and compares with the account's courses
     * @param allCourses
     * @param account
     * @return ArrayList of courses that user is in
     */
    private ArrayList<Course> filterAvailableCourses(ArrayList<Course> allCourses, Account account) {
        ArrayList<Course> enrolledCourses = account.getCoursesEnrolledIn();
        return allCourses.stream()
                .filter(course -> !enrolledCourses.contains(course))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * refreshes the course window/table to update changes.
     */
    public void refreshCourses() {
        availableCourses = filterAvailableCourses(listOfCourses, loggedInAccount);
        GUITools.populateCourseTable(tableModel, availableCourses);
    }
}