package gui;

import java.awt.Color;

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
import javax.swing.text.NumberFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import main.NewExpense;
import main.CalInfo;
import database.DBInteract;
import database.DBInterface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;

import org.joda.time.DateTime;

import java.awt.Font;


public class MainWindow implements ActionListener{

	public JFrame frmFinanceManager;
	private JTextField txteAmount;
	private JTextField txteName;
	private JTextField txteComm;
	private JComboBox cbeType;
	private JComboBox cbeCat;
	private NewExpense nExp;
	private CalInfo cInfo;
	private DBInteract DBint;
	private ButtonGroup radGroup;
	public JLabel firstExp, secondExp, thirdExp, fourthExp, fifthExp, lblAvgAmount;
	private JRadioButton rdbtnDay, rdbtnWeek, rdbtnMonth;
	private String expName;
	private double expAmount, dailyAvg, WeeklyAvg, MonthlyAvg;
	private DBInterface dbInter;
	private ResultSet rs;
	private int month, week, day, numDays;
	private Date expDate, juDate;
	private DateTime dt; 
	
	String selectRecentExp = "SELECT ExpenseName, ExpenseAmount, ExpenseDate, ExpenseDate "
			+ "from EXPENSES  ORDER BY ExpenseDate, ExpenseTime DESC";
	
	//public ActionListener buttonPressed;
	
	//button declarations 
	private JButton btnSubmit;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		//initialize();
		
		dt = new DateTime(juDate);
		this.nExp = new NewExpense();
		this.radGroup = new ButtonGroup();
		this.DBint = new DBInteract();
		this.dbInter = new DBInterface();
		this.cInfo = new CalInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize() {
		frmFinanceManager = new JFrame();
		frmFinanceManager.setTitle("Finance Manager");
		frmFinanceManager.setBounds(100, 100, 685, 633);
		frmFinanceManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFinanceManager.getContentPane().setLayout(null);
		NumberFormat doubleFormat = new DecimalFormat("#0.00");
		Calendar.getInstance();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 662, 560);
		frmFinanceManager.getContentPane().add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel addExpPanel = new JPanel();
		addExpPanel.setBounds(12, 189, 293, 255);
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
		cbeCat.setModel(new DefaultComboBoxModel(new String[] {"--Select One--", "Alcohol",  "Bills", "Coffee", "Hobbies", "Groceries", "Gym", "Books", "Movies", "Haircut", "Fuel", "Tips", "Rent", "Snacks", "Eating Out", "Strip Clubs", "Misc."}));
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
		tabbedPane_1.setBounds(370, 8, 275, 169);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Total", null, panel_1, null);
		
		rdbtnDay = new JRadioButton("Day");
		rdbtnDay.setSelected(true);
		
		rdbtnWeek = new JRadioButton("Week");
		
		rdbtnMonth = new JRadioButton("Month");
		
