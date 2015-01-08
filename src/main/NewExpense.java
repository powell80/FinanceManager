package main;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.DBInteract;

public class NewExpense {
	
	private DBInteract DBint;
	private Date date;
	private SimpleDateFormat df;
	
	public NewExpense(){
		this.DBint = new DBInteract();
		this.date = new Date();
		this.df = new SimpleDateFormat();
	}
		
	public void createExpense(String eName, double eAmount, String eCat, String eType, String eComment){
		String sqlNewExpense;
		String name = eName;
		double amount =  eAmount;
		String category = eCat;
		String type = eType;
		String comment = eComment;
		df = new SimpleDateFormat("yyyy-MM-dd");
		
		//format date and time
		//df.format(date);
		//tf.format(time);
		
		sqlNewExpense = "INSERT INTO EXPENSES"
				+ "(ExpenseName, ExpenseAmount, ExpenseCat, ExpenseType, ExpenseComm, ExpenseDate)"
				+ "VALUES (" + "'" + name + "'," + "'" + amount + "'," + "'" + category + "'," + "'" + type + "'," + "'" + comment + "'," + "'" + df.format(date) + "'" + ")"; 
		
		try{
			DBint.dbStmt().executeUpdate(sqlNewExpense);
			System.out.println("db Insert Successful");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
		}
	}
}//end of NewUser

