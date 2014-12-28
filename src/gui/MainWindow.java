package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class MainWindow {

	public JFrame frmFinanceManager;
	private JTextField textField;
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
		frmFinanceManager = new JFrame();
		frmFinanceManager.getContentPane().setBackground(Color.WHITE);
		frmFinanceManager.setTitle("Finance Manager");
		frmFinanceManager.setBounds(100, 100, 1280, 800);
		frmFinanceManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFinanceManager.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 729, 560);
		frmFinanceManager.getContentPane().add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Main", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 240, 254);
		panel.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(105, 36, 114, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 85, 114, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 137, 114, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(32, 41, 70, 15);
		panel.add(lblAmount);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(102, 192, 117, 25);
		panel.add(btnSubmit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(304, 12, 301, 107);
		panel_2.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(304, 145, 301, 107);
		panel_2.add(panel_4);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Monthly", null, panel_3, null);
		
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
}
