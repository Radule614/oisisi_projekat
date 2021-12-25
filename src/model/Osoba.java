package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import app.Settings;
import app.Utility;

public abstract class Osoba implements Serializable {
	private static final long serialVersionUID = 1435561261890824899L;
	
	protected String ime;
	protected String prezime;
	protected LocalDate datumRodjenja;
	protected Adresa adresaStanovanja;
	protected String telefon;
	protected String email;
	
	public Osoba()
	{
		
	}
	
	public Osoba(String[] arr)
	{
		LocalDate date = LocalDate.parse((String)arr[2], Settings.formatter);
		
		setIme(arr[0]);
		setPrezime(arr[1]);
		setDatumRodjenja(date);
		setAdresaStanovanja(new Adresa(arr[3]));
		setTelefon(arr[4]);
		setEmail(arr[5]);
	}
	
	public void toStringArray(String[] data)
	{
		data[0] = getIme();
		data[1] = getPrezime();
		data[2] = getDatumRodjenja().format(Settings.formatter);
		data[3] = getAdresaStanovanja().toString();
		data[4] = getTelefon();
		data[5] = getEmail();
	}
	
	public static boolean isValidData(String[] arr, ArrayList<String> messages)
	{
		boolean isValid = true;
		if(!Utility.doesMatch(Settings.namePattern, arr[0]))
		{
			isValid = false;
			if(messages != null) messages.add("Ime: dužina 3 ili više karaktera");
		}
		if(!Utility.doesMatch(Settings.namePattern, arr[1]))
		{
			isValid = false;
			if(messages != null) messages.add("Prezime: dužina 3 ili više karaktera");
		}
		if(!Utility.isInInterval(Utility.parseInt(arr[2].substring(6)), 1900, Settings.trenutnaGodina))
		{
			isValid = false;
			if(messages != null) messages.add("Godina rođenja: mora biti u intervalu [1900, " + Settings.trenutnaGodina +"]");
		}
		if(!Utility.doesMatch(Settings.addressPattern, arr[3]))
		{
			isValid = false;
			if(messages != null) messages.add("Adresa stanovanja: mora biti u obliku: ulica, broj, grad, drzava");
		}
		if(!Utility.doesMatch(Settings.phonePattern, arr[4]))
		{
			isValid = false;
			if(messages != null) messages.add("Broj telefona mora biti u formatu: nnn/nnn-nnn");
		}
		if(!Utility.doesMatch(Settings.emailPattern, arr[5]))
		{
			isValid = false;
			if(messages != null) messages.add("Email: nije validan");
		}
		
		return isValid;
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