		//add day, week, and month radio buttons to radioGroup
		radGroup.add(rdbtnDay);
		radGroup.add(rdbtnWeek);
		radGroup.add(rdbtnMonth);
		rdbtnDay.addActionListener(this);
		rdbtnWeek.addActionListener(this);
		rdbtnMonth.addActionListener(this);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Amount", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(rdbtnDay)
							.addGap(18)
							.addComponent(rdbtnWeek)
							.addGap(18)
							.addComponent(rdbtnMonth)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnDay)
						.addComponent(rdbtnWeek)
						.addComponent(rdbtnMonth))
					.addGap(18)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		lblAvgAmount = new JLabel("Daily Average");
		lblAvgAmount.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_7.add(lblAvgAmount);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Spending", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Income", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Recent Expenses", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_6.setBounds(12, 8, 346, 169);
		panel_2.add(panel_6);
		
		JLabel lab1 = new JLabel("1. ");
		lab1.setBounds(17, 31, 17, 15);
		
		JLabel lab2 = new JLabel("2. ");
		lab2.setBounds(17, 58, 17, 15);
		
		JLabel lab3 = new JLabel("3. ");
		lab3.setBounds(17, 85, 17, 15);
		
		JLabel lab4 = new JLabel("4. ");
		lab4.setBounds(17, 112, 17, 15);
		
		JLabel lab5 = new JLabel("5. ");
		lab5.setBounds(17, 139, 17, 15);
		
		firstExp= new JLabel("");
		firstExp.setBounds(46, 28, 288, 20);
		secondExp = new JLabel("");
		secondExp.setBounds(45, 55, 289, 20);
		thirdExp = new JLabel("");
		thirdExp.setBounds(45, 82, 289, 20);
		fourthExp = new JLabel("");
		fourthExp.setBounds(45, 109, 289, 20);
		fifthExp = new JLabel("");
		fifthExp.setBounds(45, 136, 289, 20);
		panel_6.setLayout(null);
		panel_6.add(firstExp);
		panel_6.add(lab1);
		panel_6.add(secondExp);
		panel_6.add(lab2);
		panel_6.add(thirdExp);
		panel_6.add(lab3);
		panel_6.add(fourthExp);
		panel_6.add(lab4);
		panel_6.add(fifthExp);
		panel_6.add(lab5);
		
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
		rdbtnDay.setSelected(true);
		//month =cInfo.getMonth(); 
		//numDays = cInfo.getDaysInMonth();
		dailyAvg = DBint.dailyAvg();
		lblAvgAmount.setText((doubleFormat.format(dailyAvg)));
		try {
			rs = dbInter.dbConnect().executeQuery(selectRecentExp);
			int i = 1;
			
			while(rs.next()){
				
				if(i == 1){
					expName = rs.getString("ExpenseName");
					expAmount = rs.getDouble("ExpenseAmount");
					expDate = rs.getDate("ExpenseDate");
					firstExp.setText(expName + "--" + expAmount + "--" + expDate);
				}
				if(i ==2){
					expName = rs.getString("ExpenseName");
					expAmount = rs.getDouble("ExpenseAmount");
					expDate = rs.getDate("ExpenseDate");
					secondExp.setText(expName + "--" + expAmount + "--" + expDate);
				}
				if(i == 3){
					expName = rs.getString("ExpenseName");
					expAmount = rs.getDouble("ExpenseAmount");
					expDate = rs.getDate("ExpenseDate");
					thirdExp.setText(expName + "--" + expAmount + "--" + expDate);
				}
				if(i == 4){
					expName = rs.getString("ExpenseName");
					expAmount = rs.getDouble("ExpenseAmount");
					expDate = rs.getDate("ExpenseDate");
					fourthExp.setText(expName + "--" + expAmount + "--" + expDate);
				}
				if(i ==5){
					expName = rs.getString("ExpenseName");
					expAmount = rs.getDouble("ExpenseAmount");
					expDate = rs.getDate("ExpenseDate");
					fifthExp.setText(expName + "--" + expAmount + "--" + expDate);
				}
				else{
					//break;
				}
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		NumberFormat doubleFormat = new DecimalFormat("#0.00");
		//test if create user button was pressed
		double exp;
		
		
		if(event.getSource() == btnSubmit){
			int i = 1;
			
			System.out.println("submit button Button Pressed");
			exp = Double.parseDouble(txteAmount.getText());
			
			nExp.createExpense(txteName.getText(), exp, cbeCat.getSelectedItem().toString(), 
								cbeType.getSelectedItem().toString(), txteComm.getText());
			
			
			try {
				rs = dbInter.dbConnect().executeQuery(selectRecentExp);
				
				while(rs.next()){
					
					
					
					if(i == 1){
						expName = rs.getString("ExpenseName");
						expAmount = rs.getDouble("ExpenseAmount");
						expDate = rs.getDate("ExpenseDate");
						firstExp.setText(expName + "--" + expAmount + "--" + expDate);
					}
					if(i ==2){
						expName = rs.getString("ExpenseName");
						expAmount = rs.getDouble("ExpenseAmount");
						expDate = rs.getDate("ExpenseDate");
						secondExp.setText(expName + "--" + expAmount + "--" + expDate);
					}
					if(i == 3){
						expName = rs.getString("ExpenseName");
						expAmount = rs.getDouble("ExpenseAmount");
						expDate = rs.getDate("ExpenseDate");
						thirdExp.setText(expName + "--" + expAmount + "--" + expDate);
					}
					if(i == 4){
						expName = rs.getString("ExpenseName");
						expAmount = rs.getDouble("ExpenseAmount");
						expDate = rs.getDate("ExpenseDate");
						fourthExp.setText(expName + "--" + expAmount + "--" + expDate);
					}
					if(i ==5){
						expName = rs.getString("ExpenseName");
						expAmount = rs.getDouble("ExpenseAmount");
						expDate = rs.getDate("ExpenseDate");
						fifthExp.setText(expName + "--" + expAmount + "--" + expDate);
					}
					else{
						//break;
					}
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			txteName.setText(null);
			txteAmount.setText(null);
			cbeCat.setSelectedIndex(0);
			cbeType.setSelectedIndex(0);
			txteComm.setText(null);
			
		}
		
		if(rdbtnDay.isSelected()){
			
			dailyAvg = DBint.dailyAvg();
			lblAvgAmount.setText(doubleFormat.format(dailyAvg));
		}
		if(rdbtnWeek.isSelected()){
			WeeklyAvg = DBint.weeklyAvg();
			lblAvgAmount.setText(doubleFormat.format(WeeklyAvg));
		}
		if(rdbtnMonth.isSelected()){
			MonthlyAvg = DBint.monthlySpending();
			lblAvgAmount.setText(doubleFormat.format(MonthlyAvg));
		}
	}
}

