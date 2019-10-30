package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class VisitorTest {

    @Test
    public void profitCalculation() {
        Visitor childVisitor = new Visitor(5, "Simon");
        float entranceFee = childVisitor.profitCalculation();
        assertEquals(0f, entranceFee, 0.0);

        Visitor teenVisitor = new Visitor(15, "Ida");
        float entranceFee2 = teenVisitor.profitCalculation();
        assertEquals(3.6f, entranceFee2, 0.0);

        Visitor adultVisitor = new Visitor(54, "Sebastian");
        float entranceFee3 = adultVisitor.profitCalculation();
        assertEquals(8.9f, entranceFee3, 0.0);
    }
}