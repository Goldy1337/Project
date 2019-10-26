package com.company;

public class Duck extends Animal{
    protected final String typeOfAnimal = "duck";
    public Duck(int age, String name) {
        super(age, name);
    }
    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }
}
