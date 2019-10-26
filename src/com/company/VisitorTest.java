package com.company;

import static org.junit.Assert.*;

public class VisitorTest {

    @org.junit.Test
    public void getEntranceFee() {
        Visitor visitor = new Visitor(5, "TEST_VISITOR");
        assertNotNull(visitor);


    }
}