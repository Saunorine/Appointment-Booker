import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class main
{
	public static void main(String[] args) {
    	ArrayList<Account> listOfAccounts = DefaultAccAndCourses.getDefaultAccounts();
        ArrayList<Course> listOfCourses = DefaultAccAndCourses.getDefaultCourses();
    	
        SwingUtilities.invokeLater(() -> {
            new LoginMainScreen(listOfAccounts, listOfCourses).setVisible(true);
        });
    }
}
