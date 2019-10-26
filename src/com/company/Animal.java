package com.company;

abstract class Animal {
    protected int age;
    protected String name;
    public Animal(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " is a " + age + " year old " + "[INSERT ANIMAL TYPE HERE]" + ".";
    }
}
