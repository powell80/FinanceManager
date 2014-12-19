package database;

//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreateDB {

	private static final String DRIVER = "org.h2.Driver";
	//private static final String PROTOCOL = "";
	private static final String DBNAME = "FINANCE";
	
	public void WriteDB() throws SQLException{
		//database name and connection
		String dbName = DBNAME;
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
				"";
		
		
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
			conn = DriverManager.getConnection("jdbc:h2:" + dbName, "sa", "");
			stmt = conn.createStatement();
			//create database and connect
			System.out.println("Database " + dbName + " Created Successfully");
	
			stmt.executeUpdate(sqlTableUSER);
			System.out.println("Created table in Database " + dbName);	

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

