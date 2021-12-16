package app;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	public static int parseInt(String s)
	{
		int n = 0;
		try 
		{
			n = Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			System.out.println(e.toString());
		}
		return n;
	}
	
	public static double parseDouble(String s)
	{
		double n = 0.0;
		try 
		{
			n = Double.parseDouble(s);
		}
		catch(NumberFormatException e)
		{
			System.out.println(e.toString());
		}
		return n;
	}
	
	public static String[] trimEach(String[] arr)
	{
		String[] temp = new String[arr.length];
		for(int i = 0; i < arr.length; ++i)
		{
			temp[i] = arr[i].trim();
		}
		return temp;
	}
	
	public static ArrayList<String> trimEach(ArrayList<String> arr)
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < arr.size(); ++i)
		{
			temp.add(arr.get(0).trim());
		}
		return temp;
	}
	
	public static boolean doesMatch(String patternInput, String input)
	{
		Pattern pattern = Pattern.compile(patternInput);
		Matcher matcher = pattern.matcher(input);
		
		return matcher.find();
	}
	
	public static void printArray(ArrayList<String> arr)
	{
		System.out.println();
		for(String s: arr)
		{
			System.out.println(s);
		}
	}
	
	public static boolean isInInterval(double d, double d1, double d2)
	{
		if(d < d1 || d > d2) return false;
		return true;
	}
	
	public static boolean isInInterval(int i, int i1, int i2)
	{
		if(i < i1 || i > i2) return false;
		return true;
	}
}













