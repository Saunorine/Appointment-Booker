
public class starter
{

	public static void main(String[] args)
	{
		Accounts account1 = new Accounts();
		
		account1.setName("User 01");
		account1.setPassword("123");
		account1.setContact("858-155-1332");
		
		staffAccount staffAcc = new staffAccount();
		staffAcc.setName("Trainer1");
		staffAcc.setPassword("bestTrainer");
	}

}
