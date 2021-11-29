package data;

import java.util.ArrayList;

import model.*;
import utility.Utility;

public class DataManager {
	static ArrayList<Student> studenti = new ArrayList<Student>();
	static ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	static ArrayList<Predmet> predmeti = new ArrayList<Predmet>();

	public static Student createStudent(String[] arr, ArrayList<String> messages, int index)
	{
		arr = Utility.trimEach(arr);
		if(!Student.isValidData(arr, messages)) return null;
		if(messages != null && DataManager.studentExists(arr[6], index))
		{
			messages.add("Student sa indeksom " + arr[6] + " već postoji.");
			return null;
		}
		Student st = new Student(arr);
		studenti.add(index, st);
		return st;
	}
	
	public static Student createStudent(String[] arr, ArrayList<String> messages)
	{
		return createStudent(arr, messages, studenti.size());
	}
	
	public static Profesor createProfesor(String[] arr, ArrayList<String> messages, int index)
	{
		arr = Utility.trimEach(arr);
		if(!Profesor.isValidData(arr, messages)) return null;
		if(messages != null && DataManager.profesorExists(Utility.parseInt(arr[7]), index))
		{
			messages.add("Profesor sa brojem lične karte " + arr[7] + " već postoji.");
			return null;
		}
		Profesor pf = new Profesor(arr);
		profesori.add(index, pf);
		return pf;
	}
	
	public static Profesor createProfesor(String[] arr, ArrayList<String> messages)
	{
		return createProfesor(arr, messages, profesori.size());
	}
	
	public static Predmet createPredmet(String[] arr, ArrayList<String> messages, int index)
	{
		arr = Utility.trimEach(arr);
		if(!Predmet.isValidData(arr, messages)) return null;
		if(messages != null && DataManager.predmetExists(Utility.parseInt(arr[0]), index))
		{
			messages.add("Predmet sa šifrom " + arr[0] + " već postoji.");
			return null;
		}
		Predmet pr = new Predmet(arr);
		predmeti.add(index, pr);
		return pr;
	}
	
	public static Predmet createPredmet(String[] arr, ArrayList<String> messages)
	{
		return createPredmet(arr, messages, predmeti.size());
	}
	
	public static void deleteStudent(int index)
	{
		studenti.remove(index);
	}
	
	public static void deleteProfesor(int index)
	{
		profesori.remove(index);
	}
	
	public static void deletePredmet(int index)
	{
		predmeti.remove(index);
	}
	
	public static String[] getStudentData(int index)
	{
		Student st = studenti.get(index);
		String[] data = st.toStringArray();
		
		return data;
	}
	
	public static String[] getProfesorData(int index)
	{
		Profesor pr = profesori.get(index);
		String[] data = pr.toStringArray();
		
		return data;
	}
	
	public static String[] getPredmetData(int index)
	{
		Predmet pr = predmeti.get(index);
		String[] data = pr.toStringArray();
		
		return data;
	}

	public static ArrayList<Student> getStudenti() {
		return studenti;
	}

	public static ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public static ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public static boolean studentExists(String key)
	{
		return DataManager.studentExists(key, -1);
	}
	
	public static boolean profesorExists(int key)
	{
		return DataManager.profesorExists(key, -1);
	}
	
	public static boolean predmetExists(int key)
	{
		return DataManager.predmetExists(key, -1);
	}
	
	public static boolean studentExists(String key, int index)
	{
		for(int i = 0; i < studenti.size(); ++i)
		{
			if(index == i) continue;
			if(studenti.get(i).getBrojIndeksa().equals(key)) return true;
		}
		return false;
	}
	
	public static boolean profesorExists(int key, int index)
	{
		for(int i = 0; i < profesori.size(); ++i)
		{
			if(index == i) continue;
			if(profesori.get(i).getLicnaKarta() == key) return true;
		}
		return false;
	}
	public static boolean predmetExists(int key, int index)
	{
		for(int i = 0; i < predmeti.size(); ++i)
		{
			if(index == i) continue;
			if(predmeti.get(i).getSifra() == key) return true;
		}
		return false;
	}
	
	
}















