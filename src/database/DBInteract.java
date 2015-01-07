package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteract {
	private static final String DB_URL = DBInterface.DB_URL;
	private static final String USER = DBInterface.USER;
	private static final String ATTRIBUTE = DBInterface.ATTRIBUTE;
	Connection conn = null;
	public Statement stmt = null;

	public DBInteract(){
		
	}
	
		public void dbRemove(){
			
		}
	
		public Statement dbStmt(){
			
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
	}
