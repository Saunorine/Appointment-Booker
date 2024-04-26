
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
		
		courseName = "Beginner's Cardio 2";
		courseDescription = "Cardio class for starters";
		courseDate = "March 25, 2024";
		courseTime = "11:30";
		
		//Create course 2
		Courses testCourse2 = new Courses(courseName, courseDescription, courseDate, courseTime);
		
		testAccount1.addCourse(testCourse1);
		System.out.println(testAccount1.getNumberOfCourses());
		
		testAccount1.addCourse(testCourse2);
		System.out.println("Courses on Account: " + String.join(", ", testAccount1.getCourseList()));
		
		testAccount1.removeCourse(testCourse1);
		System.out.println("Courses on Account after remove: " + String.join(", ", testAccount1.getCourseList()));
	}
}
