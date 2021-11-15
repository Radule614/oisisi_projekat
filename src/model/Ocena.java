package model;

public class Ocena {
	protected Student student;
	protected Predmet predmet;
	protected int vrednost;
	protected String datumPolaganja;
	
	
	public Ocena()
	{
		
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


	public String getDatumPolaganja() {
		return datumPolaganja;
	}


	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
}
