import java.util.ArrayList;

public class Courses
{
	public String courseName;
	public String courseInfo;
	public String courseDate;
	public String courseTime;
	
	//Not used not sure if even needed
	private ArrayList<Courses> listOfAccounts = new ArrayList<Courses>();
	
	//constructor
	public Courses (String courseName, String courseInfo, String courseDate, String courseTime)
	{
		this.courseName = courseName;
		this.courseInfo = courseInfo;
		this.courseDate = courseDate;
		this.courseTime = courseTime;
		
	}
	
	public String getName()
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
	
	public String getInformation() {
		String listOfInfo = "Name: " + this.getName() + ". Description: " + this.getCourseInfo() + ". Date: " + this.getCourseDate() + ". Time: " + this.getCourseTime();
		
		return listOfInfo;
	}
}
