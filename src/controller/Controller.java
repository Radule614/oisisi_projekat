package controller;

import java.util.ArrayList;

import gui.MainWindow;
import gui.manager.TableManager;
import model.*;
import model.data.Data;

public class Controller {
	public static boolean 				createStudent		(String[] arr, ArrayList<String> messages) {return StudentController.create(arr, messages);}
	public static boolean 				createProfesor		(String[] arr, ArrayList<String> messages) {return ProfesorController.create(arr, messages);}
	public static boolean 				createPredmet		(String[] arr, ArrayList<String> messages) {return PredmetController.create(arr, messages);}
	
	public static String[] 				getStudentData		(int index) {return StudentController.getData(index);}
	public static String[] 				getProfesorData		(int index) {return ProfesorController.getData(index);}
	public static String[] 				getPredmetData		(int index) {return PredmetController.getData(index);}
	
	public static Student 				getStudent			(int index) {return StudentController.get(index);}
	public static Profesor				getProfesor			(int index) {return ProfesorController.get(index);}
	public static Predmet 				getPredmet			(int index) {return PredmetController.get(index);}
	
	public static boolean 				editStudent			(String[] arr, int index, ArrayList<String> messages) {return StudentController.edit(arr, index, messages);}
	public static boolean 				editProfesor		(String[] arr, int index, ArrayList<String> messages) {return ProfesorController.edit(arr, index, messages);}
	public static boolean 				editPredmet			(String[] arr, int index, ArrayList<String> messages) {return PredmetController.edit(arr, index, messages);}

	public static void 					deleteStudent		(int index) {StudentController.delete(index);}
	public static void 					deleteProfesor		(int index) {ProfesorController.delete(index);}
	public static void 					deletePredmet		(int index) {PredmetController.delete(index);}
	
	public static ArrayList<String[]> 	getPolozeniIspiti	(int index) {return StudentController.getPolozeniIspiti(index);}
	public static ArrayList<String[]> 	getNepolozeniIspiti	(int index) {return StudentController.getNepolozeniIspiti(index);}
	
	public static double 				getProsek			(int index) {return StudentController.getProsek(index);}
	public static int 					getTotalESPB		(int index) {return StudentController.getTotalESPB(index);}
	public static void 					removeStudentGrade	(int studentIndex, int gradeIndex) {StudentController.removeGrade(studentIndex, gradeIndex);}
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static MainWindow initApp()
	{
		MainWindow app = MainWindow.getInstance();
		
		initData();
		initTables();
		
		return app;
	}
	
	public static void initTables()
	{
		TableManager.addRows(0, Data.studentiToTableDataArray());
		TableManager.addRows(1, Data.profesoriToTableDataArray());
		TableManager.addRows(2, Data.predmetiToTableDataArray());
	}
	
	public static void initData()
	{
		Student rade = Data.createStudent(new String[] {"Rade", 	"Stojanovic", 	"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA138/2019", "2019", 	"2", "0"}, null);
		Data.createStudent(new String[] {"Damjan", 	"Dimitrijevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA115/2019", "2019" , 	"2", "0"}, null);
		Data.createStudent(new String[] {"Uros", 	"Jokovic", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA119/2019", "2019" ,	"2", "0"}, null);
		Data.createStudent(new String[] {"Luka", 	"Pikula", 		"01-01-2000", "u, 1, g, d", "0", "email@email.com", "RA146/2019", "2019" , 	"2", "0"}, null);

		Data.createProfesor(new String[] {"Nebojsa", "Ralevic", "01-01-2000", "u, 1, g, d", "0", "email@email.com", "u, 1, g, d", "0", "Doktor", "Redovni profesor", "0"}, null);			

		Predmet an = Data.createPredmet(new String[] {"1", 	"Matematicka Analiza 1", 	"0", "0", "9"}, null);
		Predmet bp = Data.createPredmet(new String[] {"12", 	"Baze Podataka 1", 		 	"0", "2", "8"}, null);
		Predmet ar = Data.createPredmet(new String[] {"123", "Arhitektura Racunara", 	"0", "0", "9"}, null);
		Predmet en = Data.createPredmet(new String[] {"1234", "Operativni sistemi", 		"0", "0", "8"}, null);
		
		
		rade.addPolozeniIspit	(new Ocena(rade, an, 8));
		rade.addPolozeniIspit	(new Ocena(rade, bp, 7));
		rade.addNepolozeniIspit	(new Ocena(rade, ar));
		rade.addNepolozeniIspit	(new Ocena(rade, en));
		
	}
}
	
	














