import java.util.ArrayList;

public class Accounts
{
	private String name;
	private String password;
	//private int age;
	private String contactInfo;
	
	//Default values
	public Accounts() {
		name = "Fill name";
		password = "Set password";
		contactInfo = "Needs contact info";
	}
	
	public String setName() {
		return this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public String setPassword() {
		return this.password = password;
	}
	
	public String setContact() {
		return this.contactInfo = contactInfo;
	}
	public String getContact() {
		return contactInfo;
	}
	
	
}
