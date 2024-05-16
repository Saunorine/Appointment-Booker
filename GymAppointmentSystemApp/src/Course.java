import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Course
{
	private String courseName;
	private String courseInfo;
	private LocalDate courseDate;
	private LocalTime courseTime;
	private int maxOccupant;
	
	//Leave this in to use later
	private String courseInstructor;
	
	//Not used not sure if even needed
	private ArrayList<Account> listOfAccounts = new ArrayList<Account>();
	private int numOfMembers;
	
	//constructor
	public Course (String courseName, String courseInfo, LocalDate courseDate, LocalTime courseTime)
	{
		this.courseName = courseName;
		this.courseInfo = courseInfo;
		this.courseDate = courseDate;
		this.courseTime = courseTime;
		this.maxOccupant = 8;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public String getCourseInfo()
	{
		return courseInfo;
	}
	
	public LocalDate getCourseDate()
	{
		return courseDate;
	}
	
	public LocalTime getCourseTime()
	{
		return courseTime;
	}
	
	public int getNumberOfMembers() {
		//Minus 1 because there will always be a staff in it
		numOfMembers = listOfAccounts.size() - 1;
		
		return numOfMembers;
	}
	
	public String getInformation() {
		String listOfInfo = "Name: " + this.getCourseName() + ". Description: " + this.getCourseInfo() + ". Date: " + this.getCourseDate() + ". Time: " + this.getCourseTime();
		
		return listOfInfo;
	}
	
	//commented out for now, need to override toString in order to print to Console over in the Sorter Class
//	@Override
//    public String toString() {
//        return courseName;
//    }
	
	@Override
    public String toString() {
		//formats the time so that when we print it, it will read as hour,minute, AM/PM
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        return "Course Name: " + courseName + "\nDescription: " + courseInfo + "\nDate: " + courseDate + "nTime: " + timeFormatter.format(courseTime);
    }
}
