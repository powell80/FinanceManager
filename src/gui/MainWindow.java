package gui;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


import database.DBInterface;

import java.awt.Panel;


public class MainWindow {

	public JFrame frmFinanceManager;
	private JTextField textField;
	private Rectangle rect;
	private JTextField textField_1;
	private JTextField textField_2;
	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		Calender cal = new Calender();
		ButtonGroup radioGroup = new ButtonGroup();
		DBInterface DBinter = new DBInterface();
		frmFinanceManager = new JFrame();
		frmFinanceManager.setTitle("Finance Manager");
		frmFinanceManager.setBounds(100, 100, 1280, 800);
		frmFinanceManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFinanceManager.getContentPane().setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 662, 560);
		frmFinanceManager.getContentPane().add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 176, 293, 221);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Add Expense", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel);
		panel.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(12, 73, 62, 15);
		panel.add(lblAmount);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(164, 177, 117, 25);
		panel.add(btnSubmit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select from a list of categories for each expense you make");
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seclect One"}));
		comboBox.setBounds(90, 105, 191, 25);
		panel.add(comboBox);
		
		JLabel lblCatagory = new JLabel("Catagory");
		lblCatagory.setBounds(12, 110, 78, 15);
		panel.add(lblCatagory);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(12, 142, 78, 15);
		panel.add(lblComment);
		
		textField = new JTextField();
		textField.setToolTipText("Amount of expense");
		textField.setBounds(90, 68, 191, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Amount of expense");
		textField_1.setColumns(10);
		textField_1.setBounds(90, 31, 191, 25);
		panel.add(textField_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 36, 70, 15);
		panel.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 140, 191, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(317, 8, 328, 152);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Total", null, panel_1, null);
		
		JRadioButton rdbtnDay = new JRadioButton("Day");
		
		JRadioButton rdbtnWeek = new JRadioButton("Week");
		
		JRadioButton rdbtnMonth = new JRadioButton("Month");
		
		//add day, week, and month radio buttons to radioGroup
		radioGroup.add(rdbtnDay);
		radioGroup.add(rdbtnWeek);
		radioGroup.add(rdbtnMonth);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Amount", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(39)
							.addComponent(rdbtnDay)
							.addGap(18)
							.addComponent(rdbtnWeek)
							.addGap(18)
							.addComponent(rdbtnMonth))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(60)
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnWeek)
						.addComponent(rdbtnDay)
						.addComponent(rdbtnMonth))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Spending", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Income", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Recent Expenses", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_6.setBounds(12, 12, 293, 152);
		panel_2.add(panel_6);
		
		JLabel label = new JLabel("1. ");
		
		JLabel label_1 = new JLabel("2. ");
		
		JLabel label_2 = new JLabel("3. ");
		
		JLabel label_3 = new JLabel("4. ");
		
		JLabel label_4 = new JLabel("5. ");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(254, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1)
					.addGap(9)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_4)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		Calender calender = new Calender();
		calender.setBounds(12, 59, 630, 450);
		panel_3.add(calender);
		tabbedPane.addTab("Monthly Calender", null, panel_3, null);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmFinanceManager.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenu mnOpen = new JMenu("Open");
		mnFile.add(mnOpen);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		mnFile.add(menuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		frmFinanceManager.setVisible(true);
		
	}	
		public void actionPerformed(ActionEvent buttonPressed) {
			DBInterface dbint = new DBInterface();
			
			
			
		}
	}
