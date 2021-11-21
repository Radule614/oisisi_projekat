package gui;

import javax.swing.*;

public class DialogManager {
	protected Dialog addStudentDialog;
	protected Dialog addProfesorDialog;
	protected Dialog addPredmetDialog;
	
	JFrame window;
	
	protected final String format = "dd/MM/yyyy";
	
	public DialogManager(JFrame frame)
	{
		this.window = frame;
	}

	protected void createAddStudentDialog()
	{
		Dialog d = new Dialog(window, "Dodavanje studenta", Dialog.EntityType.STUDENT);
		addStudentDialog = d;
		
		d.addField("Ime*");
		d.addField("Prezime*");
		d.addField("Datum rođenja*", format);
		d.addField("Adresa stanonovanja*");
		d.addField("Broj telefona*");
		d.addField("E-mail adresa*");
		d.addField("Broj indeksa*");
		d.addField("Godina upisa*");
		d.addField("Prosek*");
		d.addField("Trenutna godina studija*", new String[] {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"});
		d.addField("Način finansiranja*", new String[] {"Budžet", "Samofinansiranje"});
		
		d.open();
	}
	
	protected void createAddProfesorDialog()
	{
		Dialog d = new Dialog(window, "Dodavanje profesora", Dialog.EntityType.PROFESOR);
		addProfesorDialog = d;
		
		d.addField("Ime*");
		d.addField("Prezime*");
		d.addField("Datum rođenja*", format);
		d.addField("Adresa stanonovanja*");
		d.addField("Broj telefona*");
		d.addField("E-mail adresa*");
		d.addField("Adresa kancelarije*");
		d.addField("Broj lične karte*");
		d.addField("Titula*");
		d.addField("Zvanje*");
		d.addField("Godine staža*");
		
		d.open();
	}
	
	protected void createAddPredmetDialog()
	{
		Dialog d = new Dialog(window, "Dodavanje predmeta", Dialog.EntityType.PREDMET);
		addPredmetDialog = d;
		
		d.addField("Sifra predmeta*");
		d.addField("Naziv predmeta*");
		d.addField("Semestar*", new String[] {"Letnji", "Zimski"});
		d.addField("Godina studija*");
		d.addField("Broj ESPB bodova*");
		
		d.open();
	}
}













