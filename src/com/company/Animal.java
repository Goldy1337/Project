package com.company;

abstract class Animal {
    protected int age;
    protected String name;
    protected String animalType;
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
