package model.data;

import java.util.ArrayList;
import model.*;

public class Data {
	public static ArrayList<String[]> 	studentiToTableDataArray	() {return StudentData.toTableDataArray();}
	public static ArrayList<String[]> 	profesoriToTableDataArray	() {return ProfesorData.toTableDataArray();}
	public static ArrayList<String[]> 	predmetiToTableDataArray	() {return PredmetData.toTableDataArray();}
	
	public static Student 				createStudent				(String[] arr, ArrayList<String> messages, int index) {return StudentData.create(arr, messages, index);}
	public static Student 				createStudent				(String[] arr, ArrayList<String> messages) {return StudentData.create(arr, messages);}
	public static Profesor 				createProfesor				(String[] arr, ArrayList<String> messages, int index) {return ProfesorData.create(arr, messages, index);}
	public static Profesor 				createProfesor				(String[] arr, ArrayList<String> messages) {return ProfesorData.create(arr, messages);}
	public static Predmet 				createPredmet				(String[] arr, ArrayList<String> messages, int index) {return PredmetData.create(arr, messages, index);}
	public static Predmet 				createPredmet				(String[] arr, ArrayList<String> messages) {return PredmetData.create(arr, messages);}
	
	public static void 					deleteStudent				(int index) {StudentData.delete(index);}
	public static void 					deleteProfesor				(int index) {ProfesorData.delete(index);}
	public static void 					deletePredmet				(int index) {PredmetData.delete(index);}
	
	public static String[] 				getStudentData				(int index) {return StudentData.getData(index);}
	public static String[] 				getProfesorData				(int index) {return ProfesorData.getData(index);}
	public static String[] 				getPredmetData				(int index) {return PredmetData.getData(index);}
	
	public static ArrayList<Student> 	getStudenti					() {return StudentData.getStudenti();}
	public static ArrayList<Profesor> 	getProfesori				() {return ProfesorData.getProfesori();}
	public static ArrayList<Predmet> 	getPredmeti					() {return PredmetData.getPredmeti();}
	
	public static ArrayList<String[]> 	getPolozeniIspiti			(int index) {return StudentData.getPolozeniIspiti(index);}
	public static ArrayList<String[]> 	getNepolozeniIspiti			(int index) {return StudentData.getNepolozeniIspiti(index);}
	
	public static boolean 				studentExists				(String key) {return StudentData.exists(key);}
	public static boolean 				studentExists				(String key, int index) {return StudentData.exists(key, index);}
	public static boolean 				profesorExists				(int key) {return ProfesorData.exists(key);}
	public static boolean 				profesorExists				(int key, int index) {return ProfesorData.exists(key, index);}
	public static boolean 				predmetExists				(int key) {return PredmetData.exists(key);}
	public static boolean 				predmetExists				(int key, int index) {return PredmetData.exists(key, index);}
	
}















