package gui.manager;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;
import gui.dialog.*;
import gui.dialog.add.AddDialog;
import gui.dialog.add.AddIspitDialog;
import gui.dialog.add.AddOcenaDialog;
import gui.dialog.add.AddPredmetProfesoruDialog;
import gui.dialog.edit.EditPredmetDialog;
import gui.dialog.edit.EditProfesorDialog;
import gui.dialog.edit.EditStudentDialog;
import gui.dialog.utility.ConfirmDialog;
import gui.dialog.utility.InvalidInputDialog;

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
			data = Controller.student.getData(tableRow);
			DialogManager.createEditStudentDialog(tableRow, data);
			break;
		case 1:
			data = Controller.profesor.getData(tableRow);
			DialogManager.createEditProfesorDialog(tableRow, data);
			break;
		case 2:
			data = Controller.predmet.getData(tableRow);
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
					Controller.student.delete(tableRow);
					d.setTitle("Brisanje studenta");
					break;
				case 1:
					Controller.profesor.delete(tableRow);
					d.setTitle("Brisanje profesora");
					break;
				case 2:
					Controller.predmet.delete(tableRow);
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
	
	public static void createRemoveOcenaDialog(EditStudentDialog editDialog, int gradeIndex)
	{
		ConfirmDialog d = new ConfirmDialog("Poništavanje ocene");
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.student.removeGrade(editDialog.getStudentIndex(), gradeIndex);
				editDialog.getPolozeniTable().removeRow(gradeIndex);	
				editDialog.setPolozeniLabels();
				editDialog.updateNepolozeniTable();
				d.close();
			}
		};
		d.setListener(listener);
		d.open();
	}
	
	public static void createRemovePredmetDialog(EditStudentDialog editDialog, int predmetIndex)
	{
		ConfirmDialog d = new ConfirmDialog("Uklanjanje predmeta");
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.student.removeFromPredmet(editDialog.getStudentIndex(), predmetIndex);
				editDialog.getNepolozeniTable().removeRow(predmetIndex);	
				d.close();
			}
		};
		d.setListener(listener);
		d.open();
	}
	
	public static void createAddIspitDialog(EditStudentDialog editDialog)
	{
		AddIspitDialog d = new AddIspitDialog(editDialog);
		d.open();
	}
	
	public static void createAddOcenaDialog(EditStudentDialog editDialog, int predmetIndex)
	{
		AddOcenaDialog d = new AddOcenaDialog(editDialog, predmetIndex);
		d.setSubmitEnabledEvents();
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
			else if	(i==9) 	d.addComboBox(temp, new String[] {"Budžet", "Samofinansiranje"});
			else 			d.addTextField(temp);
		}
		d.setSubmitEnabledEvents();
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
		d.setSubmitEnabledEvents();
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
			else if	(i==3)	d.addComboBox(temp, new String[] {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"});
			else 			d.addTextField(temp);
		}
		d.setSubmitEnabledEvents();
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
		d.setSubmitEnabledEvents();
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
		d.setSubmitEnabledEvents();
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
			else if	(i==3)	d.addComboBox(temp, new String[] {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"}, Integer.parseInt(data[i]));
			else 			d.addTextField(temp, data[i]);
		}
		d.setSubmitEnabledEvents();
		d.open();
	}
	
	public static void createDodajPredmetProfesoruDialog(EditProfesorDialog editDialog)
	{
		AddPredmetProfesoruDialog d = new AddPredmetProfesoruDialog(editDialog);
		d.open();
	}
	
	public static void createRemovePredmetProfesoruDialog(EditProfesorDialog editDialog, int predmetIndex)
	{
		
		ConfirmDialog d = new ConfirmDialog("Uklanjanje predmeta");
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.profesor.removePredmetFromProfesor(editDialog.getProfesorIndex(), predmetIndex);
				editDialog.getPredmetiTable().removeRow(predmetIndex);	
				d.close();
			}
		};
		d.setListener(listener);
		d.open();
	}
	
}













