
public class starter
{

	public static void main(String[] args)
	{
		Accounts account1 = new Accounts("User 01", "123", "858-155-1332");
		
		System.out.println(account1.getInformation());
		
		Courses course1 = new Courses("Beginner's Cardio", "Cardio class for starters", "March 22, 2024", "1500");
		
		System.out.println(course1.getInformation());
	}
}
