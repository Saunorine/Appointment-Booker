import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoggedInPage extends JFrame {
    public LoggedInPage(String username, String password, LoginMainScreen loginMainScreen) {
    	super("Welcome");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        JLabel nameLabel = new JLabel("Username: " + username);
        JLabel passwordLabel = new JLabel("Password: " + password); // Not recommended
        JButton backButton = new JButton("Back to Account Creation");
        
        panel.add(welcomeLabel);
        panel.add(nameLabel);
        panel.add(passwordLabel);
        panel.add(backButton);
        
        backButton.addActionListener(e -> {
            // Dispose the current LoggedInPage
            dispose();
            // Reopen account creation screen
            loginMainScreen.setVisible(true);
        });
        
        add(panel);
    }
}