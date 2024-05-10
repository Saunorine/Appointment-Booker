import java.util.ArrayList;

public class Course
{
	private String courseName;
	private String courseInfo;
	private String courseDate;
	private String courseTime;
	private int maxOccupant;
	
	//Leave this in to use later
	private String courseInstructor;
	
	//Not used not sure if even needed
	private ArrayList<Account> listOfAccounts = new ArrayList<Account>();
	private int numOfMembers;
	
	//constructor
	public Course (String courseName, String courseInfo, String courseDate, String courseTime)
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
	
	public String getCourseDate()
	{
		return courseDate;
	}
	
	public String getCourseTime()
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
}
