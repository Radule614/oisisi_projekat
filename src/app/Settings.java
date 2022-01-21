package app;

import java.time.format.DateTimeFormatter;

public class Settings {
	//regex patterns
	public static final String multipleWordPattern 	= 	"^\\s*(\\s?((?!\\d)[\\wćĆčČžŽđĐšŠ])+)+\\s*$";
	public static final String singleWordPatter 	= 	"^\\s*(\\s?((?!\\d)[\\wćĆčČžŽđĐšŠ])+){1}\\s*$";
	public static final String namePattern 			= 	"^\\s*((?!\\d)[\\wćĆčČžŽđĐšŠ]){3,}\\s*$";
	public static final String phonePattern			=	"^\\s*(\\d{3}\\/\\d{3,4}-\\d{3,4})\\s*$";
	public static final String emailPattern 		= 	"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static final String datePattern 			= 	"^\\d{2}-\\d{2}-\\d{4}$";
	public static final String addressPattern 		= 	"^(\\s*((?!\\d)[\\wćĆčČžŽđĐšŠ]))+\\s*(\\,\\s*)([\\wćĆčČžŽđĐšŠ\\d]+)\\s*(\\,\\s*)(\\s*((?!\\d)[\\wćĆčČžŽđĐšŠ]))+\\s*(\\,\\s*)(\\s*((?!\\d)[\\wćĆčČžŽđĐšŠ]))+\\s*$";
	public static final String indexPattern 		= 	"^\\s*[A-Z]{2}[0-9]{1,3}\\/[0-9]{4}\\s*$";
	public static final String idCardPattern 		=	"^\\s*\\d{9}\\s*$";
	
	public static final String dateFormat = "dd-MM-yyyy";
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
	
	public static final int trenutnaGodina = 2022;
}
