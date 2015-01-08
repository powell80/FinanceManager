package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteract {
	private static final String DB_URL = DBInterface.DB_URL;
	private static final String USER = DBInterface.USER;
	private static final String ATTRIBUTE = DBInterface.ATTRIBUTE;
	private Connection conn = null;
	private Statement stmt = null;

	public DBInteract(){
		
	}
	
		public void dbRemove(){
			
		}
		
		public ResultSet dbSelect(String sqlStmt){
			ResultSet rs = null;
			
			try {
				rs = dbStmt().executeQuery(sqlStmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
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
