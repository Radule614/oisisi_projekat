package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.*;
import model.Predmet.VrstaSemestra;
import model.Student.VrstaFinansiranja;

public class DataManager {
	ArrayList<Student> studenti = new ArrayList<Student>();
	ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	
	public final String dateFormat = "dd/MM/yyyy";
	public final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

	public Student createStudent(String[] arr)
	{
		Student st = new Student();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate date = LocalDate.parse((String)arr[2], formatter);
		
		st.setIme(arr[0]);
		st.setPrezime(arr[1]);
		st.setDatumRodjenja(date);
		st.setAdresaStanovanja(new Adresa(arr[3]));
		st.setTelefon(arr[4]);
		st.setEmail(arr[5]);
		st.setBrojIndeksa(arr[6]);
		st.setGodinaUpisa(this.parseInt(arr[7]));
		st.setProsek(this.parseDouble(arr[8]));
		st.setTrenutnaGodina(this.parseInt(arr[9]) + 1);
		
		VrstaFinansiranja vf = null;
		if		(this.parseInt(arr[10]) == 0) vf = VrstaFinansiranja.B;
		else if	(this.parseInt(arr[10]) == 1) vf = VrstaFinansiranja.S;
		st.setStatus(vf);
		
		this.studenti.add(st);
		return st;
	}
	
	public Profesor createProfesor(String[] arr)
	{
		Profesor pf = new Profesor();
		
		LocalDate date = LocalDate.parse((String)arr[2], formatter);
		
		pf.setIme(arr[0]);
		pf.setPrezime(arr[1]);
		pf.setDatumRodjenja(date);
		pf.setAdresaStanovanja(new Adresa(arr[3]));
		pf.setTelefon(arr[4]);
		pf.setEmail(arr[5]);
		pf.setAdresaKancelarije(new Adresa(arr[6]));
		pf.setLicnaKarta(this.parseInt(arr[7]));
		pf.setTitula(arr[8]);
		pf.setZvanje(arr[9]);
		pf.setGodineStaza(this.parseInt(arr[10]));
		
		this.profesori.add(pf);
		return pf;
	}
	
	public Predmet createPredmet(String[] arr)
	{
		Predmet pr = new Predmet();
		pr.setSifra(this.parseInt(arr[0]));
		pr.setNaziv(arr[1]);
		
		VrstaSemestra vs = null;
		if		(this.parseInt(arr[2]) == 0) vs = VrstaSemestra.L;
		else if	(this.parseInt(arr[2]) == 1) vs = VrstaSemestra.Z;
		pr.setSemestar(vs);
		
		pr.setGodinaStudija(this.parseInt(arr[3]));
		pr.setESPB(this.parseInt(arr[4]));
		
		this.predmeti.add(pr);
		return pr;
	}
	
	public String[] getStudentData(int index)
	{
		Student st = this.studenti.get(index);
		String[] data = new String[11];
		
		data[0] = st.getIme();
		data[1] = st.getPrezime();
		data[2] = st.getDatumRodjenja().format(formatter);
		data[3] = st.getAdresaStanovanja().toString();
		data[4] = st.getTelefon();
		data[5] = st.getEmail();
		data[6] = st.getBrojIndeksa();
		data[7] = Integer.toString(st.getGodinaUpisa());
		data[8] = Double.toString(st.getProsek());
		data[9] = Integer.toString(st.getTrenutnaGodina()-1);
		if(st.getStatus() == VrstaFinansiranja.B) data[10] = "0";
		else if(st.getStatus() == VrstaFinansiranja.S) data[10] = "1";
		
		return data;
	}
	
	public String[] getProfesorData(int index)
	{
		Profesor pr = this.profesori.get(index);
		String[] data = new String[11];
		
		data[0] = pr.getIme();
		data[1] = pr.getPrezime();
		data[2] = pr.getDatumRodjenja().format(formatter);
		data[3] = pr.getAdresaStanovanja().toString();
		data[4] = pr.getTelefon();
		data[5] = pr.getEmail();
		data[6] = pr.getAdresaKancelarije().toString();
		data[7] = Integer.toString(pr.getLicnaKarta());
		data[8] = pr.getTitula();
		data[9] = pr.getZvanje();
		data[10] = Integer.toString(pr.getGodineStaza());
		
		return data;
	}
	
	public String[] getPredmetData(int index)
	{
		Predmet pr = this.predmeti.get(index);
		String[] data = new String[11];
		
		data[0] = Integer.toString(pr.getSifra());
		data[1] = pr.getNaziv();
		if		(pr.getSemestar() == VrstaSemestra.L) data[2] = "0";
		else if	(pr.getSemestar() == VrstaSemestra.Z) data[2] = "1";
		data[2] = Integer.toString(pr.getGodinaStudija());
		data[3] = Integer.toString(pr.getESPB());
		
		return data;
	}
	

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	
	
	protected int parseInt(String s)
	{
		int n = 0;
		try 
		{
			n = Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			System.out.println(e.toString());
		}
		return n;
	}
	
	protected double parseDouble(String s)
	{
		double n = 0.0;
		try 
		{
			n = Double.parseDouble(s);
		}
		catch(NumberFormatException e)
		{
			System.out.println(e.toString());
		}
		return n;
	}
}















