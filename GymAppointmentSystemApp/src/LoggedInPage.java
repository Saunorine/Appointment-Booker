import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoggedInPage extends JFrame {
    public LoggedInPage(String username) {
        super("Welcome");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750,500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        panel.add(welcomeLabel);

        add(panel);
    }
}