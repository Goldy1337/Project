package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner inputScanner = new Scanner(System.in);
    private static String menuChoice = "";
    static ArrayList<Animal> animals = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Visitor> visitors = new ArrayList<>();

    public static void main(String[] args) {
        MainMenu();
    }

    private static void MainMenu(){
        while (!menuChoice.equals("5")){
            System.out.println("Welcome to Lush Acres Petting Zoo, please choose your option below\n" +
                    "1. Animal administration\n" +
                    "2. Employee Administration\n" +
                    "3. Profit calculations\n" +
                    "4. Help\n" +
                    "5. Exit");
            menuChoice = inputScanner.nextLine();
            switch (menuChoice){
                case "1":
                    while (!menuChoice.equals("6")){
                        System.out.println("Lush Acres Animal Administration\n" +
                                "1. Add new animal to the petting zoo\n" +
                                "2. Retire animal from the petting zoo\n" +
                                "3. Show all current animals\n" +
                                "4. Show specific animal\n" +
                                "5. Help\n" +
                                "6. Return to main menu");
                        menuChoice = inputScanner.nextLine();
                        switch (menuChoice){
                            case "1":
                                System.out.println("Which kind of animal will you add?\n" +
                                        "1. Goat\n" +
                                        "2. Sheep\n" +
                                        "3. Duck");
                                menuChoice = inputScanner.nextLine();
                                if (menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3")){
                                    addAnimal(menuChoice);
                                }
                                else
                                    System.out.println("Invalid input.");
                                break;
                            case "2":
                                System.out.println("Retire animal from the petting zoo");
                                break;
                            case "3":
                                System.out.println("Showing all current animals");
                                for (Animal animal : animals){
                                    System.out.println(animal.toString());
                                }
                                break;
                            case "4":
                                System.out.println("Show specific animal");
                                break;
                            case "5":
                                System.out.println("In the Animal Adiministration menu you can:\n" +
                                        "Add or retire animals to/from the petting zoo,\n" +
                                        "show all the current animals\n" +
                                        "or a specific animal currently in the petting zoo.");
                                break;
                            case "6":
                                System.out.println("Returning to main menu");
                            default:
                                System.out.println("Choose your option by entering the corresponding number and pressing enter");
                        }
                    }
                    break;
                case "2":
                    while (!menuChoice.equals("6")){
                        System.out.println("Lush Acres Employee Administration\n" +
                                "1. Add new employee to the petting zoo staff\n" +
                                "2. Retire employee from the petting zoo staff\n" +
                                "3. Show all current employees\n" +
                                "4. Show specific employee\n" +
                                "5. Help\n" +
                                "6. Return to main menu");
                        menuChoice = inputScanner.nextLine();
                        switch (menuChoice){
                            case "1":
                                System.out.println("Add new employee to the petting zoo staff");
                                addEmployee();
                                break;
                            case "2":
                                System.out.println("Retire employee from the petting zoo staff");
                                break;
                            case "3":
                                System.out.println("Showing all current employees");
                                for (Employee employee : employees){
                                    System.out.println(employee.toString());
                                }
                            case "4":
                                System.out.println("Show specific employee");
                                break;
                            case "5":
                                System.out.println("In the Employee Adiministration menu you can:\n" +
                                        "Add hired or retire employees to/from the petting zoo staff,\n" +
                                        "show all the current employees\n" +
                                        "or a specific employee currently working in the petting zoo.");
                                break;
                            case "6":
                                System.out.println("Returning to main menu");
                            default:
                                System.out.println("Choose your option by entering the corresponding number and pressing enter");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Profit Calculations");
                    break;
                case "4":
                    System.out.println("Help");
                    break;
                case "5":
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.out.println("Choose your option by entering the corresponding number and pressing enter");
            }
        }
    }

    static void addAnimal (String animalType){
        int age = 0;
        String userInput;
        if (animalType.equals("1")){
            System.out.println("Enter the goats age");
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter the goats name");
            userInput = inputScanner.nextLine();
            Goat newGoat = new Goat(age, userInput);
            animals.add(newGoat);
        }
        else if (animalType.equals("2")){
            System.out.println("Enter the sheep's age");
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter the sheep's name");
            userInput = inputScanner.nextLine();
            Sheep newSheep = new Sheep(age, userInput);
            animals.add(newSheep);
        }
        else if (animalType.equals("3")){
            System.out.println("Enter the ducks age");
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter the ducks name");
            userInput = inputScanner.nextLine();
            Duck newDuck = new Duck(age, userInput);
            animals.add(newDuck);
        }
    }
    static void addEmployee(){
        int age = 0;
        String userInput;
        System.out.println("Enter the employee's age");
        userInput = inputScanner.nextLine();
        age = Integer.parseInt(userInput);
        System.out.println("Enter the employee's name");
        userInput = inputScanner.nextLine();
        Employee newEmployee = new Employee(age, userInput);
        employees.add(newEmployee);
    }
}
