package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

import gui.MainWindow;
import gui.manager.TableManager;
import model.Profesor;
import model.data.Data;
import model.reader.Reader;

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

        
        Data.getSavedData();
        
        app.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Data.saveData();
            }
        });
        
        
        //initData();
        
        initTables();
        
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
    	ArrayList<Integer> sefovi = new ArrayList<Integer>();
        
        Reader.readAdrese();
        Reader.readKatedre(sefovi);
        Reader.readStudenti();
        Reader.readProfesori();
        Reader.readPredmeti();
        Reader.readNepolozeni();
        Reader.readPolozeni();
        
		for(int i = 0; i < sefovi.size(); i++) {
			Profesor pr = Data.profesor.getAll().get(sefovi.get(i));
			
			Data.katedre.get(i).setSef(pr);
		}
    }
    
}
	
	














