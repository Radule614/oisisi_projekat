package model;

import java.util.ArrayList;

import main.Settings;
import utility.Utility;

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
	
	public Student(String[] arr)
	{	
		super(arr);
		setBrojIndeksa(arr[6]);
		setGodinaUpisa(Utility.parseInt(arr[7]));
		setProsek(Utility.parseDouble(arr[8]));
		setTrenutnaGodina(Utility.parseInt(arr[9]) + 1);
		VrstaFinansiranja vf = null;
		if		(Utility.parseInt(arr[10]) == 0) vf = VrstaFinansiranja.B;
		else if	(Utility.parseInt(arr[10]) == 1) vf = VrstaFinansiranja.S;
		setStatus(vf);
	}
	
	public String[] toStringArray()
	{
		String[] data = new String[11];
		super.toStringArray(data);
		
		data[6] = getBrojIndeksa();
		data[7] = Integer.toString(getGodinaUpisa());
		data[8] = Double.toString(getProsek());
		data[9] = Integer.toString(getTrenutnaGodina()-1);
		if(getStatus() == VrstaFinansiranja.B) data[10] = "0";
		else if(getStatus() == VrstaFinansiranja.S) data[10] = "1";
		
		return data;
	}
	
	public static boolean isValidData(String[] arr, ArrayList<String> messages)
	{
		boolean isValid = Osoba.isValidData(arr, messages);
		if(!Utility.doesMatch(Settings.indexPattern, arr[6]))
		{
			isValid = false;
			if(messages != null) messages.add("Indeks: nije validan");
		}
		if(!Utility.isInInterval(Utility.parseInt(arr[7]), 1950, 2021))
		{
			isValid = false;
			if(messages != null) messages.add("Godina upisa: mora biti u intervalu [1950, 2021]");
		}
		if(!Utility.isInInterval(Utility.parseDouble(arr[8]), 5.0, 10.0))
		{
			isValid = false;
			if(messages != null) messages.add("Prosek: mora biti u intervalu [5.0, 10.0]");
		}
		
		return isValid;
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
