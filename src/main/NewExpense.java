package main;

import java.sql.SQLException;

import database.DBInteract;
import database.DBInterface;

public class NewExpense {
	
	private DBInterface DBinter;
	private DBInteract DBint;
	
	public NewExpense(){
		this.DBinter = new DBInterface();
		this.DBint = new DBInteract();
	}
		
	public void createExpense(String eName, double eAmount, String eCat, String eType, String eComment){
		String sqlNewExpense;
		String name = eName;
		double amount =  eAmount;
		String category = eCat;
		String type = eType;
		String comment = eComment;
		
		
		sqlNewExpense = "INSERT INTO EXPENSES"
				+ "(ExpenseName, ExpenseAmount, ExpenseCat, ExpenseType, ExpenseComm)"
				+ "VALUES (" + "'" + name + "'," + "'" + amount + "'," + "'" + category + "'," + "'" + type + "'," + "'" + comment + "'" + ")"; 
		
		try{
			DBint.dbStmt().executeUpdate(sqlNewExpense);
			System.out.println("db Insert Successful");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
		}
	}
}//end of NewUser

