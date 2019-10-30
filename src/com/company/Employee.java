package com.company;

import java.util.ArrayList;

/**
 * <h1>Employee class</h1>
 * This class represents an employee for the petting zoo.
 *
 * @author Viktor S.
 * @version 1
 * @since 26/10/2019
 */
public class Employee extends Person{
    /**
     * This represents the daily salary of the employee, used in the calculation of the daily profits.
     */
    private float daySalary = 10.2f;
    /**
     * This holds the EmployeeNotes class, used to attach notes to any employee.
     */
    public ArrayList<EmployeeNotes> employeeNotesList = new ArrayList<>();
    /**
     *
     * @param age The employees age.
     * @param name The employees name.
     */
    public Employee(int age, String name) {
        super(age, name);
    }

    /**
     * This method will print out all the notes attached to the employee specified in the MainMenu.
     */
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

    /**
     * This method will remove the specified note.
     * @param i The specified note number as seen by the user.
     */
    public void removeEmployeeNote(int i){
        i = i - 1;
        try {
            employeeNotesList.remove(i);
            i = i + 1;
            System.out.println("Removing note #" + i + "\n");
        }
        catch (Exception e) {
            System.out.println("Note not found, returning to menu\n");;
        }
    }

    /**
     * This method is a part of the daily profit calculation.
     * @return This returns the costs of the employees wages to be subtracted from the profits.
     */
    @Override
    public float profitCalculation() {
        return -10.2f;
    }

    /**
     * This method prints out information of the employee specified in the MainMenu.
     * @return This returns the employees name, age and daily salary.
     */
    @Override
    public String toString() {
        return name + " is a " + age + " year old employee with a daily salary of " + daySalary + "$.";
    }
}
