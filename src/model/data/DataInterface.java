package model.data;

import java.util.ArrayList;

public interface DataInterface<Type, KeyType>{
    ArrayList<String[]> toTableDataArray();
    Type create(String[] arr, ArrayList<String> messages, int index);
    Type create(String[] arr, ArrayList<String> messages);
    void delete(int index);
    String[] getData(int index);
    ArrayList<Type> getAll();
    void setAll(ArrayList<Type> arr);
    boolean exists(KeyType key);
    boolean exists(KeyType key, int index);
}
