import javax.swing.*;
import java.util.ArrayList;

public class CreateAccountPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private ArrayList<Account> listOfAccounts;
    private LoginMainScreen loginMainScreen;

    public CreateAccountPage(LoginMainScreen loginMainScreen, ArrayList<Account> listOfAccounts) {
        super("Create Account");
        this.loginMainScreen = loginMainScreen;
        this.listOfAccounts = listOfAccounts;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton createButton = new JButton("Create");
        JButton goBackButton = new JButton("Go Back");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(createButton);
        panel.add(goBackButton);

        createButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            try {
                // Validate inputs using GUITools
                GUITools.validateUserInput(username, password);

                // Create a new account object
                Account newAccount = new Account(username, password);
                // Add the new account to the listOfAccounts
                listOfAccounts.add(newAccount);
                // Close current screen
                dispose();
                // Reopen login screen
                loginMainScreen.setVisible(true);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });

        goBackButton.addActionListener(e -> {
            // Close current screen
            dispose();
            // Reopen login screen
            loginMainScreen.setVisible(true);
        });

        add(panel);
    }
}