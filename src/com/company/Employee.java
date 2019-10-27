package com.company;

public class Employee extends Person{
    private float daySalary = 10.2f;
    public Employee(int age, String name) {
        super(age, name);
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
