package model;

import java.util.ArrayList;

public class Student extends Osoba {
	enum VrstaFinansiranja {B, S};
	
	int broj_indeksa;
	int godina_upisa;
	int trenutna_godina;
	VrstaFinansiranja Status;
	double prosek;
	
	ArrayList<Ocena> polozeni_ispiti;
	ArrayList<Ocena> nepolozeni_ispiti;
	
	
	Student()
	{
		super();
		polozeni_ispiti = new ArrayList<Ocena>();
		nepolozeni_ispiti = new ArrayList<Ocena>();
	}
}
