package gui.manager;

import java.util.ArrayList;

import gui.table.Table;

public class TableManager {		
	private static final String[] studentiLabels = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };
	private static final String[] profesoriLabels = { "Ime", "Prezime", "Titula", "Zvanje"};
	private static final String[] predmetiLabels = { "Šifra predmeta", "Naziv predmeta", "Broj ESPB bodova", "Godina izvodjenja", "Semestar izvodjenja"};
	
	public static Table studentiTable = new Table(studentiLabels);
	public static Table profesoriTable = new Table(profesoriLabels);
	public static Table predmetiTable = new Table(predmetiLabels);
	
	public static Table[] tables = {studentiTable, profesoriTable, predmetiTable};
	
	public static void addRow(int tableIndex, String[] data)
	{
		tables[tableIndex].addRow(data);
	}
	
	public static void addRows(int tableIndex, ArrayList<String[]> dataArray)
	{
		tables[tableIndex].addRows(dataArray);
	}
	
	public static void insertRow(int tableIndex, String[] data, int row)
	{
		tables[tableIndex].insertRow(data, row);
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
	
	public static Table createNepolozeniTable(ArrayList<String[]> dataArray)
	{
		Table table = new Table(new String[] {"Šifra predmeta", "Naziv predmeta", "ESPB", "Godina studija", "Semestar"});
		for(String[] data: dataArray)
		{
			table.addRow(data);
		}
		return table;
	}
}


























