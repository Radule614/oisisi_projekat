package controller;
import java.util.ArrayList;

import gui.table.TableManager;
import model.DataManager;
import model.structure.Predmet;

class PredmetController {
	static boolean create(String[] arr, ArrayList<String> messages)
	{
		Predmet pr = DataManager.createPredmet(arr, messages);
		if(pr == null) return false;
		TableManager.add(pr);
		return true;
	}
	
	static String[] getData(int index)
	{
		String[] data = DataManager.getPredmetData(index);
		return data;
	}

	static Predmet get(int index)
	{
		return DataManager.getPredmeti().get(index);
	}

	static boolean edit(String[] arr, int index, ArrayList<String> messages)
	{
		Predmet oldPredmet = DataManager.getPredmeti().get(index);
		Predmet pr = DataManager.createPredmet(arr, messages, index);
		if(pr == null) return false;
		
		pr.setStudentiPolozeno(oldPredmet.getStudentiPolozeno());
		pr.setStudentiNepolozeno(oldPredmet.getStudentiNepolozeno());
		
		TableManager.remove(2, index);
		TableManager.add(pr, index);
		DataManager.deletePredmet(index+1);
		return true;
	}

	static void delete(int index)
	{
		TableManager.remove(2, index);
		DataManager.deletePredmet(index);
	}
}
