package gui.manager;

import java.util.ArrayList;

import gui.MainWindow;
import gui.table.Table;

public class TableManager {		
	public static MainWindow main = MainWindow.getInstance();
	
	public static TableManager instance;
	private static final String[] studentiLabels = { main.GetLocalization("lblBrojIndeka"), main.GetLocalization("lblIme"), main.GetLocalization("lblPrezime"),  main.GetLocalization("lblTrenutnaGodinaStudija"),  main.GetLocalization("lblNacinFinansiranja"), main.GetLocalization("lblAverageGrade")};
	private static final String[] profesoriLabels = { main.GetLocalization("lblIme"), main.GetLocalization("lblPrezime"), main.GetLocalization("lblEmail"), main.GetLocalization("lblZvanje")};
	private static final String[] predmetiLabels = { main.GetLocalization("lblSifraPredmeta"), main.GetLocalization("lblNazivPredmeta"), main.GetLocalization("lblBrojEPSBBodova"), main.GetLocalization("lblGodinaStudija"), main.GetLocalization("lblSemestar")};
	
	public static Table studentiTable = new Table(studentiLabels);
	public static Table profesoriTable = new Table(profesoriLabels);
	public static Table predmetiTable = new Table(predmetiLabels);
	
	public static Table[] tables = {studentiTable, profesoriTable, predmetiTable};
	
	
	public static void RefreshTables()
	{
		
		studentiTable.getColumnModel().getColumn(0).setHeaderValue(main.GetLocalization("lblBrojIndeka"));
		studentiTable.getColumnModel().getColumn(1).setHeaderValue(main.GetLocalization("lblIme"));
		studentiTable.getColumnModel().getColumn(2).setHeaderValue(main.GetLocalization("lblPrezime"));
		studentiTable.getColumnModel().getColumn(3).setHeaderValue(main.GetLocalization("lblTrenutnaGodinaStudija"));
		studentiTable.getColumnModel().getColumn(4).setHeaderValue(main.GetLocalization("lblNacinFinansiranja"));
		studentiTable.getColumnModel().getColumn(5).setHeaderValue(main.GetLocalization("lblAverageGrade"));
		
		profesoriTable.getColumnModel().getColumn(0).setHeaderValue(main.GetLocalization("lblIme"));
		profesoriTable.getColumnModel().getColumn(1).setHeaderValue(main.GetLocalization("lblPrezime"));
		profesoriTable.getColumnModel().getColumn(2).setHeaderValue(main.GetLocalization("lblEmail"));
		profesoriTable.getColumnModel().getColumn(3).setHeaderValue(main.GetLocalization("lblZvanje"));
		
		predmetiTable.getColumnModel().getColumn(0).setHeaderValue(main.GetLocalization("lblSifraPredmeta"));
		predmetiTable.getColumnModel().getColumn(1).setHeaderValue(main.GetLocalization("lblNazivPredmeta"));
		predmetiTable.getColumnModel().getColumn(2).setHeaderValue(main.GetLocalization("lblBrojEPSBBodova"));
		predmetiTable.getColumnModel().getColumn(3).setHeaderValue(main.GetLocalization("lblGodinaStudija"));
		predmetiTable.getColumnModel().getColumn(4).setHeaderValue(main.GetLocalization("lblSemestar"));
		
		
	}
	
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
		return TableManager.tables[tableIndex].getSelectedRowFromModel();
	}
	
	public static Table[] getTables()
	{
		return TableManager.tables;
	}
	
	public static Table createPolozeniTable(ArrayList<String[]> dataArray)
	{
		Table table = new Table(new String[] {main.GetLocalization("lblSifraPredmeta"), main.GetLocalization("lblNazivPredmeta"), "ESPB", main.GetLocalization("lblOcena"), main.GetLocalization("lblDatum")});
		for(String[] data: dataArray)
		{
			table.addRow(data);
		}
		return table;
	}
	
	public static Table createProfesorPredmetiTable(ArrayList<String[]> dataArray)
	{
		Table table = new Table(new String[] {main.GetLocalization("lblSifraPredmeta"), main.GetLocalization("lblNazivPredmeta"), main.GetLocalization("lblGodinaStudija"), main.GetLocalization("lblSemestar")});
		for(String[] data: dataArray)
		{
			table.addRow(data);
		}
		return table;
	}
	
	public static Table createNepolozeniTable(ArrayList<String[]> dataArray)
	{
		Table table = new Table(new String[] {main.GetLocalization("lblSifraPredmeta"), main.GetLocalization("lblNazivPredmeta"), "ESPB", main.GetLocalization("lblGodinaStudija"), main.GetLocalization("lblSemestar")});
		for(String[] data: dataArray)
		{
			table.addRow(data);
		}
		return table;
	}
	
	public static Table createIspitiTable(ArrayList<String[]> dataArray)
	{
		Table table = new Table(1);
		
		for(String[] data: dataArray)
		{
			table.addRow(data);
		}
		return table;
	}
}


























