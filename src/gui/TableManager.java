package gui;

import java.util.ArrayList;

import model.Predmet;
import model.Profesor;
import model.Student;

public class TableManager {	
	protected ArrayList<Table> tables;
	
	protected Table studentiTable;
	protected Table profesoriTable;
	protected Table predmetiTable;
	
	protected final String[] studentiLabels = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };
	protected final String[] profesoriLabels = { "Ime", "Prezime", "Titula", "Zvanje"};
	protected final String[] predmetiLabels = { "Šifra predmeta", "Naziv predmeta", "Broj ESPB bodova", "Godina izvodjenja", "Semestar izvodjenja"};
	
	public TableManager()
	{
		tables = new ArrayList<Table>();
		studentiTable = new Table(studentiLabels);
		profesoriTable = new Table(profesoriLabels);
		predmetiTable = new Table(predmetiLabels);
		tables.add(studentiTable);
		tables.add(profesoriTable);
		tables.add(predmetiTable);
	}
	
	public void add(Object obj)
	{
		if(obj instanceof Student)
		{
			Student st = (Student)obj;
			Object[] data = {st.getBrojIndeksa(), st.getIme(), st.getPrezime(), st.getTrenutnaGodina(), st.getStatus(), st.getProsek()};
			studentiTable.addRow(data);
		}
		else if(obj instanceof Profesor)
		{
			Profesor pf = (Profesor)obj;
			Object[] data = {pf.getIme(), pf.getPrezime(), pf.getTitula(), pf.getZvanje()};
			profesoriTable.addRow(data);
		}
		else if(obj instanceof Predmet)
		{
			Predmet pr = (Predmet)obj;
			Object[] data = {pr.getSifra(), pr.getNaziv(), pr.getESPB(), pr.getGodinaStudija(), pr.getSemestar()};
			predmetiTable.addRow(data);
		}
		else if(obj instanceof ArrayList)
		{
			for(Object item: (ArrayList<?>)obj)
			{
				this.add(item);
			}
		}
	}
	
	public int getSelectedTableRow(int tableIndex)
	{
		return this.tables.get(tableIndex).getSelectedRow();
	}
	
	public ArrayList<Table> getTables()
	{
		return this.tables;
	}
}


























