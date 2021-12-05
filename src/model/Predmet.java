package model;

import java.util.ArrayList;

import app.Utility;

public class Predmet {
	public enum VrstaSemestra {L, Z};
	
	protected int sifra;
	protected String naziv;
	protected VrstaSemestra semestar;
	protected int godinaStudija;
	protected Profesor predmetniProfesor;
	protected int ESPB;
	
	protected ArrayList<Student> studentiPolozeno;
	protected ArrayList<Student> studentiNepolozeno;
	
	public Predmet()
	{
		studentiPolozeno = new ArrayList<Student>();
		studentiNepolozeno = new ArrayList<Student>();
	}
	
	public Predmet(String[] arr)
	{
		setSifra(Utility.parseInt(arr[0]));
		setNaziv(arr[1]);
		VrstaSemestra vs = null;
		if		(Utility.parseInt(arr[2]) == 0) vs = VrstaSemestra.L;
		else if	(Utility.parseInt(arr[2]) == 1) vs = VrstaSemestra.Z;
		setSemestar(vs);
		setGodinaStudija(Utility.parseInt(arr[3])+1);
		setESPB(Utility.parseInt(arr[4]));
	}
	
	public String[] toStringArray()
	{
		String[] data = new String[11];
		
		data[0] = Integer.toString(getSifra());
		data[1] = getNaziv();
		if		(getSemestar() == VrstaSemestra.L) data[2] = "0";
		else if	(getSemestar() == VrstaSemestra.Z) data[2] = "1";
		data[3] = Integer.toString(getGodinaStudija()-1);
		data[4] = Integer.toString(getESPB());
		
		return data;
	}
	
	public static boolean isValidData(String[] arr, ArrayList<String> messages)
	{
		boolean isValid = true;
		
		//TODO checks
		
		return isValid;
	}
	
	public String[] getTableData()
	{
		String sem;
		if(this.semestar == VrstaSemestra.L) 	sem = "Letnji";
		else									sem = "Zimski";
		String[] godine = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		String[] data = new String[5];
		data[0] = Integer.toString(this.sifra);
		data[1] = this.naziv;
		data[2] = Integer.toString(this.ESPB);
		data[3] = Integer.toString(this.godinaStudija);
		data[3] = godine[this.godinaStudija-1];
		data[4] = sem;
		return data;
	}
	
	public int getSifra() {
		return sifra;
	}


	public void setSifra(int sifra) {
		this.sifra = sifra;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public VrstaSemestra getSemestar() {
		return semestar;
	}


	public void setSemestar(VrstaSemestra semestar) {
		this.semestar = semestar;
	}


	public int getGodinaStudija() {
		return godinaStudija;
	}


	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}


	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}


	public int getESPB() {
		return ESPB;
	}


	public void setESPB(int ESPB) {
		this.ESPB = ESPB;
	}


	public ArrayList<Student> getStudentiPolozeno() {
		return studentiPolozeno;
	}


	public void setStudentiPolozeno(ArrayList<Student> studentiPolozeno) {
		this.studentiPolozeno = studentiPolozeno;
	}


	public ArrayList<Student> getStudentiNepolozeno() {
		return studentiNepolozeno;
	}


	public void setStudentiNepolozeno(ArrayList<Student> studentiNepolozeno) {
		this.studentiNepolozeno = studentiNepolozeno;
	}
}