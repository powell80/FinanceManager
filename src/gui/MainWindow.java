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
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.Listener;
import main.NewExpense;
import database.DBInteract;
import database.DBInterface;

import java.awt.Panel;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;


public class MainWindow implements ActionListener{

	public JFrame frmFinanceManager;
	private JTextField txteAmount;
	private Rectangle rect;
	private JTextField txteName;
	private JTextField txteComm;
	private JComboBox cbeType;
	private JComboBox cbeCat;
	private NewExpense nExp;
	private DBInteract DBint;
	private ButtonGroup radGroup;
	
	//public ActionListener buttonPressed;
	
	//button declarations 
	private JButton btnSubmit;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		//initialize();
		this.nExp = new NewExpense();
		this.radGroup = new ButtonGroup();
		this.DBint = new DBInteract();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize() {
		DBInterface DBinter = new DBInterface();
		

		
		frmFinanceManager = new JFrame();
		frmFinanceManager.setTitle("Finance Manager");
		frmFinanceManager.setBounds(100, 100, 685, 633);
		frmFinanceManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFinanceManager.getContentPane().setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 662, 560);
		frmFinanceManager.getContentPane().add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel addExpPanel = new JPanel();
		addExpPanel.setBounds(12, 176, 293, 255);
		addExpPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Add Expense", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(addExpPanel);
		addExpPanel.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(12, 73, 62, 15);
		addExpPanel.add(lblAmount);
		
		btnSubmit  = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(164, 216, 117, 25);
		addExpPanel.add(btnSubmit);
		
		JLabel lblCatagory = new JLabel("Catagory");
		lblCatagory.setBounds(12, 110, 78, 15);
		addExpPanel.add(lblCatagory);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(12, 184, 78, 15);
		addExpPanel.add(lblComment);
		
		
		cbeCat = new JComboBox();
		cbeCat.setModel(new DefaultComboBoxModel(new String[] {"--Select One--", "Alcohol", "Coffee", "Groceries", "Gym", "Books", "Haircut", "Fuel", "Tips", "Rent", "Snacks", "Eating Out", "Bills", "Strip Clubs"}));
		cbeCat.setMaximumRowCount(15);
		cbeCat.setToolTipText("Select from a list of categories for each expense you make");
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seclect One"}));
		cbeCat.setBounds(90, 105, 191, 25);
		addExpPanel.add(cbeCat);
		
		txteAmount = new JTextField();
		txteAmount.setToolTipText("Amount of expense");
		txteAmount.setBounds(90, 68, 191, 25);
		addExpPanel.add(txteAmount);
		txteAmount.setColumns(10);
		
		txteName = new JTextField();
		txteName.setToolTipText("Amount of expense");
		txteName.setColumns(10);
		txteName.setBounds(90, 31, 191, 25);
		addExpPanel.add(txteName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 36, 70, 15);
		addExpPanel.add(lblName);
		
		txteComm = new JTextField();
		txteComm.setBounds(90, 179, 191, 25);
		addExpPanel.add(txteComm);
		txteComm.setColumns(10);
		
		cbeType = new JComboBox();
		cbeType.setModel(new DefaultComboBoxModel(new String[] {"--Select One--", "Daily", "Monthly", "Annual"}));
		cbeType.setToolTipText("Select from a list of categories for each expense you make");
		cbeType.setBounds(90, 142, 191, 25);
		addExpPanel.add(cbeType);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(12, 147, 78, 15);
		addExpPanel.add(lblType);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(317, 8, 328, 152);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Total", null, panel_1, null);
		
		JRadioButton rdbtnDay = new JRadioButton("Day");
		
		JRadioButton rdbtnWeek = new JRadioButton("Week");
		
		JRadioButton rdbtnMonth = new JRadioButton("Month");
		
		//add day, week, and month radio buttons to radioGroup
		radGroup.add(rdbtnDay);
		radGroup.add(rdbtnWeek);
		radGroup.add(rdbtnMonth);
		
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
		panel_6.setBounds(12, 8, 293, 156);
		panel_2.add(panel_6);
		
		JLabel label = new JLabel("1. ");
		label.setBounds(17, 17, 17, 15);
		
		JLabel label_1 = new JLabel("2. ");
		label_1.setBounds(17, 44, 17, 15);
		
		JLabel label_2 = new JLabel("3. ");
		label_2.setBounds(17, 71, 17, 15);
		
		JLabel label_3 = new JLabel("4. ");
		label_3.setBounds(17, 98, 17, 15);
		
		JLabel label_4 = new JLabel("5. ");
		label_4.setBounds(17, 125, 17, 15);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(40, 17, 236, 0);
		JLabel label_5 = new JLabel("");
		label_5.setBounds(40, 38, 236, 0);
		JLabel label_6 = new JLabel("");
		label_6.setBounds(40, 62, 236, 0);
		JLabel label_7 = new JLabel("");
		label_7.setBounds(40, 83, 236, 0);
		JLabel label_8 = new JLabel("");
		label_8.setBounds(40, 104, 236, 0);
		panel_6.setLayout(null);
		panel_6.add(label);
		panel_6.add(lblNewLabel);
		panel_6.add(label_1);
		panel_6.add(label_5);
		panel_6.add(label_2);
		panel_6.add(label_6);
		panel_6.add(label_3);
		panel_6.add(label_7);
		panel_6.add(label_4);
		panel_6.add(label_8);
		
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

	@Override
	public void actionPerformed(ActionEvent buttonPressed) {
		
		//test if create user button was pressed
		int i = 1;
		double exp;
		if(buttonPressed.getSource() == btnSubmit){
			System.out.println("submit button Button Pressed");
			exp = Double.parseDouble(txteAmount.getText());
			
			nExp.createExpense(txteName.getText(), exp, cbeCat.getSelectedItem().toString(), cbeType.getSelectedItem().toString(), txteComm.getText());
			
			
			txteName.setText(null);
			txteAmount.setText(null);
			cbeCat.setSelectedIndex(0);
			cbeType.setSelectedIndex(0);
			txteComm.setText(null);
			
			
			
			
			
			
		
		}		
	}
}

