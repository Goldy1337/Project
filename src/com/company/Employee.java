package com.company;

import java.util.ArrayList;

public class Employee extends Person{
    private float daySalary = 10.2f;
    public ArrayList<EmployeeNotes> employeeNotesList = new ArrayList<>();
    public Employee(int age, String name) {
        super(age, name);
    }

    public void getEmpoyeeNoteList(){
        int i = 1;
        try {
            for (EmployeeNotes noteList : employeeNotesList){
                System.out.println("#" + i + ": " + noteList.getNote());
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Error occurred, returning to menu");
        }
    }

    public void removeEmployeeNote(int i){
        i = i - 1;
        try {
            employeeNotesList.remove(i);
            System.out.println("Removing note #" + i + "\n");
        }
        catch (Exception e) {
            System.out.println("Note not found, returning to menu\n");;
        }
    }

    @Override
    public float profitCalculation() {
        return -10.2f;
    }

    @Override
    public String toString() {
        return name + " is a " + age + " year old employee with a daily salary of " + daySalary + "$.";
    }
}
