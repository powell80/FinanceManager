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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;

import main.NewUser;

import com.mysql.jdbc.Statement;

import database.DBInterface;

public class NewUserWindow implements ActionListener{

	LoginWindow login = new LoginWindow();
	MainWindow main = new MainWindow();
	DBInterface DBinter = new DBInterface();
	NewUser newUser = new NewUser();
	public JButton btnCreateUser;
	public JFrame frmCreateUser;
	private ResultSet rs;
	private JTextField txtFName;
	private JTextField txtLName;
	private String fName = null, lName = null;
	String sqlSelectUser = "select userNo, userFirstName, userLastName\n"
			+ "from USER";
	
	
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
		frmCreateUser.setBounds(100, 100, 628, 231);
		frmCreateUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateUser.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(40, 56, 200, 22);
		frmCreateUser.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(40, 99, 200, 22);
		frmCreateUser.getContentPane().add(lblLastName);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFName.setBounds(274, 52, 241, 31);
		frmCreateUser.getContentPane().add(txtFName);
		txtFName.setColumns(10);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLName.setColumns(10);
		txtLName.setBounds(274, 95, 241, 31);
		frmCreateUser.getContentPane().add(txtLName);
		
		//Create user submit button
		btnCreateUser = new JButton("Create User");
		btnCreateUser.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCreateUser.addActionListener(this);
		btnCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreateUser.setBounds(40, 149, 200, 31);
		frmCreateUser.getContentPane().add(btnCreateUser);
		
		
		//display the window on the screen
		frmCreateUser.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent buttonPressed) {
		//test if create user button was pressed
		int i = 1;
		if(buttonPressed.getSource() == btnCreateUser){
			System.out.println("Create User Button Pressed");
			newUser.createUser(txtFName.getText(), txtLName.getText());
			
			
			try {
			rs = DBinter.dbConnect().executeQuery(sqlSelectUser);
			
				while(rs.next()){
					
					fName = rs.getString("userFirstName");
					lName = rs.getString("userLastName");
					System.out.println( i + ". User: " + fName + " " + "lName");
					i ++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("User " + fName + " " + lName + " added successfully");
			frmCreateUser.dispose();
		}
	}
}
