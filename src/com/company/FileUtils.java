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
        HashMap<String, Animal> animals = new HashMap<>();
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            animals = (HashMap<String, Animal>) objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
        }
        return animals;
    }

    public static void writeToEmployeeList(HashMap<String, Person> employees){
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream("employeeList.dat", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employees);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static HashMap<String, Person> readFromEmployeeList(String fileName){
        ObjectInputStream objectinputstream = null;
        HashMap<String, Person> employees = new HashMap<>();
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            employees = (HashMap<String, Person>) objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
        }
        return employees;
    }

}
