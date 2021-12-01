package controller;

import java.util.ArrayList;

import gui.manager.TableManager;
import model.Profesor;
import model.manager.DataManager;

class ProfesorController {
	static boolean create(String[] arr, ArrayList<String> messages)
	{
		Profesor pr = DataManager.createProfesor(arr, messages);
		if(pr == null) return false;
		TableManager.addRow(1, pr.getTableData());
		return true;
	}
	
	static String[] getData(int index)
	{
		String[] data = DataManager.getProfesorData(index);
		return data;
	}
	
	static Profesor get(int index)
	{
		return DataManager.getProfesori().get(index);
	}
	
	static boolean edit(String[] arr, int index, ArrayList<String> messages)
	{
		Profesor oldProfesor = DataManager.getProfesori().get(index);
		Profesor pr = DataManager.createProfesor(arr, messages, index);
		if(pr == null) return false;
		
		pr.setPredmeti(oldProfesor.getPredmeti());
		
		TableManager.remove(1, index);
		TableManager.insertRow(1, pr.getTableData(), index);
		DataManager.deleteProfesor(index+1);
		return true;
	}
	
	static void delete(int index)
	{
		TableManager.remove(1, index);
		DataManager.deleteProfesor(index);
	}
}
