package com.company;

import java.io.Serializable;

abstract class Person implements Serializable {
    protected int age;
    protected String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public abstract float profitCalculation();

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
