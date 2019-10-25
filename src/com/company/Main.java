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
                        System.out.println("Lush Acres Animal Administration");
                        menuChoice = inputScanner.nextLine();
                        switch (menuChoice){
                            case "1":
                                System.out.println("Placeholder");
                            case "2":
                                System.out.println("Placeholder");
                            case "3":
                                System.out.println("Placeholder");
                            case "4":
                                System.out.println("Placeholder");
                            case "5":
                                System.out.println("Placeholder");
                                break;
                            case "6":
                                System.out.println("Returning to main menu");
                                break;
                        }
                    }
                case "2":
                    System.out.println("Placeholder");
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
