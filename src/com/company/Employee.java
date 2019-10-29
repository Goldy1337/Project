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
        for (EmployeeNotes noteList : employeeNotesList){
            System.out.println("#" + i + ": " + noteList.getNote());
            i++;
        }
    }

    public void removeEmployeeNote(int i){
        i = i - 1;
        if (employeeNotesList.contains(employeeNotesList.get(i))){
            employeeNotesList.remove(i);
        }
        else
            System.out.println("No note found with that number");
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
