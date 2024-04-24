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

	
}
