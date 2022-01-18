package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import gui.MainWindow;
import gui.manager.TableManager;
import model.data.Data;

public class Controller {
	public static StudentController student = StudentController.getInstance();
    public static ProfesorController profesor = ProfesorController.getInstance();
    public static PredmetController predmet = PredmetController.getInstance();

    public static HashMap<Integer, String> 	getEligiblePredmeti		(int studentIndex) {return Data.getEligiblePredmeti(studentIndex);}

    public static HashMap<Integer, String> 	getEligiblePredmetiForProfesor		(int profesorIndex) {return Data.getEligiblePredmetiForProfesor(profesorIndex);}
    ///////////////////////////////////////////////////////////////////////

    public static MainWindow initApp()
    {
        MainWindow app = MainWindow.getInstance();

        if(!Data.getSavedData())
            initData();

        initTables();
        app.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Data.saveData();
            }
        });
        return app;
    }

    public static void initTables()
    {
        TableManager.addRows(0, Data.student.toTableDataArray());
        TableManager.addRows(1, Data.profesor.toTableDataArray());
        TableManager.addRows(2, Data.predmet.toTableDataArray());
    }

    public static void initData()
    {
    	
        Data.student.create(new String[] {"Rade", 	"Stojanovic", 	"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA138/2019", "2019", 	"2", "0"}, null);
        Data.student.create(new String[] {"Damjan", "Dimitrijevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA115/2019", "2019" , 	"2", "0"}, null);
        Data.student.create(new String[] {"Uros", 	"Jokovic", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA119/2019", "2019" ,	"2", "0"}, null);
        Data.student.create(new String[] {"Luka", 	"Pikula", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA146/2019", "2019" , 	"2", "0"}, null);

        Data.profesor.create(new String[] {"Nebojsa", "Ralevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "u, 1, g, d", "0", "Doktor", "Redovni profesor", "0"}, null);
        
        Data.predmet.create(new String[] {"1", 		"Matematicka Analiza 1", 	"0", "0", "9"}, null);
        Data.predmet.create(new String[] {"12", 	"Baze Podataka 1", 		    "0", "3", "8"}, null);
        Data.predmet.create(new String[] {"123", 	"Arhitektura Racunara", 	"0", "0", "9"}, null);
        Data.predmet.create(new String[] {"1234", 	"Operativni sistemi", 		"0", "0", "8"}, null);
        Data.predmet.create(new String[] {"alg", 	"Algebra", 					"0", "2", "5"}, null);
        Data.predmet.create(new String[] {"oi123", 	"oisisi", 					"0", "1", "6"}, null);
    }
    
}
	
	














