package utility;

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
	
	public static void trimEach(String[] arr)
	{
		for(String s: arr)
		{
			s = s.trim();
		}
	}
	
	public static void trimEach(ArrayList<String> arr)
	{
		for(String s: arr)
		{
			s = s.trim();
		}
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













