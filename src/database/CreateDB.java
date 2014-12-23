package database;

//STEP 1. Import required packages
import java.sql.*;
import java.math.*;

public class CreateDB {

	private static final String DRIVER = "org.h2.Driver";
	private static final String DBNAME = "FINANCE";
	private static final String DB_URL = "jdbc:h2:" + DBNAME;
	private static final String USER = "sa";
	private static final String ATTRIBUTE = "";
	
	public void WriteDB() throws SQLException{
		//database name and connection
		Connection conn = null;
		Statement stmt = null;

		
		//sql statements to create database
		String sqlTableUSER = 
				"CREATE TABLE USER" + 
				"(userid VARCHAR(30) not NULL," +
				"first VARCHAR(100)," +
				"last VARCHAR(100)," +
				"age INTEGER, " +
				"anincome INTEGER)";
		
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

		}catch (SQLException se) {
			if (se.getErrorCode() == 42101){
				System.out.println(se.getMessage());
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
}//end class

