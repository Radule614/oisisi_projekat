package model.data;

import java.util.ArrayList;

import app.Utility;
import gui.MainWindow;
import model.Predmet;

public class PredmetData implements DataInterface<Predmet, String> {
    private static PredmetData instance = null;
    private ArrayList<Predmet> predmeti = new ArrayList<Predmet>();

    private PredmetData() {}

    public static PredmetData getInstance()
    {
        if(instance == null)
            instance = new PredmetData();
        return instance;
    }

    public ArrayList<String[]> toTableDataArray()
    {
        ArrayList<String[]> dataArray = new ArrayList<String[]>();
        for(Predmet temp: predmeti) dataArray.add(temp.getTableData());
        return dataArray;
    }

    public Predmet create(String[] arr, ArrayList<String> messages, int index)
    {
        arr = Utility.trimEach(arr);
        if(!Predmet.isValidData(arr, messages)) return null;
        if(messages != null && exists(arr[0], index))
        {
            messages.add(MainWindow.getInstance().GetLocalization("warnSubjectExists") +  " " + arr[0] + MainWindow.getInstance().GetLocalization("warnExists"));
            return null;
        }
        Predmet pr = new Predmet(arr);
        predmeti.add(index, pr);
        return pr;
    }

    public Predmet create(String[] arr, ArrayList<String> messages)
    {
        return create(arr, messages, predmeti.size());
    }

    public void delete(int index)
    {
        predmeti.remove(index);
    }

    public String[] getData(int index)
    {
        Predmet pr = predmeti.get(index);
        return pr.toStringArray();
    }

    public ArrayList<Predmet> getAll() {
        return predmeti;
    }

    public void setAll(ArrayList<Predmet> arr)
    {
        predmeti = arr;
    }

    public boolean exists(String key)
    {
        return exists(key, -1);
    }

    public boolean exists(String key, int index)
    {
        for(int i = 0; i < predmeti.size(); ++i)
        {
            if(index == i) continue;
            if(predmeti.get(i).getSifra().equals(key)) return true;
        }
        return false;
    }
}
