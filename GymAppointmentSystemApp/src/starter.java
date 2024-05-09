import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
 
public class starter extends JFrame
{
	public static void main(String[] args)
	{
		ArrayList<Accounts> createdAccounts = new ArrayList<Accounts>();
		
		Accounts testAcc1 = new Accounts("Zhanhang", "123", "no info");
		createdAccounts.add(testAcc1);
		
		JFrame frame1 = new JFrame("Garduno's Special App");
		frame1.setSize(750, 500);
		
		JLabel logo = new JLabel("Welcome to Garduno's Gym. Login below");
		logo.setBounds(250, 10, 300, 180);
		frame1.add(logo);
		
		JLabel user = new JLabel("Member ID:");
		user.setBounds(180, 150, 75, 30);
		frame1.add(user);
		
		JTextField userNameInput = new JTextField(10);
		userNameInput.setBounds(260, 150, 200, 30);
		frame1.add(userNameInput);
		
		JLabel pass = new JLabel("Password:");
		pass.setBounds(180, 200, 75, 30);
		frame1.add(pass);
		
		JTextField userPassInput = new JTextField(10);
		userPassInput.setBounds(260, 200, 200, 30);
		frame1.add(userPassInput);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(340, 400, 65, 20);
		frame1.add(loginButton);
		//Logic for login button
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameInput.getText();
				String userPass = userPassInput.getText();
				
				for(Accounts elements : createdAccounts) {
					//Prints what is in the ArrayList
					System.out.println(elements.getName() + elements.getPassword());
					//Prints what the user typed
					System.out.println(userName + userPass + "User input");
					
					//Compares arrayList values to user input values
					if(elements.getName() == userName && elements.getPassword() == userPass) {
						JOptionPane.showMessageDialog(frame1, "You are in");
					}
					else{
						JOptionPane.showMessageDialog(frame1, "Invalid");
					}
				}
			}
		});
		
		frame1.setLayout(null);
		frame1.setVisible(true);
	}
}
