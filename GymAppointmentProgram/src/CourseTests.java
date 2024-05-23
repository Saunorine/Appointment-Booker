import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
/**
 * Lead Author(s):Zhanhang Xiao
 * Fermin Garduno
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley. 
 * 
 * <<add more references here>>
 *  
 * Version/date: May 23, 2024
 * 
 * Responsibilities of class:
 * Junit tests for Course class
 */
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
