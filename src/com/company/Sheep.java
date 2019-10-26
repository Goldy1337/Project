package com.company;

public class Sheep extends Animal{
    protected final String typeOfAnimal = "sheep";
    public Sheep(int age, String name) {
        super(age, name);
    }
    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }
}
