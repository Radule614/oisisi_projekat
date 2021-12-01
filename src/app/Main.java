package app;

import controller.Controller;
import gui.MainWindow;

public class Main {
	static MainWindow app;
	
	public static void main(String[] args) 
	{
		app = Controller.initApp();
		
		app.setVisible(true);
	}
}








