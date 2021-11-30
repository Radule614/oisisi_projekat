package gui.dialog;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;
import gui.dialog.edit.EditPredmetDialog;
import gui.dialog.edit.EditProfesorDialog;
import gui.dialog.edit.EditStudentDialog;

public class DialogManager {
	static protected String[] studentiFieldLabels = {"Ime", "Prezime", "Datum rođenja", "Adresa stanonovanja", "Broj telefona", "E-mail adresa", "Broj indeksa", "Godina upisa", "Trenutna godina studija", "Način finansiranja"};
	static protected String[] profesoriFieldLabels = {"Ime", "Prezime", "Datum rođenja", "Adresa stanonovanja", "Broj telefona", "E-mail adresa", "Adresa kancelarije", "Broj lične karte", "Titula", "Zvanje", "Godine staža"};
	static protected String[] predmetiFieldLabels = {"Sifra predmeta", "Naziv predmeta", "Semestar", "Godina studija", "Broj ESPB bodova"};
	
	public static void createAddDialog(int activeTab)
	{
		switch(activeTab)
		{
		case 0:
			DialogManager.createAddStudentDialog();
			break;
		case 1:
			DialogManager.createAddProfesorDialog();
			break;
		case 2:
			DialogManager.createAddPredmetDialog();
			break;
		default:;
		}
	}
	
	public static void createEditDialog(int activeTab, int tableRow)
	{
		String[] data;
		switch(activeTab)
		{
		case 0:
			data = Controller.getStudentData(tableRow);
			DialogManager.createEditStudentDialog(tableRow, data);
			break;
		case 1:
			data = Controller.getProfesorData(tableRow);
			DialogManager.createEditProfesorDialog(tableRow, data);
			break;
		case 2:
			data = Controller.getPredmetData(tableRow);
			DialogManager.createEditPredmetDialog(tableRow, data);
			break;
		default:;
		}
	}
	
	public static void createDeleteDialog(int activeTab, int tableRow)
	{
		ConfirmDialog d = new ConfirmDialog();
		
		switch(activeTab)
		{
		case 0:
			d.setTitle("Brisanje studenta");
			break;
		case 1:
			d.setTitle("Brisanje profesora");
			break;
		case 2:
			d.setTitle("Brisanje predmeta");
			break;
		default:;
		}
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				switch(activeTab)
				{
				case 0:
					Controller.deleteStudent(tableRow);
					d.setTitle("Brisanje studenta");
					break;
				case 1:
					Controller.deleteProfesor(tableRow);
					d.setTitle("Brisanje profesora");
					break;
				case 2:
					Controller.deletePredmet(tableRow);
					d.setTitle("Brisanje predmeta");
					break;
				default:;
				}
				d.close();
			}
		};
		d.setListener(listener);
		d.open();
	}

	public static void createInvalidInputDialog(ArrayList<String> messages)
	{
		InvalidInputDialog d = new InvalidInputDialog("Greška: podaci nisu validni", messages);
		
		d.open();
	}
	
	
	
	//private
	
	private static void createAddStudentDialog()
	{
		AddDialog d = new AddDialog("Dodavanje studenta", Dialog.EntityType.STUDENT);
		
		String[] labels = studentiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addDateField(temp);
			else if	(i==8)	d.addComboBox(temp, new String[] {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"});
			else if	(i==9) d.addComboBox(temp, new String[] {"Budžet", "Samofinansiranje"});
			else 			d.addTextField(temp);
		}
		d.open();
	}
	
	private static void createAddProfesorDialog()
	{
		AddDialog d = new AddDialog("Dodavanje profesora", Dialog.EntityType.PROFESOR);
		
		String[] labels = profesoriFieldLabels;	
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addDateField(temp);
			else 			d.addTextField(temp);
		}
		d.open();
	}
	
	private static void createAddPredmetDialog()
	{
		AddDialog d = new AddDialog("Dodavanje predmeta", Dialog.EntityType.PREDMET);
		
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
	
	private static void createEditStudentDialog(int tableRow, String[] data)
	{
		EditStudentDialog d = new EditStudentDialog("Izmena studenta", Dialog.EntityType.STUDENT, tableRow, new String[] {"Informacije", "Položeni", "Nepoloženi"});
		
		String[] labels = studentiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.tabPanels.get(0).addDateField(0, temp, data[i]);
			else if	(i==8)	d.tabPanels.get(0).addComboBox(0, temp, new String[] {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"}, Integer.parseInt(data[i]));
			else if	(i==9) d.tabPanels.get(0).addComboBox(0, temp, new String[] {"Budžet", "Samofinansiranje"}, Integer.parseInt(data[i]));
			else 			d.tabPanels.get(0).addTextField(0, temp, data[i]);
		}
		d.open();
	}
	
	private static void createEditProfesorDialog(int tableRow, String[] data)
	{
		EditProfesorDialog d = new EditProfesorDialog("Izmena profesora", Dialog.EntityType.PROFESOR, tableRow, new String[] {"Info", "Predmeti"});
		
		String[] labels = profesoriFieldLabels;	
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.tabPanels.get(0).addDateField(0, temp, data[i]);
			else 			d.tabPanels.get(0).addTextField(0, temp, data[i]);
		}
		
		d.open();
	}
	
	private static void createEditPredmetDialog(int tableRow, String[] data)
	{
		EditPredmetDialog d = new EditPredmetDialog("Izmena predmeta", tableRow, Dialog.EntityType.PREDMET);
		
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
	
	
}













