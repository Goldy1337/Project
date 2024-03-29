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

    public static void writeToEmployeeList(HashMap<String, Employee> employees){
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

    public static HashMap<String, Employee> readFromEmployeeList(String fileName){
        ObjectInputStream objectinputstream = null;
        HashMap<String, Employee> employees = new HashMap<>();
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            employees = (HashMap<String, Employee>) objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
        }
        return employees;
    }

    public static float profitCalculation(){
        float salary = 0;
        float income = 0;
        float expenses = 0;
        float profit = 0;
        for (String i : PettingZoo.employees.keySet()){
            salary = salary - 10.2f;
            expenses = salary;
        }
        for(Person visitor : PettingZoo.visitors){
            income = income + visitor.profitCalculation();
        }
        profit = expenses + income;
        return profit;
    }
}
