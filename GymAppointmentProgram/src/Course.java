import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
 * Contains stuff that makes up a Course with it's associated related methods
 */
public class Course {
    private String courseName;
    private String courseInfo;
    private LocalDate courseDate;
    private LocalTime courseTime;
    private int maxOccupant;
    private ArrayList<Account> listOfAccounts = new ArrayList<>();
    private int numOfMembers;

    /**
	 * Course constructor with name, info, date, and time
	 * @param courseName
	 * @param courseInfo
	 * @param courseDate
	 * @param courseTime
	 */
    public Course(String courseName, String courseInfo, LocalDate courseDate, LocalTime courseTime) {
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.courseDate = courseDate;
        this.courseTime = courseTime;
        this.maxOccupant = 5;
        this.numOfMembers = 0;
    }
    
    /**
	 * gets the name of the course object
	 * @return courseName
	 */
    public String getCourseName() {
        return courseName;
    }
    
    /**
	 * gets info of course object
	 * @return courseInfo
	 */
    public String getCourseInfo() {
        return courseInfo;
    }
    
    /**
	 * gets the course date
	 * @return courseDate
	 */
    public LocalDate getCourseDate() {
        return courseDate;
    }
    
    /**
	 * gets the course time
	 * @return coursesTime
	 */
    public LocalTime getCourseTime() {
        return courseTime;
    }
    
    /**
	 * gets the number of people enrolled in this course object
	 * @return numOfMembers
	 */
    public int getNumberOfMembers() {
        return numOfMembers;
    }
    
    /**
	 * gets the max amount of people allowed in this course object
	 * @return maxOccupant
	 */
    public int getMaxOccupant() {
        return maxOccupant;
    }
    
    /**
	 * adds given account to this course object's ArrayList listOfAccounts
	 * @param account object
	 */
    public void addMember(Account account) {
        if (!listOfAccounts.contains(account) && numOfMembers < maxOccupant) {
            listOfAccounts.add(account);
            numOfMembers = listOfAccounts.size();
        } else {
            throw new IllegalStateException("Course is full or member already enrolled.");
        }
    }
    
    /**
	 * removes given account from this course object's ArrayList listOfAccounts
	 * @param account object
	 */
    public void removeMember(Account account) {
        if (listOfAccounts.contains(account)) {
            listOfAccounts.remove(account);
            numOfMembers = listOfAccounts.size();
        }
    }
    
    /**
	 * I'm pretty sure this is only used for junit tests
	 * @return String of info
	 */
    @Override
    public String toString() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        return "Course Name: " + courseName + "\nDescription: " + courseInfo + "\nDate: " + courseDate + "\nTime: " + timeFormatter.format(courseTime) + "\nEnrolled: " + numOfMembers + "/" + maxOccupant;
    }
    
    /**
	 * gets the ArrayList of accounts attached to this course object
	 * @return listOfAccounts
	 */
    public ArrayList<Account> getListOfAccounts() {
        return listOfAccounts;
    }
    
    /**
	 * I'm pretty sure this is only used for junit tests
	 * @return String of info
	 */
	public String getInformation() {
		return "Name: " + courseName + ". Description: " + courseInfo + ". Date: " + courseDate.toString() + ". Time: " + courseTime.toString();
	}
}