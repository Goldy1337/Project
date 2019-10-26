package com.company;

public class Visitor extends Person{
    public Visitor(int age, String name) {
        super(age, name);
    }

    public float getEntranceFee(){
        int age = getAge();
        if (age <= 8)
            return 0f;
        else if (age <= 18)
            return 3.60f;
        else
            return 8.9f;
    }
}
