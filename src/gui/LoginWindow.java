package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;

public class LoginWindow {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(161, 46, 101, 25);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(161, 120, 91, 16);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(274, 43, 243, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(276, 113, 241, 31);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(317, 171, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		Button button = new Button("New button");
		button.setBounds(142, 172, 79, 24);
		frame.getContentPane().add(button);
	}
}
