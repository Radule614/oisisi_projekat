package main;

import java.util.ArrayList;

import data.DataManager;
import gui.table.TableManager;
import model.*;

public class Events {
	public static boolean createStudent(String[] arr, ArrayList<String> messages)
	{	
		Student st = DataManager.createStudent(arr, messages);
		
		if(st == null) return false;
		
		TableManager.add(st);
		return true;
	}
	
	public static boolean createProfesor(String[] arr, ArrayList<String> messages)
	{
		Profesor pr = DataManager.createProfesor(arr, messages);
		
		if(pr == null) return false;
		
		TableManager.add(pr);
		return true;
	}
	
	public static boolean createPredmet(String[] arr, ArrayList<String> messages)
	{
		Predmet pr = DataManager.createPredmet(arr, messages);
		
		if(pr == null) return false;
		
		TableManager.add(pr);
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
	
	public static boolean editStudent(String[] arr, int index, ArrayList<String> messages)
	{
		Student st = DataManager.createStudent(arr, messages, index);
		
		if(st == null) return false;
		TableManager.remove(0, index);
		TableManager.add(st, index);
		DataManager.deleteStudent(index+1);
		return true;
	}
	
	public static boolean editProfesor(String[] arr, int index, ArrayList<String> messages)
	{
		Profesor pr = DataManager.createProfesor(arr, messages, index);
		
		if(pr == null) return false;
		TableManager.remove(1, index);
		TableManager.add(pr, index);
		DataManager.deleteProfesor(index+1);
		return true;
	}
	
	public static boolean editPredmet(String[] arr, int index, ArrayList<String> messages)
	{
		Predmet pr = DataManager.createPredmet(arr, messages, index);
		
		if(pr == null) return false;
		TableManager.remove(2, index);
		TableManager.add(pr, index);
		DataManager.deletePredmet(index+1);
		return true;
	}
	
	public static void deleteStudent(int index)
	{
		TableManager.remove(0, index);
		DataManager.deleteStudent(index);
	}
	public static void deleteProfesor(int index)
	{
		TableManager.remove(1, index);
		DataManager.deleteProfesor(index);
	}
	public static void deletePredmet(int index)
	{
		TableManager.remove(2, index);
		DataManager.deletePredmet(index);
	}
}














