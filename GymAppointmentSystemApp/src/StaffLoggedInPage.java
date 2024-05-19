import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

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
            new CreateCoursePage(listOfCourses, this).setVisible(true);
        });

        JButton deleteCourseButton = new JButton("Delete Course");
        deleteCourseButton.addActionListener(e -> {
            int selectedRow = courseTable.getSelectedRow();
            if (selectedRow != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this course?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Course selectedCourse = listOfCourses.get(selectedRow);
                    listOfCourses.remove(selectedCourse);
                    refreshCourses();
                    selectedCourse = null;  // Dereference the course object
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a course to delete.", "No Course Selected", JOptionPane.WARNING_MESSAGE);
            }
        });

        String[] sortingOptions = {"Sort by Name", "Sort by Date", "Sort by Time", "Sort by Enrolled"};
        JComboBox<String> sortingComboBox = new JComboBox<>(sortingOptions);
        sortingComboBox.addActionListener(e -> {
            String selectedOption = (String) sortingComboBox.getSelectedItem();
            if (selectedOption != null) {
                switch (selectedOption) {
                    case "Sort by Name":
                    	GUITools.sortCoursesByName(listOfCourses);
                        break;
                    case "Sort by Date":
                    	GUITools.sortCoursesByDate(listOfCourses);
                        break;
                    case "Sort by Time":
                    	GUITools.sortCoursesByTime(listOfCourses);
                        break;
                    case "Sort by Enrolled":
                    	GUITools.sortCoursesByEnrolled(listOfCourses);
                        break;
                }
                GUITools.populateCourseTable(tableModel, listOfCourses);
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createCourseButton);
        buttonPanel.add(deleteCourseButton);
        buttonPanel.add(logoutButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public void refreshCourses() {
    	GUITools.populateCourseTable(tableModel, listOfCourses);
    }
}