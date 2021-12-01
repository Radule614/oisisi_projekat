package controller;

import java.util.ArrayList;

import model.structure.*;

public class Controller {
	public static boolean createStudent	(String[] arr, ArrayList<String> messages) {return StudentController.create(arr, messages);}
	public static boolean createProfesor(String[] arr, ArrayList<String> messages) {return ProfesorController.create(arr, messages);}
	public static boolean createPredmet	(String[] arr, ArrayList<String> messages) {return PredmetController.create(arr, messages);}
	
	public static String[] getStudentData	(int index) {return StudentController.getData(index);}
	public static String[] getProfesorData	(int index) {return ProfesorController.getData(index);}
	public static String[] getPredmetData	(int index) {return PredmetController.getData(index);}
	
	public static Student 	getStudent	(int index) {return StudentController.get(index);}
	public static Profesor	getProfesor	(int index) {return ProfesorController.get(index);}
	public static Predmet 	getPredmet	(int index) {return PredmetController.get(index);}
	
	public static boolean editStudent	(String[] arr, int index, ArrayList<String> messages) {return StudentController.edit(arr, index, messages);}
	public static boolean editProfesor	(String[] arr, int index, ArrayList<String> messages) {return ProfesorController.edit(arr, index, messages);}
	public static boolean editPredmet	(String[] arr, int index, ArrayList<String> messages) {return PredmetController.edit(arr, index, messages);}

	public static void deleteStudent	(int index) {StudentController.delete(index);}
	public static void deleteProfesor	(int index) {ProfesorController.delete(index);}
	public static void deletePredmet	(int index) {PredmetController.delete(index);}
	
	public static ArrayList<String[]> getPolozeniIspiti(int index) {return StudentController.getPolozeniIspiti(index);}
	public static double getProsek(int index) {return StudentController.getProsek(index);}
	public static int getTotalESPB(int index) {return StudentController.getTotalESPB(index);}
	public static void removeStudentGrade(int studentIndex, int gradeIndex) { StudentController.removeGrade(studentIndex, gradeIndex);}
	
}
	
	














