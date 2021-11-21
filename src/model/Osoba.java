package model;

import java.time.LocalDate;

public abstract class Osoba {
	protected String ime;
	protected String prezime;
	protected LocalDate datumRodjenja;
	protected Adresa adresaStanovanja;
	protected String telefon;
	protected String email;
	
	
	public Osoba()
	{
		
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}


	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}


	public Adresa getAdresaStanovanja() {
		return adresaStanovanja;
	}


	public void setAdresaStanovanja(Adresa adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
