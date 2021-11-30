package app;

import gui.MainWindow;
import gui.table.TableManager;
import model.DataManager;
import model.structure.Ocena;
import model.structure.Predmet;
import model.structure.Student;

public class Main {
	static MainWindow gui = MainWindow.getInstance();
	
	public static void main(String[] args) 
	{
		createExamples();
		
		TableManager.add(DataManager.getStudenti());
		TableManager.add(DataManager.getProfesori());
		TableManager.add(DataManager.getPredmeti());
		
		gui.setVisible(true);
	}
	
	static void createExamples()
	{
		
		Student rade = DataManager.createStudent(new String[] {"Rade", 	"Stojanovic", 	"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA138/2019", "2019", 	"2", "0"}, null);
		DataManager.createStudent(new String[] {"Damjan", 	"Dimitrijevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA115/2019", "2019" , 	"2", "0"}, null);
		DataManager.createStudent(new String[] {"Uros", 	"Jokovic", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA119/2019", "2019" ,	"2", "0"}, null);
		DataManager.createStudent(new String[] {"Luka", 	"Pikula", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA146/2019", "2019" , 	"2", "0"}, null);

		DataManager.createProfesor(new String[] {"Nebojsa", "Ralevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "u, 1, g, d", "0", "Doktor", "Redovni profesor", "0"}, null);			

		Predmet analiza = DataManager.createPredmet(new String[] {"12345", 	"Matematicka Analiza 1", "0", "0", "9"}, null);
		Predmet bp = DataManager.createPredmet(new String[] {"123456", 	"Baze Podataka 1", 		 "0", "2", "8"}, null);
		
		rade.addPolozeniIspit(new Ocena(rade, analiza, 8));
		rade.addPolozeniIspit(new Ocena(rade, bp, 7));
	}
	
}








