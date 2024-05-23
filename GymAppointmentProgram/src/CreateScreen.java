import javax.swing.*;
import java.util.ArrayList;
/**
 * Lead Author(s):
 * @author Zhanhang Xiao
 * @author Fermin Garduno
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
 * Responsibilities of abstract class:
 * Since CreateAccountPage and CreateCoursePage were so similar before, I decided to make
 * a parent class of the creation screen and extend this to their object pages.
 * Contains stuff for both classes
 * I don't think this actually makes the program any better but I didn't know how else to include subclasses.
 */
public abstract class CreateScreen extends JFrame {
    protected JTextField nameField;
    protected JPasswordField passwordField;
    protected JTextField infoField;
    protected JTextField dateField;
    protected JTextField timeField;
    protected ArrayList<?> listOfItems;
    protected JFrame parentFrame;
    
    /**
	 * CreateScreen constructor
	 * @param title
	 * @param parentFrame
	 * @param listOfItems
	 * listOfItems can either be a list of course or account objects depending on the call
	 */
    public CreateScreen(String title, JFrame parentFrame, ArrayList<?> listOfItems) {
        super(title);
        this.parentFrame = parentFrame;
        this.listOfItems = listOfItems;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        addComponentsToPanel(panel);
        addActionListeners();

        add(panel);
    }

    /**
	 * specified what it does in the subclasses
	 * basically adds the content to the window
	 * @param panel
	 */
    protected abstract void addComponentsToPanel(JPanel panel);
    
    /**
	 * specified what it does in the subclasses
	 */
    protected abstract void addActionListeners();
}