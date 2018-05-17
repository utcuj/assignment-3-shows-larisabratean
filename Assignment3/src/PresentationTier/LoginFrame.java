package PresentationTier;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import LogicTier.LoginController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame {

	private JFrame frame;
	public JTextField textUsername;
	public JPasswordField passwordField;
	public JButton btnAdmin ; 
	public JButton btnEmployee;
	/**
	 * Launch the application.
	 */
	
	public JFrame getFrame()
	{
		return this.frame;
	}
	public void setFrame()
	{
		this.frame.setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 474, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUsername.setBounds(115, 85, 78, 34);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(115, 147, 78, 34);
		panel.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(245, 93, 86, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);
		 
		
		JLabel lblPleaseLogIn = new JLabel("Please log in to continue:");
		lblPleaseLogIn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPleaseLogIn.setBounds(40, 34, 239, 20);
		panel.add(lblPleaseLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(245, 155, 86, 20);
		panel.add(passwordField);
		btnAdmin=new JButton("Log In Admin");
		btnAdmin.setBounds(68, 234, 125, 23);
		panel.add(btnAdmin);
		btnEmployee = new JButton("Log In User");
		 
		btnEmployee.setBounds(245, 234, 126, 23);
		panel.add(btnEmployee);
		 
	}
	public String[] getSignInData() {
		String username = textUsername.getText();
		String password = passwordField.getText();
		String[] data = {username, password};
		return data;
	}
}
