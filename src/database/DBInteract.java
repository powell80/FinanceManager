package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteract {
	private static final String DBNAME = "FINANCE";
	private static final String DB_URL = "jdbc:h2:" + DBNAME;
	private static final String USER = "sa";
	private static final String ATTRIBUTE = "";
	Connection conn = null;
	public Statement stmt = null;

	public DBInteract(){
		
	}
	public void connect(){
		
		try {
		System.out.println("Creating new Database...");
		conn = DriverManager.getConnection(DB_URL, USER, ATTRIBUTE);
		stmt = conn.createStatement();
		//create database and connect
		System.out.println("Database " + DBNAME + " Connection established");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
