package controller;

import java.util.ArrayList;

import gui.manager.TableManager;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.data.Data;

class StudentController {
	static boolean create(String[] arr, ArrayList<String> messages)
	{
		Student st = Data.createStudent(arr, messages);
		if(st == null) return false;
		TableManager.addRow(0, st.getTableData());
		return true;
	}
	
	static String[] getData(int index)
	{
		String[] data = Data.getStudentData(index);
		return data;
	}
	
	static Student get(int index)
	{
		return Data.getStudenti().get(index);
	}
	
	static boolean edit(String[] arr, int index, ArrayList<String> messages)
	{
		Student oldStudent = Data.getStudenti().get(index);
		Student st = Data.createStudent(arr, messages, index);
		if(st == null) return false;
		
		st.setPolozeniIspiti(oldStudent.getPolozeniIspiti());
		st.setNepolozeniIspiti(oldStudent.getNepolozeniIspiti());
		st.setProsek(oldStudent.getProsek());
		
		TableManager.remove(0, index);
		TableManager.insertRow(0, st.getTableData(), index);
		Data.deleteStudent(index+1);
		return true;
	}
	static void delete(int index)
	{
		TableManager.remove(0, index);
		Data.deleteStudent(index);
	}
	
	static ArrayList<String[]> getPolozeniIspiti(int index)
	{
		return Data.getPolozeniIspiti(index);
	}
	
	static ArrayList<String[]> getNepolozeniIspiti(int index)
	{
		return Data.getNepolozeniIspiti(index);
	}
	
	static double getProsek(int index)
	{
		return Data.getStudenti().get(index).getProsek();
	}
	
	static int getTotalESPB(int index)
	{
		ArrayList<Ocena> ispiti = Data.getStudenti().get(index).getPolozeniIspiti();
		int ESPB = 0;
		for(Ocena o: ispiti)
		{
			ESPB += o.getPredmet().getESPB();
		}
		return ESPB;
	}
	
	static void removeGrade(int studentIndex, int gradeIndex)
	{
		Student st = Data.getStudenti().get(studentIndex);
		ArrayList<Ocena> polozeniIspiti = st.getPolozeniIspiti();
		ArrayList<Ocena> nepolozeniIspiti = st.getNepolozeniIspiti();
		Ocena o = polozeniIspiti.get(gradeIndex);
		nepolozeniIspiti.add(o);
		polozeniIspiti.remove(gradeIndex);
		st.calculateProsek();
		TableManager.remove(0, studentIndex);
		TableManager.insertRow(0, st.getTableData(), studentIndex);
	}
	
	static void addToNepolozeni(int studentIndex, int predmetIndex)
	{
		Student st = Data.getStudenti().get(studentIndex);
		Predmet pr = Data.getPredmeti().get(predmetIndex);
		Ocena o = new Ocena(st, pr);
		st.getNepolozeniIspiti().add(o);
	}
}











