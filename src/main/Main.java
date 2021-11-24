package main;

import data.DataManager;
import gui.MainWindow;

public class Main {
	static MainWindow gui = new MainWindow();
	
	public static void main(String[] args) 
	{
		createExamples();
		
		Events.gui = gui;
		
		gui.addToTable(DataManager.getStudenti());
		gui.addToTable(DataManager.getProfesori());
		gui.addToTable(DataManager.getPredmeti());
		
		gui.setVisible(true);
	}
	
	static void createExamples()
	{
		for(int i = 0; i < 7; ++i)
		{
			DataManager.createStudent(new String[] {	"Rade", 	"Stojanovic", 	"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA138/2019", "2019" , "9.2", 	"2", "0"});
			DataManager.createStudent(new String[] {	"Damjan", 	"Dimitrijevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA115/2019", "2019" , "8.67", "2", "0"});
			DataManager.createStudent(new String[] {	"Uros", 	"Jokovic", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA119/2019", "2019" , "9.0", 	"2", "0"});
			DataManager.createStudent(new String[] {	"Luka", 	"Pikula", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA146/2019", "2019" , "10.0", "2", "0"});
		}
		
		DataManager.createProfesor(new String[] {"Nebojsa", "Ralevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "u, 1, g, d", "0", "Doktor", "Redovni profesor", "0"});
		
		DataManager.createPredmet(new String[] {"12345", 	"Matematicka Analiza 1", "0", "0", "9"});
		DataManager.createPredmet(new String[] {"123456", 	"Baze Podataka 1", 		 "0", "2", "8"});
	}
	
}








