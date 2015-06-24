package main;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import org.joda.time.DateTime;

public class CalDay extends JPanel { 

	private static final long serialVersionUID = 1L;
	private int month;
	private int daysInMonth;
	private int day;
	private int year;
	JPanel panel;
	
	
	public CalDay(DateTime dt, int width, int height){
		panel.setSize(width, height);
		panel.setLayout(new GridLayout());
		add(panel);
		
		
	}
	
	public void getDayInfo(DateTime dt){
		int currMonth = dt.getMonthOfYear();
		
		
		
	}
	
	
	
	public int getMonth(DateTime dt){
		int month = 0;
		
		
		
		return month;
	}
	
	public void paint(Graphics g){
		
	}
}
