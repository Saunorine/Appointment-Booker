import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EnrolledCoursesPage extends JFrame {
    private Account loggedInAccount;
    private LoggedInPage loggedInPage;
    private DefaultTableModel tableModel;
    private ArrayList<Course> enrolledCourses;

    public EnrolledCoursesPage(Account account, LoggedInPage loggedInPage) {
        super("Enrolled Courses");
        this.loggedInAccount = account;
        this.loggedInPage = loggedInPage;
        this.enrolledCourses = new ArrayList<>(account.getCoursesEnrolledIn());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Create a DefaultTableModel to hold the enrolled courses data
        String[] columnNames = {"Name", "Course Info", "Date", "Time", "Enrolled"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Populate the table model with enrolled courses data
        populateTableModel();

        // Create the JTable with the table model
        JTable enrolledCoursesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(enrolledCoursesTable);

        JButton backButton = new JButton("Back to Course Selection");
        backButton.addActionListener(e -> {
            loggedInPage.setVisible(true);
            dispose();
        });

        // Create a JComboBox for sorting options
        String[] sortingOptions = {"Sort by Name", "Sort by Date", "Sort by Time", "Sort by Enrolled"};
        JComboBox<String> sortingComboBox = new JComboBox<>(sortingOptions);
        sortingComboBox.addActionListener(e -> {
            String selectedOption = (String) sortingComboBox.getSelectedItem();
            if (selectedOption != null) {
                switch (selectedOption) {
                    case "Sort by Name":
                        sortCoursesByName();
                        break;
                    case "Sort by Date":
                        sortCoursesByDate();
                        break;
                    case "Sort by Time":
                        sortCoursesByTime();
                        break;
                    case "Sort by Enrolled":
                        sortCoursesByEnrolled();
                        break;
                }
                populateTableModel();
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(sortingComboBox, BorderLayout.EAST);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void populateTableModel() {
        tableModel.setRowCount(0); // Clear existing rows
        for (Course course : enrolledCourses) {
            Object[] rowData = {
                    course.getCourseName(),
                    course.getCourseInfo(),
                    course.getCourseDate().toString(),
                    course.getCourseTime().toString(),
                    course.getNumberOfMembers() + "/" + course.getMaxOccupant()
            };
            tableModel.addRow(rowData);
        }
    }

    private void sortCoursesByName() {
        enrolledCourses.sort(Comparator.comparing(Course::getCourseName));
    }

    private void sortCoursesByDate() {
        enrolledCourses.sort(Comparator.comparing(Course::getCourseDate));
    }

    private void sortCoursesByTime() {
        enrolledCourses.sort(Comparator.comparing(Course::getCourseTime));
    }

    private void sortCoursesByEnrolled() {
        enrolledCourses.sort(Comparator.comparingInt(Course::getNumberOfMembers));
    }
}