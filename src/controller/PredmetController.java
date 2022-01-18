package controller;
import java.util.ArrayList;

import gui.manager.TableManager;
import model.Predmet;
import model.data.Data;

public class PredmetController implements ControllerInterface {
    private static PredmetController instance = null;

    private PredmetController(){}

    public static PredmetController getInstance()
    {
        if(instance == null)
            instance = new PredmetController();
        return instance;
    }

    public boolean create(String[] arr, ArrayList<String> messages)
    {
        Predmet pr = Data.predmet.create(arr, messages);
        if(pr == null) return false;
        TableManager.addRow(2, pr.getTableData());
        return true;
    }

    public String[] getData(int index)
    {
        return Data.predmet.getData(index);
    }

    public boolean edit(String[] arr, int index, ArrayList<String> messages)
    {
        Predmet oldPredmet = Data.predmet.getAll().get(index);
        Predmet pr = Data.predmet.create(arr, messages, index);
        if(pr == null) return false;

        pr.setStudentiPolozeno(oldPredmet.getStudentiPolozeno());
        pr.setStudentiNepolozeno(oldPredmet.getStudentiNepolozeno());
        Data.updatePredmetReferences(oldPredmet, pr);
        

        TableManager.remove(2, index);
        TableManager.insertRow(2, pr.getTableData(), index);
        Data.predmet.delete(index+1);
        return true;
    }

    public void delete(int index)
    {
    	Predmet pr = Data.predmet.getAll().get(index);
    	
    	Data.updatePredmetReferences(pr, null);
    	
        TableManager.remove(2, index);
        Data.predmet.delete(index);
        
        
        
    }
}









