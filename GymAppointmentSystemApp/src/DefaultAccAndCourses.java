import java.util.ArrayList;

public class DefaultAccAndCourses
{
	public static ArrayList<Account> getDefaultAccounts() {
        ArrayList<Account> defaultAccounts = new ArrayList<>();
        // Add default accounts here
        defaultAccounts.add(new Account("user1", "password1"));
        defaultAccounts.add(new Account("user2", "password2"));
        return defaultAccounts;
    }

    public static ArrayList<Course> getDefaultCourses() {
        ArrayList<Course> defaultCourses = new ArrayList<>();
        // Add default courses here
        defaultCourses.add(new Course("Introduction to Java Programming", "Beginners", "2024-05-15", "10:00 AM"));
        defaultCourses.add(new Course("Advanced Java Programming", "Advanced", "2024-05-17", "2:00 PM"));
        return defaultCourses;
    }
}
