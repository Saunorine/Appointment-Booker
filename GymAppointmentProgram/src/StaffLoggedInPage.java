import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
/**
 * Lead Author(s):Zhanhang Xiao
 * Fermin Garduno
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
 * Page that staff sees when they login
 * Contains stuff to create and delete courses
 */
public class StaffLoggedInPage extends JFrame {
    private ArrayList<Course> listOfCourses;
    private JTable courseTable;
    private DefaultTableModel tableModel;
    private Account loggedInAccount;
    private LoginMainScreen loginMainScreen;

    public StaffLoggedInPage(Account account, ArrayList<Course> courses, LoginMainScreen loginMainScreen) {
        super("Staff Dashboard");
        this.loggedInAccount = account;
        this.listOfCourses = courses;
        this.loginMainScreen = loginMainScreen;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome, " + account.getName() + "!");

        String[] columnNames = {"Name", "Course Info", "Date", "Time", "Enrolled"};
        tableModel = GUITools.createTableModel(columnNames);

        GUITools.populateCourseTable(tableModel, listOfCourses);

        courseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(courseTable);

        JButton createCourseButton = new JButton("Create Course");
        createCourseButton.addActionListener(e -> {
            new CreateCoursePage(this, listOfCourses).setVisible(true);
        });

        JButton deleteCourseButton = new JButton("Delete Course");
        deleteCourseButton.addActionListener(e -> {
            int selectedRow = courseTable.getSelectedRow();
            if (selectedRow != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this course?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Course selectedCourse = listOfCourses.get(selectedRow);
                    // Make a copy of the list to avoid concurrent modification issues
                    ArrayList<Account> enrolledAccounts = new ArrayList<>(selectedCourse.getListOfAccounts());
                    for (Account enrolledAccount : enrolledAccounts) {
                        enrolledAccount.removeCourse(selectedCourse);
                    }
                    listOfCourses.remove(selectedCourse);
                    refreshCourses();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a course to delete.", "No Course Selected", JOptionPane.WARNING_MESSAGE);
            }
        });

        /**
    	 * Creates the dropdown menu in the top right that allows the user
    	 * to sort the courses by name/date/time/number of people enrolled
    	 */
        JComboBox<String> sortingComboBox = GUITools.createDropdownMenu(listOfCourses, tableModel, listOfCourses);

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

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createCourseButton);
        buttonPanel.add(deleteCourseButton);
        buttonPanel.add(logoutButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    /**
	 * refreshes the table of courses when called
	 */
    public void refreshCourses() {
    	GUITools.populateCourseTable(tableModel, listOfCourses);
    }
}