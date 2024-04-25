import java.util.ArrayList;

public class Accounts
{
	private String name;
	private String password;
	private String contactInfo;
	private ArrayList<Courses> coursesEnrolledIn = new ArrayList<Courses>();
	private int numOfCourses = coursesEnrolledIn.size();
	
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
		return numOfCourses;
	}
	
	public void addCourse(Courses courseID) {
		coursesEnrolledIn.add(courseID);
	}
	
	public ArrayList<Courses> getCourseList() {
		return coursesEnrolledIn;
	}
	
	public String getInformation() {
		String listOfInfo = "Name: " + name + ". Password: " + password + ". Other info: " + contactInfo;
		
		return listOfInfo;
	}
}
