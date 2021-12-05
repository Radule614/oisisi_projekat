package controller;
import java.util.ArrayList;

import gui.manager.TableManager;
import model.Predmet;
import model.data.Data;

class PredmetController {
	static boolean create(String[] arr, ArrayList<String> messages)
	{
		Predmet pr = Data.createPredmet(arr, messages);
		if(pr == null) return false;
		TableManager.addRow(2, pr.getTableData());
		return true;
	}
	
	static String[] getData(int index)
	{
		String[] data = Data.getPredmetData(index);
		return data;
	}

	static Predmet get(int index)
	{
		return Data.getPredmeti().get(index);
	}

	static boolean edit(String[] arr, int index, ArrayList<String> messages)
	{
		Predmet oldPredmet = Data.getPredmeti().get(index);
		Predmet pr = Data.createPredmet(arr, messages, index);
		if(pr == null) return false;
		
		pr.setStudentiPolozeno(oldPredmet.getStudentiPolozeno());
		pr.setStudentiNepolozeno(oldPredmet.getStudentiNepolozeno());
		
		TableManager.remove(2, index);
		TableManager.insertRow(2, pr.getTableData(), index);
		Data.deletePredmet(index+1);
		return true;
	}

	static void delete(int index)
	{
		TableManager.remove(2, index);
		Data.deletePredmet(index);
	}
}
