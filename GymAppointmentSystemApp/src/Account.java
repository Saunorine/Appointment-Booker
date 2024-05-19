import java.util.ArrayList;

public class Account {
    private String name;
    private String password;
    private String contactInfo;
    private int numOfCourses;
    private boolean isStaff;

    private ArrayList<Course> coursesEnrolledIn = new ArrayList<>();

    public Account(String userName, String userPass) {
        this.name = userName;
        this.password = userPass;
        this.isStaff = false; // Default to false
    }

    public Account(String userName, String userPass, boolean isStaff) {
        this.name = userName;
        this.password = userPass;
        this.isStaff = isStaff; // Allow setting the staff flag
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contactInfo;
    }

    public int getNumberOfCourses() {
        numOfCourses = coursesEnrolledIn.size();
        return numOfCourses;
    }

    public String getCourseList() {
        return coursesEnrolledIn.toString();
    }

    public void addCourse(Course course) {
        coursesEnrolledIn.add(course);
        course.addMember(this);
    }

    public void removeCourse(Course course) {
        coursesEnrolledIn.remove(course);
        course.removeMember(this);
    }

    public String getInformation() {
        return "Name: " + name + ". Password: " + password + ". Other info: " + contactInfo;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public ArrayList<Course> getCoursesEnrolledIn() {
        return coursesEnrolledIn;
    }
}