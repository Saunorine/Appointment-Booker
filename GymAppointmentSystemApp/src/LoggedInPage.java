import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LoggedInPage extends JFrame {
    private ArrayList<Course> availableCourses;
    private JTable courseTable;
    private DefaultTableModel tableModel;
    private Account loggedInAccount;
    private ArrayList<Course> listOfCourses;
    private LoginMainScreen loginMainScreen;

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

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> {
            int selectedRow = courseTable.getSelectedRow();
            if (selectedRow != -1) {
                Course selectedCourse = availableCourses.get(selectedRow);
                try {
                    loggedInAccount.addCourse(selectedCourse);
                    JOptionPane.showMessageDialog(this, "You have signed up for the course: " + selectedCourse.getCourseName(), "Sign Up Successful", JOptionPane.INFORMATION_MESSAGE);
                    availableCourses = filterAvailableCourses(listOfCourses, loggedInAccount);
                    GUITools.populateCourseTable(tableModel, availableCourses);
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton viewEnrolledCoursesButton = new JButton("View Enrolled Courses");
        viewEnrolledCoursesButton.addActionListener(e -> {
            new EnrolledCoursesPage(loggedInAccount, this).setVisible(true);
            setVisible(false);
        });

        String[] sortingOptions = {"Sort by Name", "Sort by Date", "Sort by Time", "Sort by Enrolled"};
        JComboBox<String> sortingComboBox = new JComboBox<>(sortingOptions);
        sortingComboBox.addActionListener(e -> {
            String selectedOption = (String) sortingComboBox.getSelectedItem();
            if (selectedOption != null) {
                switch (selectedOption) {
                    case "Sort by Name":
                    	GUITools.sortCoursesByName(availableCourses);
                        break;
                    case "Sort by Date":
                    	GUITools.sortCoursesByDate(availableCourses);
                        break;
                    case "Sort by Time":
                    	GUITools.sortCoursesByTime(availableCourses);
                        break;
                    case "Sort by Enrolled":
                    	GUITools.sortCoursesByEnrolled(availableCourses);
                        break;
                }
                GUITools.populateCourseTable(tableModel, availableCourses);
            }
        });

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

    private ArrayList<Course> filterAvailableCourses(ArrayList<Course> allCourses, Account account) {
        ArrayList<Course> enrolledCourses = account.getCoursesEnrolledIn();
        return allCourses.stream()
                .filter(course -> !enrolledCourses.contains(course))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void refreshCourses() {
        availableCourses = filterAvailableCourses(listOfCourses, loggedInAccount);
        GUITools.populateCourseTable(tableModel, availableCourses);
    }
}