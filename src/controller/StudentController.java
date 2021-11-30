package controller;

import java.util.ArrayList;

import gui.table.TableManager;
import model.DataManager;
import model.structure.Ocena;
import model.structure.Student;

class StudentController {
	static boolean create(String[] arr, ArrayList<String> messages)
	{
		Student st = DataManager.createStudent(arr, messages);
		if(st == null) return false;
		TableManager.add(st);
		return true;
	}
	
	static String[] getData(int index)
	{
		String[] data = DataManager.getStudentData(index);
		return data;
	}
	
	static Student get(int index)
	{
		return DataManager.getStudenti().get(index);
	}
	
	static boolean edit(String[] arr, int index, ArrayList<String> messages)
	{
		Student oldStudent = DataManager.getStudenti().get(index);
		Student st = DataManager.createStudent(arr, messages, index);
		if(st == null) return false;
		
		st.setPolozeniIspiti(oldStudent.getPolozeniIspiti());
		st.setNepolozeniIspiti(oldStudent.getNepolozeniIspiti());
		st.setProsek(oldStudent.getProsek());
		
		TableManager.remove(0, index);
		TableManager.add(st, index);
		DataManager.deleteStudent(index+1);
		return true;
	}
	static void delete(int index)
	{
		TableManager.remove(0, index);
		DataManager.deleteStudent(index);
	}
	
	static ArrayList<String[]> getPolozeniIspiti(int index)
	{
		return DataManager.getPolozeniIspiti(index);
	}
	
	static double getProsek(int index)
	{
		return DataManager.getStudenti().get(index).getProsek();
	}
	
	static int getTotalESPB(int index)
	{
		ArrayList<Ocena> ispiti = DataManager.getStudenti().get(index).getPolozeniIspiti();
		int ESPB = 0;
		for(Ocena o: ispiti)
		{
			ESPB += o.getPredmet().getESPB();
		}
		return ESPB;
	}
	
	
}











