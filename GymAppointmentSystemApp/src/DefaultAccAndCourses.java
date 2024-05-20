import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DefaultAccAndCourses
{
	public static ArrayList<Account> getDefaultAccounts() {
		ArrayList<Account> defaultAccounts = new ArrayList<>();
        // Add default user accounts
        defaultAccounts.add(new Account("Tom", "lakersFan77"));
        defaultAccounts.add(new Account("user2", "password2"));
        // Add default staff account
        defaultAccounts.add(new Account("Armstrong", "bigman", true)); // Staff account
        return defaultAccounts;
    }
	
    public static ArrayList<Course> getDefaultCourses() {
        ArrayList<Course> defaultCourses = new ArrayList<>();
        // Add default courses here
        defaultCourses.add(new Course("Beginner's Carido", "Beginners", LocalDate.of(2023, 5, 20), LocalTime.of(10, 15)));
        defaultCourses.add(new Course("Armstrong's Early Hour", "Advanced", LocalDate.of(2023, 5, 17), LocalTime.of(7, 0)));
        defaultCourses.add(new Course("Lightweight Yoga", "Beginners", LocalDate.of(2023, 2, 4), LocalTime.of(15, 30)));
        defaultCourses.add(new Course("Leg Days with Carl", "Intermediate", LocalDate.of(2023, 6, 13), LocalTime.of(17, 0)));
        return defaultCourses;
    }
}
