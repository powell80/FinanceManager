package main;

import java.util.Date;
import org.joda.time.DateTime;
//import java.util.Date;

public class CalInfo {

	private int days_in_month, month;
	private Date juDate;
	private DateTime dt; 
	
	public CalInfo(){
		this.dt = new DateTime(juDate);
	}
	
	public int getDaysInMonth(){
		dt = new DateTime(getYear(), getMonth(), 14,12,0,0,000);
		days_in_month = dt.dayOfMonth().getMaximumValue();
		return days_in_month;
	}
	
	public int getDay(){
		
		
		return 0;
	}
	
	public int getMonth(){
		month = dt.getMonthOfYear();
		return month;
	}
	
	public int getYear(){
		dt = new DateTime();
		int year = dt.getYear();
		
		return year;
	}
}
