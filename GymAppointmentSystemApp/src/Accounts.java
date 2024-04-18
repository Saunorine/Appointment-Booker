import java.util.ArrayList;

public class Accounts
{
	private String name;
	private String password;
	private String contactInfo;
	private ArrayList<String> coursesEnrolledIn = new ArrayList<String>();
	private int numOfCourses = coursesEnrolledIn.size();
	
	//Default values
	public Accounts() {
		name = "Fill name";
		password = "Set password";
		contactInfo = "Needs contact info";
	}
	
	public void setName(String userName) {
		this.name = userName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassword(String userPass) {
		this.password = userPass;
	}
	
	public void setContact(String info) {
		this.contactInfo = info;
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
}
