package gui.table;

import javax.swing.RowFilter;

public class MyRowFilter extends RowFilter {
	
	private String searchText;
	
	private String ime, prezime, index;
	
	private int indeksPoslednjegPojavljivanja, indeksPrvogPojavljivanja, tipPretrage, vrstaTabele;
	
	///vrstaTabele 0.Student, 1.Profesor, 2. Predmet
	public MyRowFilter(String searchText, int vrstaTabele)
	{
		this.searchText = searchText.toLowerCase();
		indeksPoslednjegPojavljivanja = searchText.lastIndexOf(',');
		indeksPrvogPojavljivanja = searchText.indexOf(',');
		this.vrstaTabele = vrstaTabele;
		
		if(indeksPrvogPojavljivanja == indeksPoslednjegPojavljivanja) //IME I PREZIME
		{
			tipPretrage = 0;
		}
		
		if(indeksPrvogPojavljivanja == -1)
		{
			tipPretrage = 1;  //PREZIME
		}
		else if(indeksPrvogPojavljivanja != indeksPoslednjegPojavljivanja)
		{
			tipPretrage = 2; //IME PREZIME INDEKS
		}
	
	}
	
	@Override
	public boolean include(Entry entry) {
		
		if(tipPretrage == 0)
		{			
			try 
			{
				prezime = searchText.substring(0, indeksPrvogPojavljivanja);
				ime = searchText.substring(indeksPrvogPojavljivanja+2);
		
				prezime = prezime.toLowerCase();
				ime = ime.toLowerCase();
				System.out.println("0 |" + prezime + "| |" + ime +"|");
				if(vrstaTabele == 0) 
				{
					return entry.getStringValue(2).toLowerCase().indexOf(prezime) >= 0 && entry.getStringValue(1).toLowerCase().indexOf(ime) >= 0;
				}
				else
				{
					return entry.getStringValue(1).toLowerCase().indexOf(prezime) >= 0 && entry.getStringValue(0).toLowerCase().indexOf(ime) >= 0;
				}
			}
			catch(Exception e) 
			{
				  //  Block of code to handle errors
			}
			
			
		
		}
		else if(tipPretrage == 1)
		{
			try {
				if(vrstaTabele == 0) 
				{
					return entry.getStringValue(2).toLowerCase().indexOf(searchText) >= 0;
				}
				else
				{
					return entry.getStringValue(1).toLowerCase().indexOf(searchText) >= 0;
				}
			}
			catch(Exception e)
			{}
			
		}
		else if(tipPretrage == 2 && vrstaTabele == 0)
		{
			
			try 
			{
				prezime = searchText.substring(0, indeksPrvogPojavljivanja);
				prezime =prezime.toLowerCase();
				ime = searchText.substring(indeksPrvogPojavljivanja+2, indeksPoslednjegPojavljivanja);
				ime = ime.toLowerCase();
				index = searchText.substring(indeksPoslednjegPojavljivanja+2);
				index = index.toLowerCase();
				return entry.getStringValue(2).toLowerCase().indexOf(prezime) >= 0 && entry.getStringValue(1).toLowerCase().indexOf(ime) >= 0 && entry.getStringValue(0).toLowerCase().indexOf(index) >= 0;
			}
			catch(Exception e) 
			{
				
			}
		}
		
		return false;
	}

}
