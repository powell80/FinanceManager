package main;

import java.awt.Graphics;
import javax.swing.JPanel;
import org.joda.time.DateTime;

public class CalDay extends JPanel { 

	private static final long serialVersionUID = 1L;
	private int month;
	private int daysInMonth;
	private int day;
	private int year;

	public  CalDay(int month, DateTime dt){
		this.month = month;
		this.day = dt.getDayOfMonth();
		this.daysInMonth = dt.dayOfMonth().getMaximumValue();
	}
	
	public void getDayInfo(){
		
		
		
	}
}
