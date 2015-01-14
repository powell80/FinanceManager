package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import main.CalInfo;
import org.joda.time.DateTime;

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
			dateTime = new DateTime(juDate);
			int year = dateTime.getYear();
			int month = dateTime.getMonthOfYear();
			double monthlyAmount = 0;
			double avg = 0.0;
			
			String sqlCompDate = "SELECT ExpenseName, ExpenseAmount, ExpenseDate "
					+ "from EXPENSES  ORDER BY ExpenseDate DESC";
			
			try {
				rs = dbInt.dbConnect().executeQuery(sqlCompDate);
				while(rs.next()){
					
					System.out.println(sqlDate);
					
					if((1 == month) && (1 == year)){
						
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
