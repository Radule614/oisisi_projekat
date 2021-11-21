package gui.dialog;

import javax.swing.*;

public class DialogManager {
	protected String[] studentiFieldLabels = {"Ime", "Prezime", "Datum rođenja", "Adresa stanonovanja", "Broj telefona", "E-mail adresa", "Broj indeksa", "Godina upisa", "Prosek", "Trenutna godina studija", "Način finansiranja"};
	protected String[] profesoriFieldLabels = {"Ime", "Prezime", "Datum rođenja", "Adresa stanonovanja", "Broj telefona", "E-mail adresa", "Adresa kancelarije", "Broj lične karte", "Titula", "Zvanje", "Godine staža"};
	protected String[] predmetiFieldLabels = {"Sifra predmeta", "Naziv predmeta", "Semestar", "Godina studija", "Broj ESPB bodova"};
	
	JFrame window;
	
	public DialogManager(JFrame frame)
	{
		this.window = frame;
	}

	public void createAddStudentDialog()
	{
		AddDialog d = new AddDialog(window, "Dodavanje studenta", Dialog.EntityType.STUDENT);
		
		String[] labels = this.studentiFieldLabels;
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
	
	public void createAddProfesorDialog()
	{
		AddDialog d = new AddDialog(window, "Dodavanje profesora", Dialog.EntityType.PROFESOR);
		
		String[] labels = this.profesoriFieldLabels;	
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addDateField(temp);
			else 			d.addTextField(temp);
		}
		d.open();
	}
	
	public void createAddPredmetDialog()
	{
		AddDialog d = new AddDialog(window, "Dodavanje predmeta", Dialog.EntityType.PREDMET);
		
		String[] labels = this.predmetiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addComboBox(temp, new String[] {"Letnji", "Zimski"});
			else 			d.addTextField(temp);
		}
		d.open();
	}
	
	public void createEditStudentDialog(int tableRow, String[] data)
	{
		MultiTabDialog d = new MultiTabDialog(window, "Izmena studenta", Dialog.EntityType.STUDENT, new String[] {"Informacije", "Položeni", "Nepoloženi"});
		
		String[] labels = this.studentiFieldLabels;
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
	
	public void createEditProfesorDialog(int tableRow, String[] data)
	{
		MultiTabDialog d = new MultiTabDialog(window, "Izmena profesora", Dialog.EntityType.PROFESOR, new String[] {"Info", "Predmeti"});
		
		//TODO
		
		d.open();
	}
	
	public void createEditPredmetDialog(int tableRow, String[] data)
	{
		OneTabDialog d = new OneTabDialog(window, "Izmena predmeta", Dialog.EntityType.PREDMET);
		
		//TODO
		
		d.open();
	}
	
	
}













