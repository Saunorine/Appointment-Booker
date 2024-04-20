
public class starter
{

	public static void main(String[] args)
	{
		Accounts account1 = new Accounts("User 01", "123", "858-155-1332");
		
		staffAccount staffAcc = new staffAccount("Ultimate Lifter", "195kg", "The oldest Staff");
		
		System.out.println(account1.getInformation());
	}
}
