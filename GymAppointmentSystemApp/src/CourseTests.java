import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;


class CourseTests
{
	//Tests getInformation and getInformation uses info from getters
	@Test
	void testGetInfoCourse() {
		String name = "Beginner's Cardio";
		String description = "Cardio class for starters";
		LocalDate date = LocalDate.parse("2024-03-22");
		LocalTime time = LocalTime.of(15,30);
		
		String output =  "Name: Beginner's Cardio. Description: Cardio class for starters. Date: 2024-03-22. Time: 15:30";
		
		Course testCourse1 = new Course(name, description, date, time);
		
		assertEquals(output, testCourse1.getInformation());
	}
}
