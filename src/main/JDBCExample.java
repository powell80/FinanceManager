package main;

//STEP 1. Import required packages
import java.sql.*;

public class JDBCExample {

 
 public static void main(String[] args) {

	 try{
		 //1. get a connection to database
		 Connection myConn = DriverManager.getConnection("");
		 //2. create a statment
		 
		 
	 }
	 catch (Exception exc){
		 exc.printStackTrace();
	 }
 }
}