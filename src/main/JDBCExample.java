package main;

//STEP 1. Import required packages
import java.sql.*;

import org.h2.*;

public class JDBCExample {

	public static final String DRIVER = "org.h2.Driver";
	public static final String DBNAME = "FINANCE";
	
	public void dbWrite(Statement stmt) throws SQLException{
		stmt.executeUpdate( "CREATE TABLE table1 ( user varchar(50) )" );
		stmt.executeUpdate("INSERT INTO table1 (user) VALUES ('Claudio')");
		ResultSet rs = stmt.executeQuery("SELECT * FROM table1");
		while(rs.next()){
			String name = rs.getString("user");
			System.out.println(name);
			}
	}
	
	@SuppressWarnings("unused")
	public void createDB() {
	 try{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection("jdbc:h2:"+ DBNAME, DBNAME, "");
		Statement stmt = conn.createStatement();
		if (conn == null){
			dbWrite(stmt);
		}
		else if(conn.isValid(1))
		{
			System.out.println("Database Loaded Successfully");
		}else
		
		stmt.close();
		conn.close();
		 
	 }
	 catch (Exception exc){
		 exc.printStackTrace();
	 }
 }
}