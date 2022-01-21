package model.data;

import java.util.ArrayList;

import app.Utility;
import gui.MainWindow;
import model.Student;

public class StudentData implements DataInterface<Student, String> {
    private static StudentData instance = null;

    private ArrayList<Student> studenti = new ArrayList<Student>();

    private StudentData() {}

    public static StudentData getInstance()
    {
        if(instance == null)
            instance = new StudentData();
        return instance;
    }

    public ArrayList<String[]> toTableDataArray()
    {
        ArrayList<String[]> dataArray = new ArrayList<String[]>();
        for(Student temp: studenti) dataArray.add(temp.getTableData());
        return dataArray;
    }

    public Student create(String[] arr, ArrayList<String> messages, int index)
    {
        arr = Utility.trimEach(arr);
        if(!Student.isValidData(arr, messages)) return null;
        if(messages != null && exists(arr[6], index))
        {
            messages.add(MainWindow.getInstance().GetLocalization("warnStudentExists") + " " + arr[6] + " " + MainWindow.getInstance().GetLocalization("warnExists"));
            return null;
        }
        Student st = new Student(arr);

        studenti.add(index, st);
        return st;
    }

    public Student create(String[] arr, ArrayList<String> messages)
    {
        return create(arr, messages, studenti.size());
    }

    public void delete(int index)
    {
        studenti.remove(index);
    }

    public String[] getData(int index)
    {
        Student st = studenti.get(index);
        return st.toStringArray();
    }

    public ArrayList<Student> getAll() {
        return studenti;
    }

    public void setAll(ArrayList<Student> arr) {
        studenti = arr;
    }

    public boolean exists(String key)
    {
        return exists(key, -1);
    }

    public boolean exists(String key, int index)
    {
        for(int i = 0; i < studenti.size(); ++i)
        {
            if(index == i) continue;
            if(studenti.get(i).getBrojIndeksa().equals(key)) return true;
        }
        return false;
    }

    public ArrayList<String[]> getPolozeniIspiti(int index)
    {
        return studenti.get(index).polozeniToArrayList();
    }

    public ArrayList<String[]> getNepolozeniIspiti(int index)
    {
        return studenti.get(index).nepolozeniToArrayList();
    }
}















