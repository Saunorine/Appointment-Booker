
public class Accounts
{
	private String name;
	//private int age;
	//If false then is a member acc
	private boolean isStaff;
	private String contactInfo;
	
	//Default values
	public Accounts() {
		isStaff = false;
		contactInfo = "Not filled out";
	}
	
	public String getName() {
		return name;
	}
	
	public boolean staffCheck() {
		return isStaff;
	}
	
	public String getContact() {
		return contactInfo;
	}
}
