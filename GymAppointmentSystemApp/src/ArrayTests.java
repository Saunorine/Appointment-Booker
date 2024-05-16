import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

class ArrayTests
{
	@Test
	void testAddCourseToAcc()
	{
		//Create account
		String accName = "Fermin";
		String accPassword = "mesa123";
		String accContactInfo = "fermin@gmail.com";
		Account testAccount1 = new Account(accName, accPassword);
		
		//Create course
		String courseName = "Beginner's Cardio";
		String courseDescription = "Cardio class for starters";
		LocalDate courseDate = LocalDate.parse("2024-03-22"); //YYYY-MM-DD
		//1st argument represents the hour(between 0 and 23),2nd argument represents the minute(between 0 and 59)
		LocalTime courseTime = LocalTime.of(15,30); //.of(hour, minute)  
		Course testCourse1 = new Course(courseName, courseDescription, courseDate, courseTime);
		
		//Change to details of 2nd course
		courseName = "Beginner's Cardio 2";
		courseDescription = "Cardio class for starters";
		courseDate = LocalDate.parse("2024-03-25");
		courseTime = LocalTime.of(11,30);
		
		//Create course 2
		Course testCourse2 = new Course(courseName, courseDescription, courseDate, courseTime);
		
		//Add created course to created account
		testAccount1.addCourse(testCourse1);
		assertEquals(1, testAccount1.getNumberOfCourses());
		
		//Add 2nd course to account 1, should be 2 now
		testAccount1.addCourse(testCourse2);
		assertEquals(2, testAccount1.getNumberOfCourses());
	}
	
	@Test
	void testRemoveCourseFromAcc() {
		
	}
}
