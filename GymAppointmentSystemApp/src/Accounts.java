import java.util.ArrayList;

public class Accounts
{
	private String name;
	private String password;
	private String contactInfo;
	private int numOfCourses;
	
	private ArrayList<Courses> coursesEnrolledIn = new ArrayList<Courses>();
	
	public Accounts(String userName, String userPass, String info) {
		this.name = userName;
		this.password = userPass;
		this.contactInfo = info;
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
	
	public void addCourse(Courses objectName) {
		coursesEnrolledIn.add(objectName);
	}
	
	public void removeCourse(Courses objectName) {
		coursesEnrolledIn.remove(objectName);
	}
	
	public String getInformation() {
		String listOfInfo = "Name: " + name + ". Password: " + password + ". Other info: " + contactInfo;
		
		return listOfInfo;
	}
}
