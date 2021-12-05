package model.data;

import java.util.ArrayList;

import app.Utility;
import model.Predmet;

class PredmetData {
	static ArrayList<Predmet> predmeti = new ArrayList<Predmet>();

	static ArrayList<String[]> toTableDataArray()
	{
		ArrayList<String[]> dataArray = new ArrayList<String[]>();
		for(Predmet temp: predmeti) dataArray.add(temp.getTableData());
		return dataArray;
	}

	static Predmet create(String[] arr, ArrayList<String> messages, int index)
	{
		arr = Utility.trimEach(arr);
		if(!Predmet.isValidData(arr, messages)) return null;
		if(messages != null && exists(arr[0], index))
		{
			messages.add("Predmet sa šifrom " + arr[0] + " već postoji.");
			return null;
		}
		Predmet pr = new Predmet(arr);
		predmeti.add(index, pr);
		return pr;
	}
	
	static Predmet create(String[] arr, ArrayList<String> messages)
	{
		return create(arr, messages, predmeti.size());
	}
	
	static void delete(int index)
	{
		predmeti.remove(index);
	}
	
	static String[] getData(int index)
	{
		Predmet pr = predmeti.get(index);
		String[] data = pr.toStringArray();
		
		return data;
	}
	
	static ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	static boolean exists(String key)
	{
		return exists(key, -1);
	}

	static boolean exists(String key, int index)
	{
		for(int i = 0; i < predmeti.size(); ++i)
		{
			if(index == i) continue;
			if(predmeti.get(i).getSifra().equals(key)) return true;
		}
		return false;
	}
}
