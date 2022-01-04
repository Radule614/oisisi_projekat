package model.data;

import java.util.ArrayList;

import app.Utility;
import model.Profesor;

public class ProfesorData implements DataInterface<Profesor, Integer> {
    private static ProfesorData instance = null;
    private ArrayList<Profesor> profesori = new ArrayList<Profesor>();

    private ProfesorData(){}

    public static ProfesorData getInstance()
    {
        if(instance == null)
            instance = new ProfesorData();
        return instance;
    }

    public ArrayList<String[]> toTableDataArray()
    {
        ArrayList<String[]> dataArray = new ArrayList<String[]>();
        for(Profesor temp: profesori) dataArray.add(temp.getTableData());
        return dataArray;
    }

    public Profesor create(String[] arr, ArrayList<String> messages, int index)
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

    public Profesor create(String[] arr, ArrayList<String> messages)
    {
        return create(arr, messages, profesori.size());
    }

    public void delete(int index)
    {
        profesori.remove(index);
    }

    public String[] getData(int index)
    {
        Profesor pr = profesori.get(index);
        return pr.toStringArray();
    }

    public ArrayList<Profesor> getAll() {
        return profesori;
    }

    public void setAll(ArrayList<Profesor> arr) {
        profesori = arr;
    }

    public boolean exists(Integer key)
    {
        return exists(key, -1);
    }

    public boolean exists(Integer key, int index)
    {
        for(int i = 0; i < profesori.size(); ++i)
        {
            if(index == i) continue;
            if(profesori.get(i).getLicnaKarta() == key) return true;
        }
        return false;
    }
    
    public ArrayList<String[]> getPredmeti(int index)
    {
        return profesori.get(index).predmetiToArrayList();
    }
}
















