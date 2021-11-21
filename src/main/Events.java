package main;

import gui.MainWindow;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Events {
	public static MainWindow gui;
	public static DataManager dm;
	
	public static void createStudent(String[] arr)
	{	
		Student st = dm.createStudent(arr);
		
		gui.addToTable(st);
	}
	
	public static void createProfesor(String[] arr)
	{
		Profesor pr = dm.createProfesor(arr);
		
		gui.addToTable(pr);
	}
	
	public static void createPredmet(String[] arr)
	{
		Predmet pr = dm.createPredmet(arr);
		
		gui.addToTable(pr);
	}
	
	public static String[] getStudentData(int index)
	{
		String[] data = dm.getStudentData(index);
		
		return data;
	}
	
	public static String[] getProfesorData(int index)
	{
		String[] data = dm.getProfesorData(index);
		
		return data;
	}
	
	public static String[] getPredmetData(int index)
	{
		String[] data = dm.getPredmetData(index);
		
		return data;
	}
}














