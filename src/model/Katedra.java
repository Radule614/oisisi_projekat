package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Katedra implements Serializable {
	private static final long serialVersionUID = -4767123478567952277L;
	
	protected int sifra;
	protected String naziv;
	protected Profesor sef;
	protected ArrayList<Profesor> spisakProfesora;
	
	
	public Katedra()
	{
		spisakProfesora = new ArrayList<Profesor>();
	}


	public int getSifra() {
		return sifra;
	}


	public void setSifra(int sifra) {
		this.sifra = sifra;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public Profesor getSef() {
		return sef;
	}


	public void setSef(Profesor sef) {
		this.sef = sef;
	}


	public ArrayList<Profesor> getSpisakProfesora() {
		return spisakProfesora;
	}


	public void setSpisakProfesora(ArrayList<Profesor> spisakProfesora) {
		this.spisakProfesora = spisakProfesora;
	}
	
	
}
