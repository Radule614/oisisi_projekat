package model;

import java.util.ArrayList;

public class Student extends Osoba {
	public enum VrstaFinansiranja {B, S};
	
	protected String brojIndeksa;
	protected int godinaUpisa;
	protected int trenutnaGodina;
	protected VrstaFinansiranja Status;
	protected double prosek;
	
	protected ArrayList<Ocena> polozeniIspiti;
	protected ArrayList<Ocena> nepolozeniIspiti;
	
	
	public Student()
	{
		super();
		polozeniIspiti = new ArrayList<Ocena>();
		nepolozeniIspiti = new ArrayList<Ocena>();
	}


	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public int getGodinaUpisa() {
		return godinaUpisa;
	}


	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}


	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}


	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}


	public VrstaFinansiranja getStatus() {
		return Status;
	}


	public void setStatus(VrstaFinansiranja status) {
		Status = status;
	}


	public double getProsek() {
		return prosek;
	}


	public void setProsek(double prosek) {
		this.prosek = prosek;
	}


	public ArrayList<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}


	public void setPolozeniIspiti(ArrayList<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}


	public ArrayList<Ocena> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}


	public void setNepolozeniIspiti(ArrayList<Ocena> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
}
