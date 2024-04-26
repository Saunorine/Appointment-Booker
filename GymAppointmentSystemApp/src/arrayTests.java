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
		
		//Change to details of 2nd course
		courseName = "Beginner's Cardio 2";
		courseDescription = "Cardio class for starters";
		courseDate = "March 25, 2024";
		courseTime = "11:30";
		
		//Create course 2
		Courses testCourse2 = new Courses(courseName, courseDescription, courseDate, courseTime);
		
		//Add created course to created account
		testAccount1.addCourse(testCourse1);
		assertEquals(1, testAccount1.getNumberOfCourses());
		
		//Add 2nd course to account 1, should be 2 now
		testAccount1.addCourse(testCourse2);
		assertEquals(2, testAccount1.getNumberOfCourses());
	}
}
