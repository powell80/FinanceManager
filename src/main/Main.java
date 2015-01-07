package main;

import gui.MainWindow;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import database.DBInterface;

public class Main {
	static MainWindow mainWin = new MainWindow();

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					DBInterface db = new DBInterface();
					db.WriteDB();
					mainWin.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
