package com.company;

import java.io.Serializable;

abstract class Animal implements Serializable {
    private int age;
    private String name;
    private String animalType;
    public Animal(int age, String name, String animalType){
        this.age = age;
        this.name = name;
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return name + " is a " + age + " year old " + animalType + ".";
    }
}
