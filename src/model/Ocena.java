package model;

import java.time.LocalDate;

import app.Settings;

public class Ocena {
	protected Student student;
	protected Predmet predmet;
	protected int vrednost;
	protected LocalDate datumPolaganja;
	
	
	public Ocena()
	{
		
	}

	public Ocena(Student student, Predmet predmet, int vrednost)
	{
		this.student = student;
		this.predmet = predmet;
		this.vrednost = vrednost;
		
		LocalDate ld = LocalDate.parse("01-01-2000", Settings.formatter);
		datumPolaganja = ld;
	}
	
	public Ocena(Student student, Predmet predmet)
	{
		this.student = student;
		this.predmet = predmet;
		this.vrednost = 0;
		
		LocalDate ld = LocalDate.parse("01-01-2000", Settings.formatter);
		datumPolaganja = ld;
	}

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Predmet getPredmet() {
		return predmet;
	}


	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}


	public int getVrednost() {
		return vrednost;
	}


	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}


	public LocalDate getDatumPolaganja() {
		return datumPolaganja;
	}


	public void setDatumPolaganja(LocalDate datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
}
