package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class NewUserWindow {

	public JFrame frmCreateUser;
	private JTextField txtFName;
	private JTextField txtLName;
	private JPasswordField txtPass;
	private JPasswordField txtConfPass;
	private JTextField txtUsername;
	private final Action action = new SwingAction();

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public NewUserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
		public void initialize() {
		frmCreateUser = new JFrame();
		frmCreateUser.setTitle("Create User");
		frmCreateUser.setResizable(false);
		frmCreateUser.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmCreateUser.setBounds(100, 100, 308, 382);
		frmCreateUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateUser.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(40, 56, 200, 22);
		frmCreateUser.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(40, 99, 200, 22);
		frmCreateUser.getContentPane().add(lblLastName);
		
		JLabel lblUsername = new JLabel("Desired Username");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(40, 138, 200, 22);
		frmCreateUser.getContentPane().add(lblUsername);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.LIGHT_GRAY);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPass.setBounds(40, 178, 200, 22);
		frmCreateUser.getContentPane().add(lblPass);
		
		JLabel lblConfPass = new JLabel("Confirm Password");
		lblConfPass.setForeground(Color.LIGHT_GRAY);
		lblConfPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfPass.setBounds(40, 221, 200, 22);
		frmCreateUser.getContentPane().add(lblConfPass);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFName.setBounds(30, 52, 241, 31);
		frmCreateUser.getContentPane().add(txtFName);
		txtFName.setColumns(10);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLName.setColumns(10);
		txtLName.setBounds(30, 95, 241, 31);
		frmCreateUser.getContentPane().add(txtLName);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setColumns(10);
		txtUsername.setBounds(30, 133, 241, 31);
		frmCreateUser.getContentPane().add(txtUsername);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setBounds(32, 176, 239, 31);
		frmCreateUser.getContentPane().add(txtPass);
		
		txtConfPass = new JPasswordField();
		txtConfPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtConfPass.setBounds(30, 219, 239, 31);
		frmCreateUser.getContentPane().add(txtConfPass);
		
		JButton btnNewButton = new JButton("Create User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(51, 279, 200, 31);
		frmCreateUser.getContentPane().add(btnNewButton);
		
		
		
		frmCreateUser.setVisible(true);
	}
		
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
