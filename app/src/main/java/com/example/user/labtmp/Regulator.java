package com.example.user.labtmp;

import java.util.ArrayList;

/**
 * Created by user on 08.06.2017.
 */

public class Regulator {
    String firstName;
    String surname;
    String midleName;
    int tabNumber;
    ArrayList<LaboratoryDevice> deviceList;

    public Regulator(String surname, String firstName,  String midleName) {
        this.firstName = firstName;
        this.surname = surname;
        this.midleName = midleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getMidleName() {
        return midleName;
    }
}
