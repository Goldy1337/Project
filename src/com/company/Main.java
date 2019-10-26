package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner inputScanner = new Scanner(System.in);
    private static String menuChoice = "";

    public static void main(String[] args) {
        MainMenu();
    }

    private static void MainMenu(){
        while (!menuChoice.equals("4")){
            System.out.println("Welcome to Lush Acres Petting Zoo, please choose your option below\n" +
                    "1. Animal administration\n" +
                    "2. Employee Administration\n" +
                    "3. Help\n" +
                    "4. Exit");
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
                                System.out.println("Add new animal to the petting zoo");
                                break;
                            case "2":
                                System.out.println("Retire animal from the petting zoo");
                                break;
                            case "3":
                                System.out.println("Show all current animals");
                                break;
                            case "4":
                                System.out.println("Show specific animal");
                                break;
                            case "5":
                                System.out.println("Help");
                                break;
                            case "6":
                                System.out.println("Returning to main menu");
                        }
                    }
                    break;
                case "2":
                    System.out.println("bah"); //TODO Detta aktiveras efter return to main menu från undermeny 1...
                    break;
                case "3":
                    System.out.println("Placeholder");
                    break;
                case "4":
                    System.out.println("Exiting program");
            }
        }



    }
}
