package model;

import java.util.ArrayList;

import main.Settings;
import utility.Utility;

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
	
	public Profesor(String[] arr)
	{
		super(arr);
		setAdresaKancelarije(new Adresa(arr[6]));
		setLicnaKarta(Utility.parseInt(arr[7]));
		setTitula(arr[8]);
		setZvanje(arr[9]);
		setGodineStaza(Utility.parseInt(arr[10]));
	}
	
	public String[] toStringArray()
	{
		String[] data = new String[11];
		super.toStringArray(data);
		data[6] = getAdresaKancelarije().toString();
		data[7] = Integer.toString(getLicnaKarta());
		data[8] = getTitula();
		data[9] = getZvanje();
		data[10] = Integer.toString(getGodineStaza());
		
		return data;
	}
	
	public static boolean isValidData(String[] arr, ArrayList<String> messages)
	{
		boolean isValid = Osoba.isValidData(arr, messages);
		if(!Utility.doesMatch(Settings.addressPattern, arr[6]))
		{
			isValid = false;
			if(messages != null) messages.add("Adresa kancelarije: mora biti u obliku: ulica, broj, grad, drzava");
		}
		if(!Utility.doesMatch(Settings.multipleWordPattern, arr[8]))
		{
			isValid = false;
			if(messages != null) messages.add("Titula: mora da sadrži jednu ili više reči bez brojeva");
		}
		if(!Utility.doesMatch(Settings.multipleWordPattern, arr[9]))
		{
			isValid = false;
			if(messages != null) messages.add("Zvanje: mora da sadrži jednu ili više reči bez brojeva");
		}
		if(!Utility.isInInterval(Utility.parseInt(arr[10]), 0, 50))
		{
			isValid = false;
			if(messages != null) messages.add("Godine staža: mora biti u intervalu [0, 50]");
		}
		
		return isValid;
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
