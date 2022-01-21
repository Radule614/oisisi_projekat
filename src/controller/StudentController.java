package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import app.Settings;
import app.Utility;
import gui.manager.TableManager;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.data.Data;

public class StudentController implements ControllerInterface {
    private static StudentController instance = null;

    private StudentController(){}

    public static StudentController getInstance()
    {
        if(instance == null)
            instance = new StudentController();
        return instance;
    }

    public boolean create(String[] arr, ArrayList<String> messages)
    {
        Student st = Data.student.create(arr, messages);
        if(st == null) return false;
        TableManager.addRow(0, st.getTableData());
        return true;
    }

    public String[] getData(int index)
    {
        return Data.student.getData(index);
    }

    public boolean edit(String[] arr, int index, ArrayList<String> messages)
    {
        Student oldStudent = Data.student.getAll().get(index);
        Student st = Data.student.create(arr, messages, index);
        if(st == null) return false;

        st.setPolozeniIspiti(oldStudent.getPolozeniIspiti());
        st.setNepolozeniIspiti(oldStudent.getNepolozeniIspiti());
        st.setProsek(oldStudent.getProsek());

        TableManager.remove(0, index);
        TableManager.insertRow(0, st.getTableData(), index);
        Data.student.delete(index+1);
        return true;
    }
    public void delete(int index)
    {
        TableManager.remove(0, index);
        Data.student.delete(index);
    }

    public ArrayList<String[]> getPolozeniIspiti(int index)
    {
        return Data.student.getPolozeniIspiti(index);
    }

    public ArrayList<String[]> getNepolozeniIspiti(int index)
    {
        return Data.student.getNepolozeniIspiti(index);
    }

    public double getProsek(int index)
    {
        return Data.student.getAll().get(index).getProsek();
    }

    public int getTotalESPB(int index)
    {
        ArrayList<Ocena> ispiti = Data.student.getAll().get(index).getPolozeniIspiti();
        int ESPB = 0;
        for(Ocena o: ispiti)
        {
            ESPB += o.getPredmet().getESPB();
        }
        return ESPB;
    }

    public void removeGrade(int studentIndex, int gradeIndex)
    {
        Student st = Data.student.getAll().get(studentIndex);
        ArrayList<Ocena> polozeniIspiti = st.getPolozeniIspiti();
        ArrayList<Ocena> nepolozeniIspiti = st.getNepolozeniIspiti();
        Ocena o = polozeniIspiti.get(gradeIndex);
        nepolozeniIspiti.add(o);
        polozeniIspiti.remove(gradeIndex);
        st.calculateProsek();
        TableManager.remove(0, studentIndex);
        TableManager.insertRow(0, st.getTableData(), studentIndex);
    }

    public void addToNepolozeni(int studentIndex, int predmetIndex)
    {
        Student st = Data.student.getAll().get(studentIndex);
        Predmet pr = Data.predmet.getAll().get(predmetIndex);
        Ocena o = new Ocena(st, pr);
        st.getNepolozeniIspiti().add(o);
    }

    public void removeFromPredmet(int studentIndex, int predmetIndex)
    {
        Student st = Data.student.getAll().get(studentIndex);
        st.getNepolozeniIspiti().remove(predmetIndex);
    }

    public boolean addToPolozeni(int studentIndex, int nepolozeniIndex, String[] data, ArrayList<String> messages)
    {
        Student st = Data.student.getAll().get(studentIndex);
        if(!Utility.isInInterval(Utility.parseInt(data[3].substring(6)), st.getGodinaUpisa(), Settings.trenutnaGodina))
        {
            if(messages != null) messages.add("Godina polaganja: mora biti u intervalu [" + st.getGodinaUpisa() + ", " + Settings.trenutnaGodina + "]");
            return false;
        }
        LocalDate datum = LocalDate.parse(data[3], Settings.formatter);

        Ocena ocena = st.getNepolozeniIspiti().get(nepolozeniIndex);
        ocena.setDatumPolaganja(datum);
        ocena.setVrednost(Utility.parseInt(data[2]) + 6);
        st.getNepolozeniIspiti().remove(nepolozeniIndex);
        st.getPolozeniIspiti().add(ocena);
        st.calculateProsek();
        TableManager.remove(0, studentIndex);
        TableManager.insertRow(0, st.getTableData(), studentIndex);
        return true;
    }
    
    public void updateStudentInTable(int studentIndex) {
    	Student st = Data.student.getAll().get(studentIndex);
    	TableManager.remove(0, studentIndex);
        TableManager.insertRow(0, st.getTableData(), studentIndex);
    }
}











