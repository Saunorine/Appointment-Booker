import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CreateCoursePage extends JFrame {
    private JTextField nameField;
    private JTextField infoField;
    private JTextField dateField;
    private JTextField timeField;
    private ArrayList<Course> listOfCourses;
    private StaffLoggedInPage staffLoggedInPage;

    public CreateCoursePage(ArrayList<Course> listOfCourses, StaffLoggedInPage staffLoggedInPage) {
        super("Create Course");
        this.listOfCourses = listOfCourses;
        this.staffLoggedInPage = staffLoggedInPage;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Course Name:");
        nameField = new JTextField();
        JLabel infoLabel = new JLabel("Course Info:");
        infoField = new JTextField();
        JLabel dateLabel = new JLabel("Course Date (YYYY-MM-DD):");
        dateField = new JTextField();
        JLabel timeLabel = new JLabel("Course Time (HH:MM):");
        timeField = new JTextField();

        JButton createButton = new JButton("Create");
        createButton.addActionListener(e -> {
            try {
            	GUITools.validateCourseInput(nameField.getText(), infoField.getText(), dateField.getText(), timeField.getText());
                Course newCourse = new Course(nameField.getText(), infoField.getText(), LocalDate.parse(dateField.getText()), LocalTime.parse(timeField.getText()));
                listOfCourses.add(newCourse);
                staffLoggedInPage.refreshCourses();
                dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(e -> dispose());

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

        add(panel);
    }
}