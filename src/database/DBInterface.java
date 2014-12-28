package database;

import gui.LoginWindow;
import gui.NewUserWindow;


//STEP 1. Import required packages
import java.sql.*;

public class DBInterface {

	private static final String DRIVER = "org.h2.Driver";
	private static final String DBNAME = "FINANCE";
	private static final String DB_URL = "jdbc:h2:" + DBNAME;
	private static final String USER = "sa";
	private static final String ATTRIBUTE = "";
	Connection conn = null;
	Statement stmt = null;
	
	public void WriteDB() throws SQLException{
		//database name and connection
		//Connection conn = null;
		//Statement stmt = null;
		LoginWindow login = new LoginWindow();
		NewUserWindow nUser = new NewUserWindow();

		
		//sql statements to create database
		String sqlTableUSER = 
				"CREATE TABLE USER" + 
				"(userid VARCHAR(30) not NULL," +
				"first VARCHAR(100)," +
				"last VARCHAR(100)," +
				"pass VARCHAR(30) not NULL,)";
		
		String sqlTableEXPENDETURES = 
				"CREATE TABLE EXPENDETURES" +
				"(";
		
		
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
			stmt = conn.createStatement();
			//create database and connect
			System.out.println("Database " + DBNAME + " Created Successfully");
	
			stmt.executeUpdate(sqlTableUSER);
			System.out.println("Created table in Database " + DBNAME);
			nUser.initialize();

		}catch (SQLException se) {
			if (se.getErrorCode() == 42101){
				System.out.println(se.getMessage());
				//login.initialize();
			}else
            //Handle errors for JDBC
            se.printStackTrace();
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
	
	public void Insertstmt(String sqlStmt){
		
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
		
		
	}
}//end class

