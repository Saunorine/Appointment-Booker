import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
 
public class starter extends JFrame
{

	public static void main(String[] args)
	{
		
		JFrame frame1 = new JFrame("Garduno's Special App");
		frame1.setSize(750, 500);
		
		JLabel logo = new JLabel("Welcome to Garduno's Gym. Login below");
		logo.setBounds(250, 10, 300, 180);
		frame1.add(logo);
		
		JLabel user = new JLabel("Member ID:");
		user.setBounds(180, 150, 75, 30);
		frame1.add(user);
		
		JLabel pass = new JLabel("Password:");
		pass.setBounds(180, 200, 75, 30);
		frame1.add(pass);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(340, 400, 65, 20);
		frame1.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Login clicked!");
			}
		});
		
		frame1.setLayout(null);
		frame1.setVisible(true);
	}
}
