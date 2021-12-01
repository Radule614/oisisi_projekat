package controller;

import java.util.ArrayList;

import gui.manager.TableManager;
import model.Ocena;
import model.Student;
import model.manager.DataManager;

class StudentController {
	static boolean create(String[] arr, ArrayList<String> messages)
	{
		Student st = DataManager.createStudent(arr, messages);
		if(st == null) return false;
		TableManager.addRow(0, st.getTableData());
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
		TableManager.insertRow(0, st.getTableData(), index);
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
	
	static ArrayList<String[]> getNepolozeniIspiti(int index)
	{
		return DataManager.getNepolozeniIspiti(index);
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
	
	static void removeGrade(int studentIndex, int gradeIndex)
	{
		Student st = DataManager.getStudenti().get(studentIndex);
		ArrayList<Ocena> ispiti = st.getPolozeniIspiti();
		ispiti.remove(gradeIndex);
		st.calculateProsek();
		TableManager.remove(0, studentIndex);
		TableManager.insertRow(0, st.getTableData(), studentIndex);
	}
}











