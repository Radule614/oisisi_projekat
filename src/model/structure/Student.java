package model.structure;

import java.util.ArrayList;

import app.Settings;
import app.Utility;

public class Student extends Osoba {
	public enum VrstaFinansiranja {B, S};
	
	protected String brojIndeksa;
	protected int godinaUpisa;
	protected int trenutnaGodina;
	protected VrstaFinansiranja Status;
	protected double prosek;
	
	protected ArrayList<Ocena> polozeniIspiti = new ArrayList<Ocena>();
	protected ArrayList<Ocena> nepolozeniIspiti = new ArrayList<Ocena>();
	
	public Student()
	{
		super();
	}
	
	public Student(String[] arr)
	{	
		super(arr);
		setBrojIndeksa(arr[6]);
		setGodinaUpisa(Utility.parseInt(arr[7]));
		setTrenutnaGodina(Utility.parseInt(arr[8]) + 1);
		VrstaFinansiranja vf = null;
		if		(Utility.parseInt(arr[9]) == 0) vf = VrstaFinansiranja.B;
		else if	(Utility.parseInt(arr[9]) == 1) vf = VrstaFinansiranja.S;
		setStatus(vf);
	}
	
	public String[] toStringArray()
	{
		String[] data = new String[10];
		super.toStringArray(data);
		
		data[6] = getBrojIndeksa();
		data[7] = Integer.toString(getGodinaUpisa());
		data[8] = Integer.toString(getTrenutnaGodina()-1);
		if(getStatus() == VrstaFinansiranja.B) data[9] = "0";
		else if(getStatus() == VrstaFinansiranja.S) data[9] = "1";
		
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
		
		return isValid;
	}
	
	public ArrayList<String[]> polozeniToArrayList()
	{
		ArrayList<String[]> dataArray = new ArrayList<String[]>();
		
		for(Ocena ocena: this.polozeniIspiti)
		{
			String[] data = new String[5];
			Predmet predmet = ocena.getPredmet();
			
			data[0] = Integer.toString(predmet.getSifra());
			data[1] = predmet.getNaziv();
			data[2] = Integer.toString(predmet.getESPB());
			data[3] = Integer.toString(ocena.getVrednost());
			data[4] = ocena.getDatumPolaganja().format(Settings.formatter);
			
			dataArray.add(data);
		}
		
		return dataArray;
	}
	
	public void calculateProsek()
	{
		ArrayList<Ocena> arr = this.getPolozeniIspiti();
		if(arr.size() == 0) 
		{
			this.prosek = 0;
			return;
		}
		double sum = 0;
		
		for(Ocena o: arr)
		{
			sum += o.vrednost;
		}
		this.prosek = sum/(double)(arr.size());
	}
	
	public void addPolozeniIspit(Ocena o)
	{
		this.polozeniIspiti.add(o);
		this.calculateProsek();
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
