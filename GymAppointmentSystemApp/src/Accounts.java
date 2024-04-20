import java.util.ArrayList;

public class Accounts
{
	private String name;
	private String password;
	private String contactInfo;
	private ArrayList<String> coursesEnrolledIn = new ArrayList<String>();
	private int numOfCourses = coursesEnrolledIn.size();
	
	public Accounts(String userName, String userPass, String info) {
		this.name = userName;
		this.password = userPass;
		this.contactInfo = info;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContact() {
		return contactInfo;
	}
	
	public void addCourse(String courseID) {
		coursesEnrolledIn.add(courseID);
	}
	
	public ArrayList<String> getCourses() {
		return coursesEnrolledIn;
	}
	
	public String getInformation() {
		String listOfInfo = "Name: " + name + ". Password: " + password + ". Other info: " + contactInfo;
		
		return listOfInfo;
	}
}
