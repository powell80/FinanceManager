package main;

import gui.LoginWindow;
import gui.MainWindow;
import gui.NewUserWindow;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import database.CreateDB;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateDB db = new CreateDB();
					MainWindow window = new MainWindow();
					LoginWindow login = new LoginWindow();
					NewUserWindow nUser = new NewUserWindow();
					db.WriteDB();
				//	login.frmLogin.setVisible(true);
				//	window.frmFinanceManager.setVisible(true);
					nUser.frmCreateUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
