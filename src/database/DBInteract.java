package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main.CalInfo;

import org.joda.time.DateTime;

public class DBInteract {
	private static final String DB_URL = DBInterface.DB_URL;
	private static final String USER = DBInterface.USER;
	private static final String ATTRIBUTE = DBInterface.ATTRIBUTE;
	private DBInterface dbInt;
	private CalInfo cInfo;
	private Connection conn = null;
	private Statement stmt = null;
	private Date juDate;
	private DateTime dt;
	private java.sql.Date sqlDt;
	private SimpleDateFormat sdf;

	public DBInteract(){
		this.dbInt = new DBInterface();
		this.cInfo = new CalInfo();
	}
	
		public void dbRemove(){
			
		}
		
		public double dailyAvg(){
			Calendar cal = Calendar.getInstance();
			Calendar sqlCal = Calendar.getInstance();
			ResultSet rs = null;
			dt = new DateTime(juDate);
			int year = dt.getYear();
			int month = dt.getMonthOfYear();
			double monthlyAmount = 0;
			double avg = 0.0;
			
			String sqlCompDate = "SELECT ExpenseName, ExpenseAmount, ExpenseDate "
					+ "from EXPENSES  ORDER BY ExpenseDate, ExpenseTime DESC";
			
			try {
				rs = dbInt.dbConnect().executeQuery(sqlCompDate);
				dt.getMonthOfYear();
				while(rs.next()){
					sqlDt = rs.getDate("ExpenseDate");
					cal.setTime(sqlDt);
					if((cal.get(Calendar.MONTH) == month) && (cal.get(Calendar.YEAR) == year)){
						
					}
						monthlyAmount += rs.getDouble("ExpenseAmount");
					}
					
					System.out.println(monthlyAmount);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			avg = monthlyAmount / cInfo.getDaysInMonth();
			System.out.println(avg);
			return avg;
		}
		
		public double weeklyAvg(){
			Calendar cal = Calendar.getInstance();
			Calendar sqlCal = Calendar.getInstance();
			ResultSet rs = null;
			dt = new DateTime(juDate);
			int year = dt.getYear();
			int month = dt.getMonthOfYear();
			double monthlyAmount = 0;
			double avg = 0.0;
			
			String sqlCompDate = "SELECT ExpenseName, ExpenseAmount, ExpenseDate "
					+ "from EXPENSES  ORDER BY ExpenseDate, ExpenseTime DESC";
			
			try {
				rs = dbInt.dbConnect().executeQuery(sqlCompDate);
				dt.getMonthOfYear();
				while(rs.next()){
					sqlDt = rs.getDate("ExpenseDate");
					cal.setTime(sqlDt);
					if((cal.get(Calendar.MONTH) == month) && (cal.get(Calendar.YEAR) == year)){
						
					}
						monthlyAmount += rs.getDouble("ExpenseAmount");
					}
					
					System.out.println(monthlyAmount);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			avg = monthlyAmount / 4;
			System.out.println(avg);
			return avg;
		}
		
		public double monthlySpending(){
			Calendar cal = Calendar.getInstance();
			Calendar sqlCal = Calendar.getInstance();
			ResultSet rs = null;
			dt = new DateTime(juDate);
			int year = dt.getYear();
			int month = dt.getMonthOfYear();
			double monthlyAmount = 0;
			double avg = 0.0;
			
			String sqlCompDate = "SELECT ExpenseName, ExpenseAmount, ExpenseDate "
					+ "from EXPENSES  ORDER BY ExpenseDate, ExpenseTime ASC";
			
			try {
				rs = dbInt.dbConnect().executeQuery(sqlCompDate);
				dt.getMonthOfYear();
				while(rs.next()){
					sqlDt = rs.getDate("ExpenseDate");
					cal.setTime(sqlDt);
					if((Calendar.MONTH == month) && (cal.get(Calendar.YEAR) == year)){
						
					}
						monthlyAmount += rs.getDouble("ExpenseAmount");
					}
					
					System.out.println(monthlyAmount);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			avg = monthlyAmount;
			System.out.println(avg);
			return avg;
		}
		
		
		
		
		
		public ResultSet dbSelect(String sqlStmt){
			ResultSet rs = null;
			
			try {
				rs = dbStmt().executeQuery(sqlStmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
	
		public Statement dbStmt(){
			
			try {
				conn = DriverManager.getConnection(DB_URL, USER, ATTRIBUTE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stmt;
		}
	}
