package controller;

import java.util.ArrayList;

import gui.manager.TableManager;
import model.Profesor;
import model.data.Data;

public class ProfesorController implements ControllerInterface{
    private static ProfesorController instance = null;

    private ProfesorController(){}

    public static ProfesorController getInstance()
    {
        if(instance == null)
            instance = new ProfesorController();
        return instance;
    }

    public boolean create(String[] arr, ArrayList<String> messages)
    {
        Profesor pr = Data.profesor.create(arr, messages);
        if(pr == null) return false;
        TableManager.addRow(1, pr.getTableData());
        return true;
    }

    public String[] getData(int index)
    {
        return Data.profesor.getData(index);
    }

    public boolean edit(String[] arr, int index, ArrayList<String> messages)
    {
        Profesor oldProfesor = Data.profesor.getAll().get(index);
        Profesor pr = Data.profesor.create(arr, messages, index);
        if(pr == null) return false;

        pr.setPredmeti(oldProfesor.getPredmeti());

        TableManager.remove(1, index);
        TableManager.insertRow(1, pr.getTableData(), index);
        Data.profesor.delete(index+1);
        return true;
    }

    public void delete(int index)
    {
        TableManager.remove(1, index);
        Data.profesor.delete(index);
    }
    
}
