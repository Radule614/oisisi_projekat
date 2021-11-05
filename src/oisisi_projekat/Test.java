package oisisi_projekat;

import java.util.ArrayList;

import gui.MainWindow;
import model.Predmet;
import model.Predmet.VrstaSemestra;
import model.Profesor;
import model.Student;
import model.Student.VrstaFinansiranja;

public class Test {
	static ArrayList<Student> studenti = new ArrayList<Student>();
	static ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	static ArrayList<Predmet> predmeti = new ArrayList<Predmet>();

	public static void main(String[] args) {
		MainWindow gui = new MainWindow();
		
		createExamples();

		for(Student st: studenti)
		{
			gui.addToTable(st);
		}
		
		for(Profesor pf: profesori)
		{
			gui.addToTable(pf);
		}
		
		for(Predmet pr: predmeti)
		{
			gui.addToTable(pr);
		}
		
		gui.setVisible(true);
	}
	
	static void createExamples()
	{
		studenti.add(createStudent(new Object[] {"RA138/2019", "Rade", 		"Stojanovic", 	3, VrstaFinansiranja.B, 9.2}));
		studenti.add(createStudent(new Object[] {"RA115/2019", "Damjan", 	"Dimitrijevic", 3, VrstaFinansiranja.B, 8.679}));
		studenti.add(createStudent(new Object[] {"RA119/2019", "Uros", 		"Jokovic", 		3, VrstaFinansiranja.B, 9.0}));
		studenti.add(createStudent(new Object[] {"RA146/2019", "Luka", 		"Pikula", 		3, VrstaFinansiranja.B, 10.0}));
		
		profesori.add(createProfesor(new Object[] {"Nebojsa", "Ralevic", "Doktor", "Redovni profesor"}));
		profesori.add(createProfesor(new Object[] {"Nebojsa", "Ralevic", "Doktor", "Redovni profesor"}));
		profesori.add(createProfesor(new Object[] {"Nebojsa", "Ralevic", "Doktor", "Redovni profesor"}));
		
		predmeti.add(createPredmet(new Object[] {12345, "Matematicka Analiza 1", 9, 1, VrstaSemestra.Z}));
		predmeti.add(createPredmet(new Object[] {123456, "Baze Podataka 1", 8, 3, VrstaSemestra.Z}));
	}

	static Student createStudent(Object[] arr)
	{
		Student st = new Student();
		st.setBrojIndeksa((String)arr[0]);
		st.setIme((String)arr[1]);
		st.setPrezime((String)arr[2]);
		st.setTrenutnaGodina((int)arr[3]);
		st.setStatus((VrstaFinansiranja)arr[4]);
		st.setProsek((double)arr[5]);
		
		return st;
	}
	
	static Profesor createProfesor(Object[] arr)
	{
		Profesor pf = new Profesor();
		pf.setIme((String)arr[0]);
		pf.setPrezime((String)arr[1]);
		pf.setTitula((String)arr[2]);
		pf.setZvanje((String)arr[3]);
		return pf;
	}
	
	static Predmet createPredmet(Object[] arr)
	{
		Predmet pr = new Predmet();
		pr.setSifra((int)arr[0]);
		pr.setNaziv((String)arr[1]);
		pr.setESPB((int)arr[2]);
		pr.setGodinaStudija((int)arr[3]);
		pr.setSemestar((VrstaSemestra)arr[4]);
		
		return pr;
	}
	
}








