import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class courseTests
{
	//Tests getInformation and getInformation uses info from getters
	@Test
	void testGetInfoCourse() {
		String name = "Beginner's Cardio";
		String description = "Cardio class for starters";
		String date = "March 22, 2024";
		String time = "15:30";
		
		String output =  "Name: Beginner's Cardio. Description: Cardio class for starters. Date: March 22, 2024. Time: 15:30";
		
		Courses testCourse1 = new Courses(name, description, date, time);
		
		assertEquals(output, testCourse1.getInformation());
	}

	@Test
	void testRemoveCourse() {
		Accounts testAcc2 = new Accounts("Zhang", "533", "zxzhanhang@gmail.com");
		Courses testCourse2 = new Courses("Intermediate Cardio", "Step up above beginners", "March 24,2024", "09:30");
		
		
	}
}
