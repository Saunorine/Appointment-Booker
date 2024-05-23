import java.util.ArrayList;
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
 * Contains stuff that makes up an Account with it's associated related methods
 */
public class Account {
    private String name;
    private String password;
    private int numOfCourses;
    private boolean isStaff;

    private ArrayList<Course> coursesEnrolledIn = new ArrayList<>();
    
    /**
	 * Account constructor if no given boolean for staff
	 * defaults to false
	 */
    public Account(String userName, String userPass) {
        this.name = userName;
        this.password = userPass;
        this.isStaff = false;
    }
    
    /**
	 * Account constructor if staff
	 */
    public Account(String userName, String userPass, boolean isStaff) {
        this.name = userName;
        this.password = userPass;
        this.isStaff = isStaff;
    }

    /**
	 * gets name of account
	 * @return name
	 */
    public String getName() {
        return name;
    }

    /**
	 * gets password of account
	 * @return password
	 */
    public String getPassword() {
        return password;
    }

    /**
	 * gets number of courses enrolled in
	 * @return numOfCourses
	 */
    public int getNumberOfCourses() {
        numOfCourses = coursesEnrolledIn.size();
        return numOfCourses;
    }

    /**
	 * gets list of courses in a string
	 * I think this was only for a junit test and does nothing in the program
	 */
    public String getCourseList() {
        return coursesEnrolledIn.toString();
    }

    /**
	 * adds course object to ArrayList coursesEnrolledIn
	 * @param course object
	 */
    public void addCourse(Course course) {
        if (!coursesEnrolledIn.contains(course)) {
            coursesEnrolledIn.add(course);
            course.addMember(this);
        }
    }

    /**
	 * removes object  from ArrayList coursesEnrolledIn
	 * @param course object
	 */
    public void removeCourse(Course course) {
        if (coursesEnrolledIn.contains(course)) {
            coursesEnrolledIn.remove(course);
            course.removeMember(this);
        }
    }

    /**
	 * returns string of information
	 * @return String with name and password
	 */
    public String getInformation() {
        return "Name: " + name + ". Password: " + password;
    }

    /**
	 * checks if account is a staff account
	 * @return isStaff
	 */
    public boolean isStaff() {
        return isStaff;
    }

    /**
	 * gets the ArrayList of course objects that is attached to this account object
	 * @return coursesEnrolledIn ArrayList<Course>
	 */
    public ArrayList<Course> getCoursesEnrolledIn() {
        return coursesEnrolledIn;
    }
}