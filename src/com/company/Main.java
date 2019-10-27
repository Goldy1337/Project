package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static Scanner inputScanner = new Scanner(System.in);
    private static String menuChoice = "";
    static HashMap<String, Animal> animals = new HashMap<>();
    static HashMap<String, Person> employees = new HashMap<>();
    static ArrayList<Visitor> visitors = new ArrayList<>();
    static float profit = 0;
    static float expenses = 0;

    public static void main(String[] args) {
        readFromSavedFiles();
        MainMenu();
    }

    private static void MainMenu(){
        while (!menuChoice.equals("9")){
            System.out.println("Welcome to Lush Acres Petting Zoo, please choose your option below\n" +
                    "1. Animal administration\n" +
                    "2. Employee Administration\n" +
                    "3. Visitor Admission\n" +
                    "4. Profit calculations\n" +
                    "5. Help\n" +
                    "9. Exit");
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
                                System.out.println("Enter animal ID to retire it from the petting zoo");
                                menuChoice = inputScanner.nextLine();
                                if (animals.containsKey(menuChoice)) {
                                    animals.remove(menuChoice);
                                    System.out.println("Removing animal from database");
                                    FileUtils.writeToAnimalList(animals);
                                    break;
                                }
                                else if (!animals.containsKey(menuChoice)){
                                    System.out.println("Animal ID not found");
                                    break;
                                }
                            case "3":
                                System.out.println("Showing all current animals");
                                for (String i : animals.keySet()){
                                    System.out.println("ID: " + i + ", " + animals.get(i).toString());
                                }
                                break;
                            case "4":
                                System.out.println("Enter ID for the animal");
                                menuChoice = inputScanner.nextLine();
                                if (animals.containsKey(menuChoice)) {
                                    System.out.println("Showing specified animal");
                                    System.out.println(animals.get(menuChoice));
                                    break;
                                }
                                else if (!animals.containsKey(menuChoice)){
                                    System.out.println("Animal ID not found");
                                    break;
                                }
                            case "5":
                                System.out.println("In the Animal Administration menu you can:\n" +
                                        "Add or retire animals to/from the petting zoo,\n" +
                                        "show all the current animals\n" +
                                        "or a specific animal currently in the petting zoo.");
                                break;
                            case "6":
                                System.out.println("Returning to main menu");
                                break;
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
                                System.out.println("Enter employee ID to retire them from the petting zoo staff");
                                menuChoice = inputScanner.nextLine();
                                if (employees.containsKey(menuChoice)) {
                                    employees.remove(menuChoice);
                                    System.out.println("Removing employee from database");
                                    break;
                                }
                                else if (!employees.containsKey(menuChoice)){
                                    System.out.println("Employee ID not found");
                                    break;
                                }
                            case "3":
                                System.out.println("Showing all current employees");
                                for (String i : employees.keySet()){
                                    System.out.println("ID: " + i + ", " + employees.get(i).toString());
                                }
                                break;
                            case "4":
                                System.out.println("Enter ID for the employee");
                                menuChoice = inputScanner.nextLine();
                                if (employees.containsKey(menuChoice)){
                                    System.out.println("Showing specified employee");
                                    System.out.println(employees.get(menuChoice));
                                    break;
                                }
                                else if (!employees.containsKey(menuChoice)){
                                    System.out.println("Employee ID not found");
                                    break;
                                }
                            case "5":
                                System.out.println("In the Employee Administration menu you can:\n" +
                                        "Add hired or retire employees to/from the petting zoo staff,\n" +
                                        "show all the current employees\n" +
                                        "or a specific employee currently working in the petting zoo.");
                                break;
                            case "6":
                                System.out.println("Returning to main menu");
                                break;
                            default:
                                System.out.println("Choose your option by entering the corresponding number and pressing enter");
                        }
                    }
                    break;
                case "3":
                    while (!menuChoice.equals("4")){
                        System.out.println("Lush Acres Visitor Admission\n" +
                                "1. Register visitor\n" +
                                "2. Show visitors\n" +
                                "3. Help\n" +
                                "4. Return to main menu");
                        menuChoice = inputScanner.nextLine();
                        switch (menuChoice){
                            case "1":
                                System.out.println("Add new petting zoo visitor");
                                addVisitor();
                                break;
                            case "2":
                                System.out.println("Showing visitors");
                                for (Person visitor : visitors){
                                    System.out.println(visitor.getName() + ", age: " + visitor.getAge() + ".");
                                }
                                break;
                            case "3":
                                System.out.println("In Visitor Admission you can register visitors.\n" +
                                        "Current admission prices:\n" +
                                        "Age 8 and under, free admission\n" +
                                        "Ages 9-18, 3,6$\n" +
                                        "Ages 19 and above, 8,9$.");
                                break;
                            case "4":
                                System.out.println("Returning to main menu");
                                break;
                            default:
                                System.out.println("Choose your option by entering the corresponding number and pressing enter");
                        }
                    }
                    break;
                case "4":
                    System.out.println("Calculating todays profit");
                    float salary = 0;
                    float income = 0;
                    for (String i : employees.keySet()){
                        salary = salary - 10.2f;
                        expenses = salary;
                    }
                    for (Person visitor : visitors){
                       income = income + visitor.profitCalculation();
                       profit = income + expenses; //TODO Finslipa lite
                    }
                    System.out.println("Todays estimated profits are " + (profit) + "$");
                    break;
                case "5":
                    System.out.println("Help");
                    break;
                case "9":
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.out.println("Choose your option by entering the corresponding number and pressing enter");
            }
        }
    }

    private static void addAnimal (String animalType){
        int age = 0;
        String userInput;
        if (animalType.equals("1")){
            System.out.println("Enter the goats age");
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter the goats name");
            userInput = inputScanner.nextLine();
            Goat newGoat = new Goat(age, userInput, "goat");
            System.out.println("Enter an ID for the goat");
            userInput = inputScanner.nextLine();
            animals.put(userInput, newGoat);
            FileUtils.writeToAnimalList(animals);
        }
        else if (animalType.equals("2")){
            System.out.println("Enter the sheep's age");
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter the sheep's name");
            userInput = inputScanner.nextLine();
            Sheep newSheep = new Sheep(age, userInput, "sheep");
            System.out.println("Enter an ID for the sheep");
            userInput = inputScanner.nextLine();
            animals.put(userInput, newSheep);
            FileUtils.writeToAnimalList(animals);
        }
        else if (animalType.equals("3")){
            System.out.println("Enter the ducks age");
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter the ducks name");
            userInput = inputScanner.nextLine();
            Duck newDuck = new Duck(age, userInput, "duck");
            System.out.println("Enter an ID for the duck");
            userInput = inputScanner.nextLine();
            animals.put(userInput, newDuck);
            FileUtils.writeToAnimalList(animals);
        }
    }
    private static void addEmployee(){
        int age = 0;
        String userInput;
        System.out.println("Enter the employee's age");
        userInput = inputScanner.nextLine();
        age = Integer.parseInt(userInput);
        System.out.println("Enter the employee's name");
        userInput = inputScanner.nextLine();
        Employee newEmployee = new Employee(age, userInput);
        System.out.println("Enter an ID for the employee");
        userInput = inputScanner.nextLine();
        employees.put(userInput, newEmployee);
        FileUtils.writeToEmployeeList(employees);
    }

    private static void addVisitor(){
        int age = 0;
        String userInput;
        System.out.println("Enter visitor age");
        userInput = inputScanner.nextLine();
        age = Integer.parseInt(userInput);
        System.out.println("Enter visitor name");
        userInput = inputScanner.nextLine();
        Visitor newVisitor = new Visitor(age, userInput);
        visitors.add(newVisitor);
    }

    private static void readFromSavedFiles(){
        animals = FileUtils.readFromAnimalList("animalList.dat");
        employees = FileUtils.readFromEmployeeList("employeeList.dat");
    }
}
