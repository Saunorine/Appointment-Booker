import java.util.ArrayList;

public class Accounts
{
	public String name;
	public String password;
	public String contactInfo;
	public ArrayList<Courses> coursesEnrolledIn = new ArrayList<Courses>();
	public int numOfCourses = coursesEnrolledIn.size();
	
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
	
	public void addCourse(Courses objectName) {
		coursesEnrolledIn.add(objectName);
	}
	
	public String getCourseList() {
		return coursesEnrolledIn.toString();
	}
	
	public String getInformation() {
		String listOfInfo = "Name: " + name + ". Password: " + password + ". Other info: " + contactInfo;
		
		return listOfInfo;
	}
}
