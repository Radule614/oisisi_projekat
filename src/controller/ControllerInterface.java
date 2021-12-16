package controller;
import java.util.ArrayList;

public interface ControllerInterface {
    boolean create(String[] arr, ArrayList<String> messages);
    String[] getData(int index);
    boolean edit(String[] arr, int index, ArrayList<String> messages);
    void delete(int index);
}
