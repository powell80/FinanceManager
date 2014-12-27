package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginWindow implements ActionListener{

	public JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	public JButton btnLogin;
	public MainWindow main = new MainWindow();
	/**
	 * Create the application.
	 */
	public LoginWindow() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setAlwaysOnTop(true);
		frmLogin.setBounds(200, 200, 567, 265);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(63, 46, 119, 25);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(73, 120, 109, 16);
		frmLogin.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(182, 43, 243, 31);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(182, 113, 241, 31);
		frmLogin.getContentPane().add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		btnLogin.setBounds(193, 171, 178, 47);
		frmLogin.getContentPane().add(btnLogin);
		
		frmLogin.setVisible(true);
		main.initialize();
	}
	
	public void actionPerformed(ActionEvent buttonPressed) {
		if(buttonPressed.getSource() == btnLogin){
			System.out.println("Login Button Pressed");
		}
	}
}
