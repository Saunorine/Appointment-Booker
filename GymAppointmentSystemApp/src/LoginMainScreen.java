import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginMainScreen extends JFrame
{
	private JTextField usernameField;
    private JPasswordField passwordField;
    private ArrayList<Account> listOfAccounts;
    private ArrayList<Account> listOfStaffAccounts;
    private ArrayList<Course> listOfCourses;

    public LoginMainScreen(ArrayList<Account> defaultAccounts, ArrayList<Course> defaultCourses) {
        super("Garduno's Gym App");
        this.listOfAccounts = defaultAccounts;
        this.listOfCourses = defaultCourses;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton createAccountButton = new JButton("Create Account");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(createAccountButton);
        
        //Logic for logging in
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check if entered credentials match any account
            boolean loggedIn = false;
            for (Account account : listOfAccounts) {
                if (account.getName().equals(username) && account.getPassword().equals(password)) {
                    loggedIn = true;
                    break;
                }
            }

            if (loggedIn) {
                // Open placeholder page if login is successful
                new LoggedInPage(username, password, this, listOfCourses).setVisible(true);
                dispose(); // Close login screen
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        createAccountButton.addActionListener(e -> {
            dispose(); // Close current login screen
            new CreateAccountPage(this, listOfAccounts).setVisible(true);
            //Clear fields when leaving screen
            clearFields();
        });
        
        JButton displayAccountsButton = new JButton("Display All Accounts");
        panel.add(displayAccountsButton);
        displayAccountsButton.addActionListener(e -> {
            StringBuilder allAccounts = new StringBuilder();
            for (Account account : listOfAccounts) {
                allAccounts.append(account.getInformation()).append("\n");
            }
            JOptionPane.showMessageDialog(this, allAccounts.toString(), "All Accounts", JOptionPane.INFORMATION_MESSAGE);
        });

        add(panel);
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            clearFields();
        }
    }
    
    //Clears fields when called
    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

}
