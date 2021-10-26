package oisisi_projekat;

import java.util.ArrayList;

public class Predmet {
	enum VrstaSemestra {L, Z};
	
	int sifra;
	String naziv;
	VrstaSemestra semestar;
	int godina_studija;
	Profesor predmetni_profesor;
	int ESPB_bodovi;
	
	ArrayList<Student> studenti_polozeno;
	ArrayList<Student> studenti_nepolozeno;
	
	
	Predmet()
	{
		studenti_polozeno = new ArrayList<Student>();
		studenti_nepolozeno = new ArrayList<Student>();
	}
}