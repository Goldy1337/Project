package com.company;

import java.util.Scanner;

public class Main {
    //TODO, dokumentation, UML, JAR-fil, finslipa JavaDoc i Employee
    private static Scanner inputScanner = new Scanner(System.in);
    private static String menuChoice = "";

    public static void main(String[] args) {
        readFromSavedRegistries();
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
                                    System.out.println("Invalid input.\n");
                                break;
                            case "2":
                                System.out.println("Enter animal ID to retire it from the petting zoo");
                                menuChoice = inputScanner.nextLine();
                                if (PettingZoo.animals.containsKey(menuChoice)) {
                                    PettingZoo.animals.remove(menuChoice);
                                    System.out.println("Removing animal from database\n");
                                    FileUtils.writeToAnimalList(PettingZoo.animals);
                                    break;
                                }
                                else if (!PettingZoo.animals.containsKey(menuChoice)){
                                    System.out.println("Animal ID not found\n");
                                    break;
                                }
                            case "3":
                                System.out.println("Showing all current animals\n");
                                for (String i : PettingZoo.animals.keySet()){
                                    System.out.println("ID: " + i + ", " + PettingZoo.animals.get(i).toString() + "\n");
                                }
                                break;
                            case "4":
                                System.out.println("Enter ID for the animal");
                                menuChoice = inputScanner.nextLine();
                                if (PettingZoo.animals.containsKey(menuChoice)) {
                                    System.out.println(PettingZoo.animals.get(menuChoice) + "\n");
                                    break;
                                }
                                else if (!PettingZoo.animals.containsKey(menuChoice)){
                                    System.out.println("Animal ID not found\n");
                                    break;
                                }
                            case "5":
                                System.out.println("In the Animal Administration menu you can:\n" +
                                        "Add or retire animals to/from the petting zoo,\n" +
                                        "show all the current animals or\n" +
                                        "show a specific animal currently in the petting zoo.\n");
                                break;
                            case "6":
                                System.out.println("Returning to main menu\n");
                                break;
                            default:
                                System.out.println("Choose your option by entering the corresponding number and pressing enter\n");
                        }
                    }
                    break;
                case "2":
                    while (!menuChoice.equals("7")){
                        System.out.println("Lush Acres Employee Administration\n" +
                                "1. Add new employee to the petting zoo staff\n" +
                                "2. Retire employee from the petting zoo staff\n" +
                                "3. Show all current employees\n" +
                                "4. Show specific employee\n" +
                                "5. Manage employee notes\n" +
                                "6. Help\n" +
                                "7. Return to main menu");
                        menuChoice = inputScanner.nextLine();
                        switch (menuChoice){
                            case "1":
                                addEmployee();
                                break;
                            case "2":
                                System.out.println("Enter employee ID to retire them from the petting zoo staff");
                                menuChoice = inputScanner.nextLine();
                                if (PettingZoo.employees.containsKey(menuChoice)) {
                                    PettingZoo.employees.remove(menuChoice);
                                    System.out.println("Removing employee from database\n");
                                    FileUtils.writeToEmployeeList(PettingZoo.employees);
                                    break;
                                }
                                else if (!PettingZoo.employees.containsKey(menuChoice)){
                                    System.out.println("Employee ID not found\n");
                                    break;
                                }
                            case "3":
                                System.out.println("Showing all current employees\n");
                                for (String i : PettingZoo.employees.keySet()){
                                    System.out.println("ID: " + i + ", " + PettingZoo.employees.get(i).toString() + "\n");
                                }
                                break;
                            case "4":
                                System.out.println("Enter ID for the employee");
                                menuChoice = inputScanner.nextLine();
                                if (PettingZoo.employees.containsKey(menuChoice)){
                                    System.out.println(PettingZoo.employees.get(menuChoice) + "\n");
                                    break;
                                }
                                else if (!PettingZoo.employees.containsKey(menuChoice)){
                                    System.out.println("Employee ID not found\n");
                                    break;
                                }
                            case "5":
                                while (!menuChoice.equals("3")) {
                                    System.out.println("Enter employee ID");
                                    menuChoice = inputScanner.nextLine();
                                    if (PettingZoo.employees.containsKey(menuChoice)) {
                                        PettingZoo.employees.get(menuChoice).getEmpoyeeNoteList();
                                        System.out.println("");
                                        System.out.println("1. Add note\n" +
                                                "2. Remove note\n" +
                                                "3. Return to Employee Administration");
                                        String employeeHolder = menuChoice;
                                        menuChoice = inputScanner.nextLine();
                                        switch (menuChoice){
                                            case "1":
                                                System.out.println("Add note");
                                                menuChoice = inputScanner.nextLine();
                                                EmployeeNotes employeeNote = new EmployeeNotes(menuChoice);
                                                PettingZoo.employees.get(employeeHolder).employeeNotesList.add(employeeNote);
                                                FileUtils.writeToEmployeeList(PettingZoo.employees);
                                                break;
                                            case "2":
                                                System.out.println("Enter number of note to remove");
                                                menuChoice = inputScanner.nextLine();
                                                try {
                                                    PettingZoo.employees.get(employeeHolder).removeEmployeeNote(Integer.parseInt(menuChoice));
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input, returning to menu\n");
                                                }
                                                break;
                                            case "3":
                                                System.out.println("Returning to Employee Administration\n");
                                        }
                                        break;
                                    }
                                    else if (!PettingZoo.employees.containsKey(menuChoice)) {
                                        System.out.println("Employee ID not found\n");
                                        break;
                                    }
                                }
                                break;
                            case "6":
                                System.out.println("In the Employee Administration menu you can:\n" +
                                        "Add hired or retire employees to/from the petting zoo staff,\n" +
                                        "show all the current employees or\n" +
                                        "show a specific employee working in the petting zoo" +
                                        "and add notes to employees.\n");
                                break;
                            case "7":
                                System.out.println("Returning to main menu\n");
                                break;
                            default:
                                System.out.println("Choose your option by entering the corresponding number and pressing enter\n");
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
                                System.out.println("Add new petting zoo visitor\n");
                                addVisitor();
                                break;
                            case "2":
                                System.out.println("Showing visitors\n");
                                for (Person visitor : PettingZoo.visitors){
                                    System.out.println(visitor.getName() + ", age: " + visitor.getAge() + ".\n");
                                }
                                break;
                            case "3":
                                System.out.println("In Visitor Admission you can register and show registered visitors\n" +
                                        "\n" +
                                        "Current admission prices:\n" +
                                        "Age 8 and under, free admission\n" +
                                        "Ages 9-18, 3,6$\n" +
                                        "Ages 19 and above, 8,9$.\n");
                                break;
                            case "4":
                                System.out.println("Returning to main menu\n");
                                break;
                            default:
                                System.out.println("Choose your option by entering the corresponding number and pressing enter\n");
                        }
                    }
                    break;
                case "4":
                    System.out.println("Today's estimated profits are " + FileUtils.profitCalculation() + "$\n");
                    break;
                case "5":
                    System.out.println("This program will help you manage animals, employees and register visitors.\n" +
                            "To navigate the menu enter the number of the option you wish to select and press enter.\n");
                    break;
                case "9":
                    System.out.println("Exiting Program\n");
                    break;
                default:
                    System.out.println("Choose your option by entering the corresponding number and pressing enter\n");
            }
        }
    }

    private static void addAnimal (String animalType){
        int age = 0;
        String userInput;
        if (animalType.equals("1")){
            System.out.println("Enter the new goats age");
            try {
                userInput = inputScanner.nextLine();
                age = Integer.parseInt(userInput);
                System.out.println("Enter the new goats name");
                userInput = inputScanner.nextLine();
                Goat newGoat = new Goat(age, userInput, "goat");
                System.out.println("Enter an ID for the new goat");
                userInput = inputScanner.nextLine();
                PettingZoo.animals.put(userInput, newGoat);
                FileUtils.writeToAnimalList(PettingZoo.animals);
            }
            catch (Exception e) {
                System.out.println("Invalid input, returning to menu\n");
            }
        }
        else if (animalType.equals("2")){
            System.out.println("Enter the new sheep's age");
            try {
                userInput = inputScanner.nextLine();
                age = Integer.parseInt(userInput);
                System.out.println("Enter the new sheep's name");
                userInput = inputScanner.nextLine();
                Sheep newSheep = new Sheep(age, userInput, "sheep");
                System.out.println("Enter an ID for the new sheep");
                userInput = inputScanner.nextLine();
                PettingZoo.animals.put(userInput, newSheep);
                FileUtils.writeToAnimalList(PettingZoo.animals);
            } catch (Exception e) {
                System.out.println("Invalid input, returning to menu\n");
            }
        }
        else if (animalType.equals("3")){
            System.out.println("Enter the new ducks age");
            try {
                userInput = inputScanner.nextLine();
                age = Integer.parseInt(userInput);
                System.out.println("Enter the new ducks name");
                userInput = inputScanner.nextLine();
                Duck newDuck = new Duck(age, userInput, "duck");
                System.out.println("Enter an ID for the new duck");
                userInput = inputScanner.nextLine();
                PettingZoo.animals.put(userInput, newDuck);
                FileUtils.writeToAnimalList(PettingZoo.animals);
            }
            catch (Exception e) {
                System.out.println("Invalid input, returning to menu\n");
            }
        }
    }

    private static void addEmployee(){
        int age = 0;
        String userInput;
        System.out.println("Enter the new employee's age");
        try {
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter the new employee's name");
            userInput = inputScanner.nextLine();
            Employee newEmployee = new Employee(age, userInput);
            System.out.println("Enter an ID for the new employee");
            userInput = inputScanner.nextLine();
            PettingZoo.employees.put(userInput, newEmployee);
            FileUtils.writeToEmployeeList(PettingZoo.employees);
        }
        catch (Exception e) {
            System.out.println("Invalid input, returning to menu\n");
        }
    }

    private static void addVisitor(){
        int age = 0;
        String userInput;
        System.out.println("Enter visitor age");
        try {
            userInput = inputScanner.nextLine();
            age = Integer.parseInt(userInput);
            System.out.println("Enter visitor name");
            userInput = inputScanner.nextLine();
            Visitor newVisitor = new Visitor(age, userInput);
            PettingZoo.visitors.add(newVisitor);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input, returning to menu\n");
        }
    }

    private static void readFromSavedRegistries(){
        PettingZoo.animals = FileUtils.readFromAnimalList("animalList.dat");
        PettingZoo.employees = FileUtils.readFromEmployeeList("employeeList.dat");
    }
}
