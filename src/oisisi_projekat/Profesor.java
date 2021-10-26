package oisisi_projekat;

import java.util.ArrayList;

public class Profesor extends Osoba {
	Adresa adresa_kancelarije;
	int licna_karta;
	String zvanje;
	int godine_staza;
	
	ArrayList<Predmet> predmeti;
	
	
	Profesor()
	{
		super();
		predmeti = new ArrayList<Predmet>();
	}
}
