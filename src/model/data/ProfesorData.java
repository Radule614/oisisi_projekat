package model.data;

import java.util.ArrayList;

import app.Utility;
import model.Profesor;

class ProfesorData {
	static ArrayList<Profesor> profesori = new ArrayList<Profesor>();
	
	static ArrayList<String[]> toTableDataArray()
	{
		ArrayList<String[]> dataArray = new ArrayList<String[]>();
		for(Profesor temp: profesori) dataArray.add(temp.getTableData());
		return dataArray;
	}
	
	static Profesor create(String[] arr, ArrayList<String> messages, int index)
	{
		arr = Utility.trimEach(arr);
		if(!Profesor.isValidData(arr, messages)) return null;
		if(messages != null && exists(Utility.parseInt(arr[7]), index))
		{
			messages.add("Profesor sa brojem lične karte " + arr[7] + " već postoji.");
			return null;
		}
		Profesor pf = new Profesor(arr);
		profesori.add(index, pf);
		return pf;
	}
	
	static Profesor create(String[] arr, ArrayList<String> messages)
	{
		return create(arr, messages, profesori.size());
	}
	
	static void delete(int index)
	{
		profesori.remove(index);
	}
	
	static String[] getData(int index)
	{
		Profesor pr = profesori.get(index);
		String[] data = pr.toStringArray();
		
		return data;
	}
	
	static ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	
	static boolean exists(int key)
	{
		return exists(key, -1);
	}
	
	static boolean exists(int key, int index)
	{
		for(int i = 0; i < profesori.size(); ++i)
		{
			if(index == i) continue;
			if(profesori.get(i).getLicnaKarta() == key) return true;
		}
		return false;
	}
}
















