import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class courseTests
{

	@Test
	void testGetInfoAccount()
	{
		Accounts testAcc1 = new Accounts("User 01", "123", "858-155-1332");
		String output =  "Name: User 01. Password: 123. Other info: 858-155-1332";
		
		assertEquals(output, testAcc1.getInformation());
	}
	
	@Test
	void testGetInfoCourse() {
		String name = "Beginner's Cardio";
		String description = "Cardio class for starters";
		String date = "March 22, 2024";
		String time = "15:30";
		
		String output =  "Name: Beginner's Cardio. Description: Cardio class for starters. Date: March 22, 2024. Time:15:30";
		
		Courses testCourse1 = new Courses(name, description, date, time);
		
		assertEquals(output, testCourse1.getInformation());
	}

}
