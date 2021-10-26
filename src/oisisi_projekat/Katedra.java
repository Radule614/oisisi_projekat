package oisisi_projekat;

import java.util.ArrayList;

public class Katedra {
	int sifra;
	String naziv;
	Profesor sef;
	ArrayList<Profesor> spisak_profesora;
	
	
	Katedra()
	{
		spisak_profesora = new ArrayList<Profesor>();
	}
}
