import java.util.ArrayList;

public class staffAccount extends Accounts{
	private ArrayList<String> coursesInCharge = new ArrayList<String>();
	private int currentClasses = coursesInCharge.size();
	
	public void addCourse(String courseID) {
		coursesInCharge.add(courseID);
	}
	
	public ArrayList listOfCourses() {
		return coursesInCharge;
	}
	
	
}
