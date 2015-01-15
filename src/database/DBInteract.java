package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import main.CalInfo;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DBInteract {
	private DBInterface dbInt;
	private CalInfo cInfo;
	private Date juDate;
	private DateTime dateTime;
	Timestamp sqlDate;

	public DBInteract(){
		this.dbInt = new DBInterface();
		this.cInfo = new CalInfo();
	}
	
		public void dbRemove(){
			
		}
		
		public double dailyAvg(){
			ResultSet rs = null;
			DateTime dt = new DateTime();
			long timestamp;
			int daysInMonth;
			double monthlyAmount = 0;
			double avg = 0.0;
			
			String sqlCompDate = "SELECT ExpenseName, ExpenseAmount, ExpenseDate "
					+ "from EXPENSES  ORDER BY ExpenseDate DESC";
			
			try {
				rs = dbInt.dbConnect().executeQuery(sqlCompDate);
				
				while(rs.next()){
					dateTime = new DateTime(rs.getDate("ExpenseDate"));
					
					
					
					System.out.println(dateTime.getDayOfMonth());
					System.out.println(dt.getDayOfMonth());
					//System.out.println("year = " + year);
					
					if(dateTime.getMonthOfYear() == dt.getMonthOfYear()){
						
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
			
			return 0;
		}
		
		public double monthlySpending(){
		
			return 0;
		}
	}
