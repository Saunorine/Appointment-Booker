import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class accountTest {

	@Test
	void testConstructorAndGetters()
	{
		String testName = "Fermin";
		String testPassword = "mesa123";
		String testContactInfo = "fermin@gmail.com";
		Accounts testAccount = new Accounts(testName, testPassword, testContactInfo);
		
		// Testing getName()
		assertEquals(testName, testAccount.getName());
		
		// Testing getContact()
		assertEquals(testContactInfo, testAccount.getContact());
	}

	@Test
	void testAddCourseAndGetCourse()
	{
		//creating an Account Object to work with
		Accounts joeAccount = new Accounts("Joe", "password321", "joe123@gmail.com");
		
		//checking the initial size of coursesEnrolledin
		assertEquals(0, joeAccount.getCourses().size());	
		
		//Our test courses
		String course1 = "personal training";
		String course2 = "yoga class";
		
		//testing addCourses
		joeAccount.addCourse(course1); 
		joeAccount.addCourse(course2);
		
		//testing getCourses
		//created ArrayList 
		ArrayList<String> expectedCourses = new ArrayList<>(); 
		expectedCourses.add(course1);
		expectedCourses.add(course2);
		//when we test it, joeAccount and expectedCourses should have the same course ID
		assertEquals(expectedCourses, joeAccount.getCourses());
		
		
		
	}
}
