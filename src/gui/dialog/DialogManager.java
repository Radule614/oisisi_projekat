package gui.dialog;

import java.util.ArrayList;

import javax.swing.*;

public class DialogManager {
	static protected String[] studentiFieldLabels = {"Ime", "Prezime", "Datum rođenja", "Adresa stanonovanja", "Broj telefona", "E-mail adresa", "Broj indeksa", "Godina upisa", "Prosek", "Trenutna godina studija", "Način finansiranja"};
	static protected String[] profesoriFieldLabels = {"Ime", "Prezime", "Datum rođenja", "Adresa stanonovanja", "Broj telefona", "E-mail adresa", "Adresa kancelarije", "Broj lične karte", "Titula", "Zvanje", "Godine staža"};
	static protected String[] predmetiFieldLabels = {"Sifra predmeta", "Naziv predmeta", "Semestar", "Godina studija", "Broj ESPB bodova"};
	
	public static JFrame window;

	public static void createAddStudentDialog()
	{
		AddDialog d = new AddDialog(window, "Dodavanje studenta", Dialog.EntityType.STUDENT);
		
		String[] labels = studentiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addDateField(temp);
			else if	(i==9)	d.addComboBox(temp, new String[] {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"});
			else if	(i==10) d.addComboBox(temp, new String[] {"Budžet", "Samofinansiranje"});
			else 			d.addTextField(temp);
		}
		d.open();
	}
	
	public static void createAddProfesorDialog()
	{
		AddDialog d = new AddDialog(window, "Dodavanje profesora", Dialog.EntityType.PROFESOR);
		
		String[] labels = profesoriFieldLabels;	
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addDateField(temp);
			else 			d.addTextField(temp);
		}
		d.open();
	}
	
	public static void createAddPredmetDialog()
	{
		AddDialog d = new AddDialog(window, "Dodavanje predmeta", Dialog.EntityType.PREDMET);
		
		String[] labels = predmetiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addComboBox(temp, new String[] {"Letnji", "Zimski"});
			else if	(i==3)	d.addComboBox(temp, new String[] {"1", "2", "3", "4"});
			else 			d.addTextField(temp);
		}
		d.open();
	}
	
	public static void createEditStudentDialog(int tableRow, String[] data)
	{
		EditStudentDialog d = new EditStudentDialog(window, "Izmena studenta", Dialog.EntityType.STUDENT, new String[] {"Informacije", "Položeni", "Nepoloženi"});
		
		String[] labels = studentiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.tabPanels.get(0).addDateField(0, temp, data[i]);
			else if	(i==9)	d.tabPanels.get(0).addComboBox(0, temp, new String[] {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"}, Integer.parseInt(data[i]));
			else if	(i==10) d.tabPanels.get(0).addComboBox(0, temp, new String[] {"Budžet", "Samofinansiranje"}, Integer.parseInt(data[i]));
			else 			d.tabPanels.get(0).addTextField(0, temp, data[i]);
		}
		d.open();
	}
	
	public static void createEditProfesorDialog(int tableRow, String[] data)
	{
		EditProfesorDialog d = new EditProfesorDialog(window, "Izmena profesora", Dialog.EntityType.PROFESOR, new String[] {"Info", "Predmeti"});
		
		String[] labels = profesoriFieldLabels;	
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.tabPanels.get(0).addDateField(0, temp, data[i]);
			else 			d.tabPanels.get(0).addTextField(0, temp, data[i]);
		}
		
		d.open();
	}
	
	public static void createEditPredmetDialog(int tableRow, String[] data)
	{
		EditPredmetDialog d = new EditPredmetDialog(window, "Izmena predmeta", Dialog.EntityType.PREDMET);
		
		String[] labels = predmetiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addComboBox(temp, new String[] {"Letnji", "Zimski"}, Integer.parseInt(data[i]));
			else if	(i==3)	d.addComboBox(temp, new String[] {"1", "2", "3", "4"}, Integer.parseInt(data[i]));
			else 			d.addTextField(temp, data[i]);
		}
		
		d.open();
	}
	
	public static void createInvalidInputDialog(ArrayList<String> messages)
	{
		InvalidInputDialog d = new InvalidInputDialog(window, "ERROR: Invalid Input", messages);
		
		d.open();
	}
}













