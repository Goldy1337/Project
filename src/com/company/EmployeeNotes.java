package com.company;

import java.io.Serializable;

public class EmployeeNotes implements Serializable {
    private String note;
    public EmployeeNotes(String note){
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}
