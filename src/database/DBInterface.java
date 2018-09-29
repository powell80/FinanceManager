package database;

import java.sql.*;

public class DBInterface {

	public static final String DRIVER = "org.h2.Driver";
	public static final String DBNAME = "FINANCE";
	public static final String DB_URL = "jdbc:h2:" + DBNAME;
	public static final String USER = "sa";
	public static final String ATTRIBUTE = "";
	private Connection conn = null;
	private Statement stmt = null;
	//private Array []stmtArray;
	
	
	public void WriteDB() throws SQLException{
		

		//sql statements to create database
		String sqlTableEXPENSES = 
				"CREATE TABLE EXPENSES" + 
				"(ExpenseId int NOT NULL AUTO_INCREMENT," +
				"ExpenseName VARCHAR(100) not NULL," +
				"ExpenseAmount DECIMAL(10,2) not NULL," + 
				"ExpenseCat VARCHAR(50) not NULL," + 
				"ExpenseType VARCHAR(50) not NULL," + 
				"ExpenseComm VARCHAR(250) not NULL," +
				"ExpenseDate TIMESTAMP," + 
				"CONSTRAINT PKEXPENSES PRIMARY KEY (ExpenseId))";
		
		//sql statements to create database
		String sqlTableINCOME = 
				"CREATE TABLE INCOME" + 
				"(IncomeId int NOT NULL AUTO_INCREMENT," +
				"IncomeName VARCHAR(100) not NULL," +
				"IncomeAmount DECIMAL(10,2) not NULL," + 
				"IncomeCat VARCHAR(50) not NULL," + 
				"IncomeType VARCHAR(50) not NULL," + 
				"IncomeComm VARCHAR(250) not NULL," +
				"IncomeDate TIMESTAMP," + 
				"CONSTRAINT PKINCOME PRIMARY KEY (IncomeId))";
		
		String sqlTableDAILYEXPENSES = 
				"CREATE TABLE DAILYEXPENSES" +
				"( "
				+ "";
		
		String sqlTableWEEKLYEXPENSES = 
				"CREATE TABLE WEEKLYEXPENSES" +
				"( "
				+ "";
		
		String sqlTableMONTHLYEXPENSES= 
				"CREATE TABLE MONTHLYEXPENSES" +
				"( "
				+ "";
		
		
		try{
			//STEP 1: Register JDBC Driver
			Class.forName(DRIVER).newInstance();
			System.out.println("Loaded H2 Driver");
		}catch(Exception err){
			System.err.println("Unable to load embedded Driver");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		try{
			//STEP 2: Open a Connection
			System.out.println("Creating new Database...");
			conn = DriverManager.getConnection(DB_URL, USER, ATTRIBUTE);
			//create database and connect
			System.out.println("Database " + DBNAME + " Created Successfully");
	
			dbConnect().executeUpdate(sqlTableEXPENSES);
			dbConnect().executeUpdate(sqlTableINCOME);
			System.out.println("Created table in Database " + DBNAME);

		}catch (SQLException se) {
			if (se.getErrorCode() == 42101){
				System.out.println(se.getMessage());	
			}else
            //Handle errors for JDBC
				if(se.getErrorCode() == 42101){
					se.getErrorCode();
				}
				else{
					se.printStackTrace();
				}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt!=null)
                    conn.close();
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn!= null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    } // end main 
	
	public Statement dbConnect(){
		
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
}//end class

