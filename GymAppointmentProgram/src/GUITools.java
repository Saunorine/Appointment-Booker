import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
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
 * Contains a bunch of useful methods that are constantly repeated throughout the program
 */
public class GUITools
{
	/**
	 * All of these sorts the course by name/date/time and number of people enrolled
	 */
	public static void sortCoursesByName(ArrayList<Course> courses) {
        courses.sort(Comparator.comparing(Course::getCourseName));
    }

    public static void sortCoursesByDate(ArrayList<Course> courses) {
        courses.sort(Comparator.comparing(Course::getCourseDate));
    }

    public static void sortCoursesByTime(ArrayList<Course> courses) {
        courses.sort(Comparator.comparing(Course::getCourseTime));
    }

    public static void sortCoursesByEnrolled(ArrayList<Course> courses) {
        courses.sort(Comparator.comparingInt(Course::getNumberOfMembers));
    }
    
    /**
	 * Creates a table
	 * columnName are the ones on the top like name/date
	 * @param columnName
	 */
    public static DefaultTableModel createTableModel(String[] columnNames) {
        return new DefaultTableModel(columnNames, 0);
    }
    
    /**
	 * Adds courses to a table
	 * Used in EnrolledCoursesPage, LoggedInPage, and StaffLoggedInPage
	 * @param tableModel
	 * @param courses ArrayList of course objects
	 */
    public static void populateCourseTable(DefaultTableModel tableModel, ArrayList<Course> courses) {
        tableModel.setRowCount(0); // Clear existing rows
        for (Course course : courses) {
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
    
    /**
	 * Exception methods
	 */
    public static void validateCourseInput(String name, String info, String dateText, String timeText) throws IllegalArgumentException {
        if (name.isEmpty() || info.isEmpty() || dateText.isEmpty() || timeText.isEmpty()) {
            throw new IllegalArgumentException("All fields must be filled.");
        }

        try {
            LocalDate.parse(dateText);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD.");
        }

        try {
            LocalTime.parse(timeText);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Use HH:MM.");
        }
    }
    
    /**
	 * Checks username and password for illegal characters
	 */
    public static void validateUserInput(String username, String password) throws IllegalArgumentException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty.");
        }

        if (!username.matches("[a-zA-Z0-9]+") || !password.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Username and password can only contain letters and numbers.");
        }
    }
}
