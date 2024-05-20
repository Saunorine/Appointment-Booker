import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.table.DefaultTableModel;


public class GUITools
{
	//Sorters for GUI
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
    
    //Table maker for GUI
    public static DefaultTableModel createTableModel(String[] columnNames) {
        return new DefaultTableModel(columnNames, 0);
    }
    
    //Adds course info to table
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
    
    //Exception handling for text fields need to make more
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
}
