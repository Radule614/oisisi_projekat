package gui.manager;

import java.util.ArrayList;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;
import gui.MainWindow;
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
	
	public static MainWindow main = MainWindow.getInstance();
	static protected String[] studentiFieldLabels = {main.GetLocalization("lblIme"), main.GetLocalization("lblPrezime"), main.GetLocalization("lblDatumRodjenja"), main.GetLocalization("lblAdresaStanovanja"), main.GetLocalization("lblBrojTelefona"), main.GetLocalization("lblEmail"), main.GetLocalization("lblBrojIndeka"), main.GetLocalization("lblGodinaUpisa"), main.GetLocalization("lblTrenutnaGodinaStudija"), main.GetLocalization("lblNacinFinansiranja")};
	static protected String[] profesoriFieldLabels = {main.GetLocalization("lblIme"), main.GetLocalization("lblPrezime"), main.GetLocalization("lblDatumRodjenja"),  main.GetLocalization("lblAdresaStanovanja"), main.GetLocalization("lblBrojTelefona"), main.GetLocalization("lblEmail"), main.GetLocalization("lblAdresaKancelarije"), main.GetLocalization("lblBrojLicneKarte"), main.GetLocalization("lblZvanje"), main.GetLocalization("lblGodineStaza")};
	static protected String[] predmetiFieldLabels = {main.GetLocalization("lblSifraPredmeta"), main.GetLocalization("lblNazivPredmeta"), main.GetLocalization("lblSemestar"), main.GetLocalization("lblGodinaStudija"), main.GetLocalization("lblBrojEPSBBodova"), main.GetLocalization("lblProfesor")};
	
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
			d.setTitle(main.GetLocalization("titleBrisanjeStudenata"));
			break;
		case 1:
			d.setTitle(main.GetLocalization("titleBrisanjeProfesora"));
			break;
		case 2:
			d.setTitle(main.GetLocalization("titleBrisanjePredmeta"));
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
					d.setTitle(main.GetLocalization("titleBrisanjeStudenata"));
					break;
				case 1:
					Controller.profesor.delete(tableRow);
					d.setTitle(main.GetLocalization("titleBrisanjeProfesora"));
					break;
				case 2:
					Controller.predmet.delete(tableRow);
					d.setTitle(main.GetLocalization("titleBrisanjePredmeta"));
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
		InvalidInputDialog d = new InvalidInputDialog(main.GetLocalization("lblGreskaPodaci"), messages);
		
		d.open();
	}
	
	public static void createRemoveOcenaDialog(EditStudentDialog editDialog, int gradeIndex)
	{
		ConfirmDialog d = new ConfirmDialog(main.GetLocalization("btnPonistiOcenu"));
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
		ConfirmDialog d = new ConfirmDialog(main.GetLocalization("btnUkloniPredmet"));
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
		AddDialog d = new AddDialog(main.GetLocalization("titleAddStudent"), Dialog.EntityType.STUDENT);
		
		String[] labels = studentiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addDateField(temp);
			else if	(i==8)	d.addComboBox(temp, new String[] {main.GetLocalization("lblPrva"), main.GetLocalization("lblDruga"), main.GetLocalization("lblTreca"), main.GetLocalization("lblCetvrta")});
			else if	(i==9) 	d.addComboBox(temp, new String[] {main.GetLocalization("lblBudzet"), main.GetLocalization("lblSamofinansiranje")});
			else d.addTextField(temp);
			
		}
		d.setSubmitEnabledEvents();
		d.open();
	}
	
	private static void createAddProfesorDialog()
	{
		AddDialog d = new AddDialog(main.GetLocalization("titleAddProfesor"), Dialog.EntityType.PROFESOR);
		
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
		AddDialog d = new AddDialog(main.GetLocalization("titleAddPredmet"), Dialog.EntityType.PREDMET);
		
		String[] labels = predmetiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addComboBox(temp, new String[] {main.GetLocalization("lblLetnji"), main.GetLocalization("lblZimski")});
			else if	(i==3)	d.addComboBox(temp, new String[] {main.GetLocalization("lblPrva"), main.GetLocalization("lblDruga"), main.GetLocalization("lblTreca"), main.GetLocalization("lblCetvrta")});
			else 			d.addTextField(temp);
		}
		d.setSubmitEnabledEvents();
		d.open();
	}
	
	private static void createEditStudentDialog(int tableRow, String[] data)
	{
		EditStudentDialog d = new EditStudentDialog(main.GetLocalization("titleIzmenaStudenta"), Dialog.EntityType.STUDENT, tableRow, new String[] {"Informacije", "Položeni", "Nepoloženi"});
		
		String[] labels = studentiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.tabPanels.get(0).addDateField(0, temp, data[i]);
			else if	(i==8)	d.tabPanels.get(0).addComboBox(0, temp, new String[] {main.GetLocalization("lblPrva"), main.GetLocalization("lblDruga"), main.GetLocalization("lblTreca"), main.GetLocalization("lblCetvrta")}, Integer.parseInt(data[i]));
			else if	(i==9) d.tabPanels.get(0).addComboBox(0, temp, new String[] {main.GetLocalization("lblBudzet"), main.GetLocalization("lblSamofinansiranje")}, Integer.parseInt(data[i]));
			else 			d.tabPanels.get(0).addTextField(0, temp, data[i]); 
		}
		d.setSubmitEnabledEvents();
		d.open();
	}
	
	private static void createEditProfesorDialog(int tableRow, String[] data)
	{
		EditProfesorDialog d = new EditProfesorDialog(main.GetLocalization("titleIzmenaProfesora"), Dialog.EntityType.PROFESOR, tableRow, new String[] {"Info", "Predmeti"});
		
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
		EditPredmetDialog d = new EditPredmetDialog(main.GetLocalization("titleIzmenaPredmeta"), tableRow, Dialog.EntityType.PREDMET);
		
		String[] labels = predmetiFieldLabels;
		for(int i = 0; i < labels.length; ++i)
		{
			String temp = labels[i] + "*";
			if		(i==2) 	d.addComboBox(temp, new String[] {MainWindow.getInstance().GetResourceBundle().getObject("lblLetnji").toString(), MainWindow.getInstance().GetResourceBundle().getObject("lblZimski").toString()}, Integer.parseInt(data[i]));
			else if	(i==3)	d.addComboBox(temp, new String[] {main.GetLocalization("lblPrva"), main.GetLocalization("lblDruga"), main.GetLocalization("lblTreca"), main.GetLocalization("lblCetvrta")}, Integer.parseInt(data[i]));
			else if (i==4)			d.addTextField(temp, data[i]);
			else if(i ==5)  d.addTextField(temp, data[i], 0);
			else
			{
				d.addTextField(temp, data[i]);
			}	
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
		
		ConfirmDialog d = new ConfirmDialog(main.GetLocalization("titleRemovePredmet"));
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













