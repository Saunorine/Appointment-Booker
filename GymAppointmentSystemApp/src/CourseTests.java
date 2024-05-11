import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CourseTests
{
	//Tests getInformation and getInformation uses info from getters
	@Test
	void testGetInfoCourse() {
		String name = "Beginner's Cardio";
		String description = "Cardio class for starters";
		String date = "March 22, 2024";
		String time = "15:30";
		
		String output =  "Name: Beginner's Cardio. Description: Cardio class for starters. Date: March 22, 2024. Time: 15:30";
		
		Course testCourse1 = new Course(name, description, date, time);
		
		assertEquals(output, testCourse1.getInformation());
	}
}