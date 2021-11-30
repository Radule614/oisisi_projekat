package gui.table;

import java.util.ArrayList;

import model.structure.Predmet;
import model.structure.Profesor;
import model.structure.Student;

public class TableManager {		
	private static final String[] studentiLabels = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };
	private static final String[] profesoriLabels = { "Ime", "Prezime", "Titula", "Zvanje"};
	private static final String[] predmetiLabels = { "Šifra predmeta", "Naziv predmeta", "Broj ESPB bodova", "Godina izvodjenja", "Semestar izvodjenja"};
	
	public static Table studentiTable = new Table(studentiLabels);
	public static Table profesoriTable = new Table(profesoriLabels);
	public static Table predmetiTable = new Table(predmetiLabels);
	
	public static Table[] tables = {studentiTable, profesoriTable, predmetiTable};
	
	public static void add(Object obj, int row)
	{
		if(obj instanceof Student)
		{
			Student st = (Student)obj;
			Object[] data = {st.getBrojIndeksa(), st.getIme(), st.getPrezime(), st.getTrenutnaGodina(), st.getStatus(), st.getProsek()};
			if(row == - 1)  studentiTable.addRow(data);
			else			studentiTable.insertRow(data, row);
		}
		else if(obj instanceof Profesor)
		{
			Profesor pf = (Profesor)obj;
			Object[] data = {pf.getIme(), pf.getPrezime(), pf.getTitula(), pf.getZvanje()};
			if(row == - 1)  profesoriTable.addRow(data);
			else			profesoriTable.insertRow(data, row);
		}
		else if(obj instanceof Predmet)
		{
			Predmet pr = (Predmet)obj;
			Object[] data = {pr.getSifra(), pr.getNaziv(), pr.getESPB(), pr.getGodinaStudija(), pr.getSemestar()};
			if(row == - 1)  predmetiTable.addRow(data);
			else			predmetiTable.insertRow(data, row);
		}
		else if(obj instanceof ArrayList)
		{
			for(Object item: (ArrayList<?>)obj)
			{
				TableManager.add(item, -1);
			}
		}
	}
	
	public static void add(Object obj)
	{
		TableManager.add(obj, -1);
	}
	
	public static void remove(int tableIndex, int tableRow)
	{
		TableManager.tables[tableIndex].removeRow(tableRow);
	}
	
	public static int getSelectedTableRow(int tableIndex)
	{
		return TableManager.tables[tableIndex].getSelectedRow();
	}
	
	public static Table[] getTables()
	{
		return TableManager.tables;
	}
	
	public static Table createPolozeniTable(ArrayList<String[]> dataArray)
	{
		Table table = new Table(new String[] {"Šifra predmeta", "Naziv predmeta", "ESPB", "Ocena", "Datum"});
		for(String[] data: dataArray)
		{
			table.addRow(data);
		}
		return table;
	}
}


























