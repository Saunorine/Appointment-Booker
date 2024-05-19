import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseInfo;
    private LocalDate courseDate;
    private LocalTime courseTime;
    private int maxOccupant;
    private ArrayList<Account> listOfAccounts = new ArrayList<>();
    private int numOfMembers;

    public Course(String courseName, String courseInfo, LocalDate courseDate, LocalTime courseTime) {
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.courseDate = courseDate;
        this.courseTime = courseTime;
        this.maxOccupant = 5;
        this.numOfMembers = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public LocalDate getCourseDate() {
        return courseDate;
    }

    public LocalTime getCourseTime() {
        return courseTime;
    }

    public int getNumberOfMembers() {
        return numOfMembers;
    }

    public int getMaxOccupant() {
        return maxOccupant;
    }

    public void addMember(Account account) {
        if (numOfMembers < maxOccupant) {
            listOfAccounts.add(account);
            numOfMembers = listOfAccounts.size();
        } else {
            throw new IllegalStateException("Course is full.");
        }
    }

    public void removeMember(Account account) {
        listOfAccounts.remove(account);
        numOfMembers = listOfAccounts.size();
    }

    public String getInformation() {
        return "Name: " + courseName + ". Description: " + courseInfo + ". Date: " + courseDate + ". Time: " + courseTime + ". Enrolled: " + numOfMembers + "/" + maxOccupant;
    }

    @Override
    public String toString() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        return "Course Name: " + courseName + "\nDescription: " + courseInfo + "\nDate: " + courseDate + "\nTime: " + timeFormatter.format(courseTime) + "\nEnrolled: " + numOfMembers + "/" + maxOccupant;
    }
}