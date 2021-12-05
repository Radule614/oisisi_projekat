package model.data;

import java.util.ArrayList;

import app.Utility;
import model.Student;

class StudentData {
	static ArrayList<Student> studenti = new ArrayList<Student>();
	
	static ArrayList<String[]> toTableDataArray()
	{
		ArrayList<String[]> dataArray = new ArrayList<String[]>();
		for(Student temp: studenti) dataArray.add(temp.getTableData());
		return dataArray;
	}
	
	static Student create(String[] arr, ArrayList<String> messages, int index)
	{
		arr = Utility.trimEach(arr);
		if(!Student.isValidData(arr, messages)) return null;
		if(messages != null && exists(arr[6], index))
		{
			messages.add("Student sa indeksom " + arr[6] + " već postoji.");
			return null;
		}
		Student st = new Student(arr);
		
		studenti.add(index, st);
		return st;
	}
	
	static Student create(String[] arr, ArrayList<String> messages)
	{
		return create(arr, messages, studenti.size());
	}
	
	static void delete(int index)
	{
		studenti.remove(index);
	}
	
	static String[] getData(int index)
	{
		Student st = studenti.get(index);
		String[] data = st.toStringArray();
		
		return data;
	}
	
	static ArrayList<Student> getStudenti() {
		return studenti;
	}
	
	static ArrayList<String[]> getPolozeniIspiti(int index)
	{
		return studenti.get(index).polozeniToArrayList();
	}
	
	static ArrayList<String[]> getNepolozeniIspiti(int index)
	{
		return studenti.get(index).nepolozeniToArrayList();
	}
	
	static boolean exists(String key)
	{
		return exists(key, -1);
	}
	
	static boolean exists(String key, int index)
	{
		for(int i = 0; i < studenti.size(); ++i)
		{
			if(index == i) continue;
			if(studenti.get(i).getBrojIndeksa().equals(key)) return true;
		}
		return false;
	}
}















