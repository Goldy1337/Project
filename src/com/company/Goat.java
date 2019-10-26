package com.company;

public class Goat extends Animal{
    protected final String typeOfAnimal = "goat";
    public Goat(int age, String name) {
        super(age, name);
    }
    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

}
