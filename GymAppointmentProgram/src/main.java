import java.util.ArrayList;

import javax.swing.SwingUtilities;
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
 * Main runner of the program
 * Makes program check txt files for info before running
 */
public class main
{
	private static final String ACCOUNTS_FILE = "accounts.txt";
    private static final String COURSES_FILE = "courses.txt";
    private static final String ENROLLMENTS_FILE = "enrollments.txt";
	
	public static void main(String[] args) {
		/**
    	 * Reads txt file for account and course info and enrollments
    	 */
    	ArrayList<Account> listOfAccounts = SavingDataClass.loadAccounts(ACCOUNTS_FILE);
        ArrayList<Course> listOfCourses = SavingDataClass.loadCourses(COURSES_FILE);
        SavingDataClass.loadEnrollments(ENROLLMENTS_FILE, listOfAccounts, listOfCourses);
    	
        /**
    	 * Saves changed info to txt files when closing
    	 */
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            SavingDataClass.saveAccounts(listOfAccounts, ACCOUNTS_FILE);
            SavingDataClass.saveCourses(listOfCourses, COURSES_FILE);
            SavingDataClass.saveEnrollments(listOfAccounts, ENROLLMENTS_FILE);
        }));
        
        /**
    	 * runs program
    	 */
        SwingUtilities.invokeLater(() -> {
            new LoginMainScreen(listOfAccounts, listOfCourses).setVisible(true);
        });
    }
}
