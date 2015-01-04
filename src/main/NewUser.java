package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBInterface;

public class NewUser {
	
	DBInterface DBinter =  new DBInterface();
	
	public NewUser(){
		
	}
		
	public void createUser(String first, String last){
		String sqlNewUser;
		String firstName = first;
		String lastName = last;
	
		sqlNewUser = "INSERT INTO USER"
				+ "(userFirstName, userLastName)"
				+ "VALUES (" + "'" + firstName + "'," + "'" + lastName + "'" + ")"; 
		
		try{
			DBinter.dbConnect().executeUpdate(sqlNewUser);
			//	main.initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
	}
}//end of NewUser

