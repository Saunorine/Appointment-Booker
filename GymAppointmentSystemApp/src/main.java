import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class main
{
	private static final String ACCOUNTS_FILE = "accounts.txt";
    private static final String COURSES_FILE = "courses.txt";
    private static final String ENROLLMENTS_FILE = "enrollments.txt";
	
	public static void main(String[] args) {
		//Sets text files to variables
    	ArrayList<Account> listOfAccounts = SavingDataClass.loadAccounts(ACCOUNTS_FILE);
        ArrayList<Course> listOfCourses = SavingDataClass.loadCourses(COURSES_FILE);
        SavingDataClass.loadEnrollments(ENROLLMENTS_FILE, listOfAccounts, listOfCourses);
    	
        //Saves changed info to text files
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            SavingDataClass.saveAccounts(listOfAccounts, ACCOUNTS_FILE);
            SavingDataClass.saveCourses(listOfCourses, COURSES_FILE);
            SavingDataClass.saveEnrollments(listOfAccounts, ENROLLMENTS_FILE);
        }));
        
        //Runs program
        SwingUtilities.invokeLater(() -> {
            new LoginMainScreen(listOfAccounts, listOfCourses).setVisible(true);
        });
    }
}
