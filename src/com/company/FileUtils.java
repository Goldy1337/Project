package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

abstract public class FileUtils {

    public static void writeToAnimalList(HashMap<String, Animal> animals){
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream("animalList.dat", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(animals);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static HashMap<String, Animal> readFromAnimalList(String fileName){
        ObjectInputStream objectinputstream = null;
        HashMap<String, Animal> animals = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            animals = (HashMap<String, Animal>) objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }


}
