package main;

import java.sql.SQLException;
import java.sql.Timestamp;
import org.joda.time.DateTime;
import database.DBInterface;

public class NewExpense {
	
	private DBInterface DBint;
	private DateTime dateTime;
	private Timestamp timeStamp;
	
	public NewExpense(){
		this.DBint = new DBInterface();
	}
		
	public void createExpense(String eName, double eAmount, String eCat, String eType, String eComment){
		String sqlNewExpense;
		String name = eName;
		double amount =  eAmount;
		String category = eCat;
		String type = eType;
		String comment = eComment;
		dateTime = new DateTime();
		timeStamp = new Timestamp(dateTime.getMillis());
	
		
		sqlNewExpense = "INSERT INTO EXPENSES"
				+ "(ExpenseName, ExpenseAmount, ExpenseCat, ExpenseType, ExpenseComm, ExpenseDate)"
				+ "VALUES (" + "'" + name + "'," + "'" + amount + "'," + "'" + category + "'," + "'" + type + "'," + "'" + comment + "'," + "'" + timeStamp + "'" + ")"; 
		
		try{
			DBint.dbConnect().executeUpdate(sqlNewExpense);
			
			
			System.out.println("db Insert Successful");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
		}
	}
}//end of NewUser

