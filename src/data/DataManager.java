package data;

import java.util.ArrayList;

import model.*;

public class DataManager {
	static ArrayList<Student> studenti = new ArrayList<Student>();
	static ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	static ArrayList<Predmet> predmeti = new ArrayList<Predmet>();

	public static Student createStudent(String[] arr, ArrayList<String> messages)
	{
		if(!Student.isValidData(arr, messages))
		{
			return null;
		}
		Student st = new Student(arr);
		studenti.add(st);
		return st;
	}
	
	public static Student createStudent(String[] arr)
	{
		if(!Student.isValidData(arr, null))
		{
			return null;
		}
		Student st = new Student(arr);
		studenti.add(st);
		return st;
	}
	
	public static Profesor createProfesor(String[] arr, ArrayList<String> messages)
	{
		if(!Profesor.isValidData(arr, messages))
		{
			return null;
		}
		Profesor pf = new Profesor(arr);
		profesori.add(pf);
		return pf;
	}
	
	public static Profesor createProfesor(String[] arr)
	{
		if(!Profesor.isValidData(arr, null))
		{
			return null;
		}
		Profesor pf = new Profesor(arr);
		profesori.add(pf);
		return pf;
	}
	
	public static Predmet createPredmet(String[] arr, ArrayList<String> messages)
	{
		if(!Predmet.isValidData(arr, messages))
		{
			return null;
		}
		Predmet pr = new Predmet(arr);
		predmeti.add(pr);
		return pr;
	}
	
	public static Predmet createPredmet(String[] arr)
	{
		if(!Predmet.isValidData(arr, null))
		{
			return null;
		}
		Predmet pr = new Predmet(arr);
		predmeti.add(pr);
		return pr;
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
}















