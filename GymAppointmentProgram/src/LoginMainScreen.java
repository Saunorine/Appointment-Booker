import javax.swing.*;
import java.util.ArrayList;
/**
 * Lead Author(s):Zhanhang Xiao
 * Fermin Garduno
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
 * Page that the user first sees, can login or create an account
 */
public class LoginMainScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private ArrayList<Account> listOfAccounts;
    private ArrayList<Course> listOfCourses;
    
    /**
	 * Login screen constructor
	 * @param accounts ArrayList<Account>
	 * @param courses ArrayList<Course>
	 */
    public LoginMainScreen(ArrayList<Account> accounts, ArrayList<Course> courses) {
        super("Garduno's Gym App");
        this.listOfAccounts = accounts;
        this.listOfCourses = courses;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton createAccountButton = new JButton("Create Account");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(createAccountButton);

        /**
    	 * Login button logic
    	 */
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            /**
        	 * Checks user input with methods from GUITools
        	 */
            try {
                GUITools.validateUserInput(username, password);

                /**
            	 * Check if user input matches any account
            	 */
                Account loggedInAccount = null;
                for (Account account : listOfAccounts) {
                    if (account.getName().equals(username) && account.getPassword().equals(password)) {
                        loggedInAccount = account;
                        break;
                    }
                }

                if (loggedInAccount != null) {
                    if (loggedInAccount.isStaff()) {
                        new StaffLoggedInPage(loggedInAccount, listOfCourses, this).setVisible(true);
                    }
                    else {
                        new LoggedInPage(loggedInAccount, this, listOfCourses).setVisible(true);
                    }
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        /**
    	 * Account creation button logic
    	 * Simply closes current loginMainScreen and opens CreateAccountPage
    	 * clearFields() is necessary because during testing going back to this screen
    	 * still had the info saved from the last login
    	 */
        createAccountButton.addActionListener(e -> {
            dispose(); // Close current login screen
            new CreateAccountPage(this, listOfAccounts).setVisible(true);
            // Clear fields when leaving screen
            clearFields();
        });
        
        /**
    	 * Logic to button that displays all account info, mainly used for testing purposes
    	 * Can just be turned off by removing add(panel);
    	 */
        JButton displayAccountsButton = new JButton("Display All Accounts");
        panel.add(displayAccountsButton);
        displayAccountsButton.addActionListener(e -> {
            StringBuilder allAccounts = new StringBuilder();
            /**
        	 * Loop to display information
        	 */
            for (Account account : listOfAccounts) {
                String accountInfo = account.getInformation();
                /**
            	 * Adds indicator before the information if they are a regular user or staff
            	 */
                if (account.isStaff()) {
                    allAccounts.append("Staff - ").append(accountInfo).append("\n");
                } else {
                    allAccounts.append("User - ").append(accountInfo).append("\n");
                }
            }
            JOptionPane.showMessageDialog(this, allAccounts.toString(), "All Accounts", JOptionPane.INFORMATION_MESSAGE);
        });

        add(panel);
    }

    /**
	 * Clears field so if you logout, the info doesn't stay there
	 */
    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
}