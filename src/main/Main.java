package main;

import gui.MainWindow;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import database.DBInterface;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		final MainWindow mainWin = new MainWindow();
		final DBInterface db = new DBInterface();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					db.WriteDB();
					mainWin.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
