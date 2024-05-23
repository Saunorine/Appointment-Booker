import javax.swing.*;
import java.util.ArrayList;
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
 * Page that opens when the user wants to create an account
 * Contains stuff to make a new account
 */
public class CreateAccountPage extends CreateScreen {

    public CreateAccountPage(JFrame parentFrame, ArrayList<Account> listOfAccounts) {
        super("Create Account", parentFrame, listOfAccounts);
    }

    /**
	 * adds the visual content to the window
	 * @param panel
	 */
    @Override
    protected void addComponentsToPanel(JPanel panel) {
        nameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton createButton = new JButton("Create");
        JButton goBackButton = new JButton("Go Back");

        panel.add(new JLabel("Username:"));
        panel.add(nameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(createButton);
        panel.add(goBackButton);

        /**
    	 * Logic for create button on the account page
    	 */
        createButton.addActionListener(e -> {
            String username = nameField.getText();
            String password = new String(passwordField.getPassword());
            
            /**
        	 * Takes user input and creates a new account with it and adds it to master list of accounts
        	 */
            try {
                GUITools.validateUserInput(username, password);

                Account newAccount = new Account(username, password);
                ((ArrayList<Account>) listOfItems).add(newAccount);
                dispose();
                parentFrame.setVisible(true);
            }
            /**
        	 * If some other error, return this message in a smaller window
        	 */
            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
    	 * Go back button logic
    	 */
        goBackButton.addActionListener(e -> {
            dispose();
            parentFrame.setVisible(true);
        });
    }
    
    /**
	 * Action listeners are added in addComponentsToPanel
	 */
    @Override
    protected void addActionListeners() {
    	
    }
}