package main;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
//import java.util.Date;

public class CalInfo {

	private Date date;
	private int day;
	private int week;
	private int month, year;
	public int days_in_month;
	Calendar cal;
	
	public CalInfo(){
		java.util.Date juDate = new Date();
		DateTime DateT = new DateTime(juDate);
	}
	
	public int getDaysInMonth(){
		DateTime dt = new DateTime();
		int month = dt.getMonthOfYear();
		
		
		days_in_month = cal.getActualMaximum(month);
		
		return days_in_month;
	}
	
	public int getDay(){
		
		
		return 0;
	}
	
	public int getMonth(){
		int month;
		month = cal.get(Calendar.MONTH);
		
		return month;
	}
	
	public int getYear(){
		
		
		return 0;
	}
}
