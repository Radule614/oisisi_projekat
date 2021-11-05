package model;

import java.util.ArrayList;

public class Profesor extends Osoba {
	protected Adresa adresaKancelarije;
	protected int licnaKarta;
	protected String titula;
	protected String zvanje;
	protected int godineStaza;
	
	protected ArrayList<Predmet> predmeti;
	
	public Profesor()
	{
		super();
		predmeti = new ArrayList<Predmet>();
	}
	
	
	public Adresa getAdresaKancelarije() {
		return adresaKancelarije;
	}


	public void setAdresaKancelarije(Adresa adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}


	public int getLicnaKarta() {
		return licnaKarta;
	}


	public void setLicnaKarta(int licnaKarta) {
		this.licnaKarta = licnaKarta;
	}
	
	
	public String getTitula()
	{
		return titula;
	}
	
	public void setTitula(String titula)
	{
		this.titula = titula;
	}


	public String getZvanje() {
		return zvanje;
	}


	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}


	public int getGodineStaza() {
		return godineStaza;
	}


	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}


	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}


	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
}
