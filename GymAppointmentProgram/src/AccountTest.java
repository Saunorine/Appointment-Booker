import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

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
 * Junit tests for account class
 */
class AccountTest {

	@Test
	void testConstructorAndGetters()
	{
		String testName = "Fermin";
		String testPassword = "mesa123";
		String testContactInfo = "fermin@gmail.com";
		Account testAccount = new Account(testName, testPassword);
		
		// Testing getName()
		assertEquals(testName, testAccount.getName());
	}

	@Test
	void testGetInfoAccount()
	{
		String name = "User 01";
		String password = "123";
		String contactInfo = "858-155-1332";
		Account testAcc1 = new Account(name, password);
		String output =  "Name: User 01. Password: 123";
		
		assertEquals(output, testAcc1.getInformation());
	}
}
