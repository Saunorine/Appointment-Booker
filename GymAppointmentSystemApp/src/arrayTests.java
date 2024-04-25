import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class arrayTests
{
	@Test
	void test()
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
		
		//Add created course to created account
		testAccount1.addCourse(testCourse1);
		
		//Should be 1 but not, tried printing testAccount1.getCourseList() for entire
		//Course list of testAccount1 but returned "[Courses@515f550a]"
		assertEquals(1, testAccount1.getNumberOfCourses());
	}
}
