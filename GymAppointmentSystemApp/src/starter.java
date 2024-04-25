
public class starter
{

	public static void main(String[] args)
	{
		//Create account
		String accName = "Fermin";
		String accPassword = "mesa123";
		String accContactInfo = "fermin@gmail.com";
		Accounts testAccount1 = new Accounts(accName, accPassword, accContactInfo);
		
		//Create course
		String courseName = "Beginner's Cardio";
		String courseDescription = "Cardio class for starters";
		String courseDate = "March 22, 2024";
		String courseTime = "15:30";
		Courses testCourse1 = new Courses(courseName, courseDescription, courseDate, courseTime);
		
		testAccount1.addCourse(testCourse1);
		
		System.out.println(testAccount1.getNumberOfCourses());
		System.out.println(testAccount1.getCourseList());
	}
}
