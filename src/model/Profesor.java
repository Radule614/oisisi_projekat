package model;

import java.util.ArrayList;

import app.Settings;
import app.Utility;
import gui.MainWindow;

public class Profesor extends Osoba {
	private static final long serialVersionUID = -5074812364592294015L;
	
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

		predmeti = new ArrayList<Predmet>();
		setAdresaKancelarije(new Adresa(arr[6]));
		setLicnaKarta(Utility.parseInt(arr[7]));
		setZvanje(arr[8]);
		setGodineStaza(Utility.parseInt(arr[9]));
	}
	
	public String[] toStringArray()
	{
		String[] data = new String[11];
		super.toStringArray(data);
		data[6] = getAdresaKancelarije().toString();
		data[7] = Integer.toString(getLicnaKarta());
		data[8] = getZvanje();
		data[9] = Integer.toString(getGodineStaza());
		
		return data;
	}
	
	public static boolean isValidData(String[] arr, ArrayList<String> messages)
	{
		boolean isValid = Osoba.isValidData(arr, messages);
		if(!Utility.doesMatch(Settings.addressPattern, arr[6]))
		{
			isValid = false;
			if(messages != null) messages.add(MainWindow.getInstance().GetLocalization("warnAdressOfOffice"));
		}
		if(!Utility.doesMatch(Settings.idCardPattern, arr[7]))
		{
			isValid = false;
			if(messages != null) messages.add(MainWindow.getInstance().GetLocalization("warnIdCard"));
		}
		if(!Utility.doesMatch(Settings.multipleWordPattern, arr[8]))
		{
			isValid = false;
			if(messages != null) messages.add(MainWindow.getInstance().GetLocalization("warnRank"));
		}
		if(!Utility.isInInterval(Utility.parseInt(arr[9]), 0, 50))
		{
			isValid = false;
			if(messages != null) messages.add(MainWindow.getInstance().GetLocalization("warnYearsOfService"));
		}
		
		return isValid;
	}
	
	public String[] getTableData()
	{
		String[] data = new String[4];
		data[0] = this.ime;
		data[1] = this.prezime;
		data[2] = this.email;
		data[3] = this.zvanje;
		return data;
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
	
	public void addPredmet(Predmet o)
	{
		if(predmeti == null) 
		{
			predmeti = new ArrayList<Predmet>();
		}
		for(Predmet pr : this.predmeti)
		{
			if(pr.getSifra().equals(o.getSifra()))
				return;
		}
		this.predmeti.add(o);
	}
	
	public void removePredmet(Predmet o)
	{
		if(predmeti == null) 
		{
			predmeti = new ArrayList<Predmet>();
		}
		else 
		{
			this.predmeti.remove(o);
		}
	}
	
	public ArrayList<String[]> predmetiToArrayList()
	{
		ArrayList<String[]> dataArray = new ArrayList<String[]>();
		if(predmeti != null) 
		{
			for(Predmet predmet: this.predmeti)
			{
				String[] data = new String[4];
				
				data[0] = predmet.getSifra();
				data[1] = predmet.naziv;
				data[2] = Integer.toString(predmet.getGodinaStudija());
				data[3] = predmet.semestar.toString();
				
				
				dataArray.add(data);
			}
		}
		
		return dataArray;
	}
}
