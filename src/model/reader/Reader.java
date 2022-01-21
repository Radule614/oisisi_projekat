package model.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import app.Settings;
import app.Utility;
import model.Adresa;
import model.Katedra;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;
import model.data.Data;

public class Reader {
	public static void readStudenti(){
		try (Scanner sc = new Scanner(new File("baza//studenti.csv"))){
			sc.useDelimiter(",");
			sc.nextLine();
			while(sc.hasNext()) {
				String[] data = new String[10];
				String[] array = sc.nextLine().split(",");
				
				data[6] = array[1].replace(" ", "");
				data[0] = array[2];
				data[1] = array[3];
				data[8] = Integer.toString(Utility.parseInt(array[4]) - 1);
				String s = array[5].replace(".", "-");
				data[2] = s.substring(0, s.length() - 1);
				if(array[6].equals("null")){
					data[3] = "a, b, c, d";
				}else {
					data[3] = Data.adrese.get(Utility.parseInt(array[6])-1).toString();
				}
				
				data[4] = array[7];
				data[5] = array[8];
				
				if(array[9].equals("B")) 
					data[9] = Integer.toString(0);
				else
					data[9] = Integer.toString(1);
				
				data[7] = array[10];
				
				ArrayList<String> messages = new ArrayList<String>();
				Data.student.create(data, messages);
				
				if(!messages.isEmpty()) {
					Utility.printArray(messages);
					break;
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
	}
	
	public static void readProfesori(){
		try (Scanner sc = new Scanner(new File("baza//profesori.csv"))){
			sc.useDelimiter(",");
			sc.nextLine();
			while(sc.hasNext()) {
				String[] data = new String[10];
				String[] array = sc.nextLine().split(",");
				
				data[7] = array[1].replace(" ", "");
				data[0] = array[2];
				data[1] = array[3];
				String s = array[4].replace(".", "-");
				data[2] = s.substring(0, s.length() - 1);
				data[3] = Data.adrese.get(Utility.parseInt(array[5])-1).toString();
				data[4] = array[6];
				data[5] = array[7];
				data[6] = Data.adrese.get(Utility.parseInt(array[8])-1).toString();
				data[9] = array[9];
				data[8] = array[10];
				
				ArrayList<String> messages = new ArrayList<String>();
				Profesor prof = Data.profesor.create(data, messages);
				
				if(!messages.isEmpty()) {
					Utility.printArray(messages);
					
					break;
				}
				
				Katedra k = Data.katedre.get(Utility.parseInt(array[11]) - 1);
				boolean exists = false;
				if(k.getSpisakProfesora() == null)
					k.setSpisakProfesora(new ArrayList<Profesor>());
				if(prof != null)
				{
					for(Profesor temp: k.getSpisakProfesora()) {
						if(prof.equals(temp)) {
							exists = true;
							break;
						}
					}
				}
				
				
				if(!exists) {
					k.getSpisakProfesora().add(prof);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static void readPredmeti(){
		try (Scanner sc = new Scanner(new File("baza//predmeti.csv"))){
			sc.useDelimiter(",");
			sc.nextLine();
			while(sc.hasNext()) {
				String[] data = new String[5];
				String[] array = sc.nextLine().split(",");
				
				data[0] = array[1];
				data[1] = array[2];
				data[3] = Integer.toString(Utility.parseInt(array[3]) - 1);
				data[4] = array[4];
				if(array[6].equals("LETNJI")) 
					data[2] = Integer.toString(0);
				else
					data[2] = Integer.toString(1);
				
				
				
				ArrayList<String> messages = new ArrayList<String>();
				Predmet pr = Data.predmet.create(data, messages);
				
				if(pr!=null && !array[5].equals("null")) {
					pr.setPredmetniProfesor(Data.profesor.getAll().get(Utility.parseInt(array[5])-1));
				}
				
				if(!messages.isEmpty()) {
					Utility.printArray(messages);
					break;
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static void readAdrese(){
		try (Scanner sc = new Scanner(new File("baza//adrese.csv"))){
			sc.useDelimiter(",");
			sc.nextLine();
			while(sc.hasNext()) {
				String[] array = sc.nextLine().split(",", 2);
				
				if(!Utility.doesMatch(Settings.addressPattern, array[1])){
					System.out.println("Adresa stanovanja: mora biti u obliku: ulica, broj, grad, drzava");
					break;
				}
				
				boolean exists = false;
				for(Adresa temp: Data.adrese){
					if(array[1].replace(" ", "").equals(temp.toString().replace(" ", "")))
					{
						exists = true;
						break;
					}
				}
				if(!exists) {
					Data.adrese.add(new Adresa(array[1]));
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
	}
	
	public static void readKatedre(ArrayList<Integer> sefovi){
		try (Scanner sc = new Scanner(new File("baza//katedre.csv"))){
			sc.useDelimiter(",");
			sc.nextLine();
			while(sc.hasNext()) {
				String[] array = sc.nextLine().split(",");
				
				Katedra kat = new Katedra(array[1], array[2]);
				kat.setSpisakProfesora(new ArrayList<Profesor>());
				boolean exists = false;
				for(Katedra temp: Data.katedre) {
					if(temp.getSifra().equals(kat.getSifra())) {
						exists = true;
						break;
					}
				}
				
				if(!exists) {
					Data.katedre.add(kat);
					sefovi.add(Utility.parseInt(array[3]) - 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void readNepolozeni(){
		try (Scanner sc = new Scanner(new File("baza//nepolozeni.csv"))){
			sc.useDelimiter(",");
			sc.nextLine();
			while(sc.hasNext()) {
				String[] array = sc.nextLine().split(",");
				int studentIndex = Utility.parseInt(array[0]) - 1;
				int predmetIndex = Utility.parseInt(array[1]) - 1;
				Student st = Data.student.getAll().get(studentIndex);
				Predmet pr = Data.predmet.getAll().get(predmetIndex);
				Ocena o = new Ocena(st, pr);
				st.addNepolozeniIspit(o);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static void readPolozeni() {
		try (Scanner sc = new Scanner(new File("baza//ocene.csv"))){
			sc.useDelimiter(",");
			sc.nextLine();
			while(sc.hasNext()) {
				String[] array = sc.nextLine().split(",");
				int studentIndex = Utility.parseInt(array[0]) - 1;
				int predmetIndex = Utility.parseInt(array[1]) - 1;
				Student st = Data.student.getAll().get(studentIndex);
				Predmet pr = Data.predmet.getAll().get(predmetIndex);
				
				String s = array[3].replace(".", "-");

				Ocena o = new Ocena(st, pr, Utility.parseInt(array[2]), s.substring(0, s.length() - 1));
				st.addPolozeniIspit(o);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}




















