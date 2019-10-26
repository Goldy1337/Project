package com.company;

public class Employee extends Person{
    private float salary;
    protected Employee(int age, String name, float salary) {
        super(age, name);
    }
}
