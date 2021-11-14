package main;

import gui.MainWindow;

public class Main {
	static MainWindow gui = new MainWindow();
	static DataManager dm = new DataManager();
	
	public static void main(String[] args) 
	{
		createExamples();
		
		Events.gui = gui;
		Events.dm = dm;
		
		gui.addToTable(dm.getStudenti());
		gui.addToTable(dm.getProfesori());
		gui.addToTable(dm.getPredmeti());
		
		gui.setVisible(true);
	}
	
	static void createExamples()
	{
		for(int i = 0; i < 7; ++i)
		{
			dm.createStudent(new String[] {	"Rade", 	"Stojanovic", 	"01/01/2000", "0", "0", "0", "RA138/2019", "0" , "9.2", 	"3", "0"});
			dm.createStudent(new String[] {	"Damjan", 	"Dimitrijevic", "01/01/2000", "0", "0", "0", "RA115/2019", "0" , "8.67", "3", "0"});
			dm.createStudent(new String[] {	"Uros", 	"Jokovic", 		"01/01/2000", "0", "0", "0", "RA119/2019", "0" , "9.0", 	"3", "0"});
			dm.createStudent(new String[] {	"Luka", 	"Pikula", 		"01/01/2000", "0", "0", "0", "RA146/2019", "0" , "10.0", "3", "0"});
		}
		
		dm.createProfesor(new String[] {"Nebojsa", "Ralevic", "01/01/2000", "0", "0", "0", "0", "0", "Doktor", "Redovni profesor", "0"});
		
		dm.createPredmet(new String[] {"12345", 	"Matematicka Analiza 1", "0", "1", "9"});
		dm.createPredmet(new String[] {"123456", 	"Baze Podataka 1", 		 "0", "3", "8"});
	}
	
}








