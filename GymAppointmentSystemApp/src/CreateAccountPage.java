import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccountPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private ArrayList<Account> listOfAccounts; // Rename accounts to listOfAccounts

    public CreateAccountPage(LoginMainScreen loginMainScreen, ArrayList<Account> listOfAccounts) {
        super("Create Account");

        this.listOfAccounts = listOfAccounts; // Assign the passed listOfAccounts to this.listOfAccounts

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton createButton = new JButton("Create");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(createButton);

        createButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // Create a new account object
            Account newAccount = new Account(username, password);
            // Add the new account to the listOfAccounts
            listOfAccounts.add(newAccount);
            // Close current screen
            dispose();
            // Reopen login screen
            loginMainScreen.setVisible(true);
        });

        add(panel);
    }
}