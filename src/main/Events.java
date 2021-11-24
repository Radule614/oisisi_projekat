package main;

import java.util.ArrayList;

import data.DataManager;
import gui.MainWindow;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Events {
	public static MainWindow gui;
	
	public static boolean createStudent(String[] arr, ArrayList<String> messages)
	{	
		Student st = DataManager.createStudent(arr, messages);
		
		if(st == null) return false;
		
		gui.addToTable(st);
		return true;
	}
	
	public static boolean createProfesor(String[] arr, ArrayList<String> messages)
	{
		Profesor pr = DataManager.createProfesor(arr, messages);
		
		if(pr == null) return false;
		
		gui.addToTable(pr);
		return true;
	}
	
	public static boolean createPredmet(String[] arr, ArrayList<String> messages)
	{
		Predmet pr = DataManager.createPredmet(arr, messages);
		
		if(pr == null) return false;
		
		gui.addToTable(pr);
		return true;
	}
	
	public static String[] getStudentData(int index)
	{
		String[] data = DataManager.getStudentData(index);
		
		return data;
	}
	
	public static String[] getProfesorData(int index)
	{
		String[] data = DataManager.getProfesorData(index);
		
		return data;
	}
	
	public static String[] getPredmetData(int index)
	{
		String[] data = DataManager.getPredmetData(index);
		
		return data;
	}
}














