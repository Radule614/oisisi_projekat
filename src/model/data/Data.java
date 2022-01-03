package model.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import model.*;

public class Data {
	public static final StudentData student = StudentData.getInstance();
    public static final ProfesorData profesor = ProfesorData.getInstance();
    public static final PredmetData predmet = PredmetData.getInstance();
	
	
	public static HashMap<Integer, String> getEligiblePredmeti(int studentIndex)
	{
		HashMap<Integer, String> data = new HashMap<Integer, String>();
		
		Student s = student.getAll().get(studentIndex);
		ArrayList<Predmet> predmeti = predmet.getAll();		
		
		ArrayList<Predmet> polozeni = new ArrayList<Predmet>();
		for(Ocena o: s.getPolozeniIspiti())
		{
			polozeni.add(o.getPredmet());
		}
		ArrayList<Predmet> nepolozeni = new ArrayList<Predmet>();
		for(Ocena o: s.getNepolozeniIspiti())
		{
			nepolozeni.add(o.getPredmet());
		}
		
		for(int i = 0; i < predmeti.size(); ++i)
		{
			Predmet pr = predmeti.get(i);
			if(s.getTrenutnaGodina() < pr.getGodinaStudija())
				continue;
			if(polozeni.contains(pr) || nepolozeni.contains(pr))
				continue;
			String predmetString = new String(pr.getSifra() + " - " + pr.getNaziv());
			data.put(i, predmetString);
		}
		
		return data;
	}
	
	public static boolean saveData()
    {
        try(FileOutputStream fs = new FileOutputStream("data/data.ser", false);
            ObjectOutputStream os = new ObjectOutputStream(fs))
        {
            os.writeObject(student.getAll());
            os.writeObject(profesor.getAll());
            os.writeObject(predmet.getAll());
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean getSavedData()
    {
        try(FileInputStream fs = new FileInputStream(("data/data.ser"));
            ObjectInputStream os = new ObjectInputStream(fs))
        {
            student.setAll((ArrayList<Student>) os.readObject());
            profesor.setAll((ArrayList<Profesor>) os.readObject());
            predmet.setAll((ArrayList<Predmet>) os.readObject());
            return true;
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("no file found");
            return false;
        }
    }
    
    
    
    
}















