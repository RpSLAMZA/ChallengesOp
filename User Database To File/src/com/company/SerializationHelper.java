package com.company;

import java.io.*;
import java.util.ArrayList;

public class SerializationHelper{
    public static void serialiseToFile(Object object,String filePath)throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static Object deserializeFromFile(String filePath)
            throws IOException, ClassCastException, ClassNotFoundException{
        ArrayList<ArrayList<String>> userDatabase;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        userDatabase = (ArrayList<ArrayList<String>>)objectInputStream.readObject();
        objectInputStream.close();
        return userDatabase;
    }
}
