package model;

import java.util.ArrayList;

public class Predmet {
	public enum VrstaSemestra {L, Z};
	
	protected int sifra;
	protected String naziv;
	protected VrstaSemestra semestar;
	protected int godinaStudija;
	protected Profesor predmetniProfesor;
	protected int ESPB;
	
	protected ArrayList<Student> studentiPolozeno;
	protected ArrayList<Student> studentiNepolozeno;
	
	public Predmet()
	{
		studentiPolozeno = new ArrayList<Student>();
		studentiNepolozeno = new ArrayList<Student>();
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


	public VrstaSemestra getSemestar() {
		return semestar;
	}


	public void setSemestar(VrstaSemestra semestar) {
		this.semestar = semestar;
	}


	public int getGodinaStudija() {
		return godinaStudija;
	}


	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}


	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}


	public int getESPB() {
		return ESPB;
	}


	public void setESPB(int ESPB) {
		this.ESPB = ESPB;
	}


	public ArrayList<Student> getStudentiPolozeno() {
		return studentiPolozeno;
	}


	public void setStudentiPolozeno(ArrayList<Student> studentiPolozeno) {
		this.studentiPolozeno = studentiPolozeno;
	}


	public ArrayList<Student> getStudentiNepolozeno() {
		return studentiNepolozeno;
	}


	public void setStudentiNepolozeno(ArrayList<Student> studentiNepolozeno) {
		this.studentiNepolozeno = studentiNepolozeno;
	}
}