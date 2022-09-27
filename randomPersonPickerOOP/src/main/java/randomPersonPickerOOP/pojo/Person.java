package com.randomPersonPickerOOP.pojo;

import com.randomPersonPickerOOP.data.DataSourceFromFile;

import java.io.IOException;

public class Person {

    private final String email;
    private final String name;
    private final String surname;
    private Integer timesActivated;

    private Integer availableChances;

    private final DataSourceFromFile employeeActivations= new DataSourceFromFile("src/main/resources/EmployeeActivations.properties");

    public Person(String email) throws IOException {
        String tempName, tempSurname;
        this.email = email;

        //Format name and surname, first letters in uppercase

        tempName = email.substring(0, email.indexOf("."));
        if (tempName.contains("-")) {
            int index = tempName.indexOf("-");
            tempName = (tempName.charAt(0) + "").toUpperCase() + tempName.substring(1, index) + "-" + (tempName.substring(index + 1).charAt(0) + "").toUpperCase() + tempName.substring(index + 2);
            this.name = tempName;
        } else {
            name = (tempName.charAt(0) + "").toUpperCase() + tempName.substring(1);
        }
        tempSurname = email.substring(email.indexOf(".") + 1, email.indexOf("@"));
        surname = (tempSurname.charAt(0) + "").toUpperCase() + tempSurname.substring(1);
        availableChances = 10;
        timesActivated = employeeActivations.getRecord(email);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getTimesActivated() {
        return timesActivated;
    }

    public int getAvailableChances() {
        return availableChances;
    }

    public void increaseChances() {
        availableChances = 10;
    }

    public void decreaseChances() {
        availableChances--;
    }

    public void increaseTimesActivated() {
        timesActivated++;
        employeeActivations.addRecord(email, timesActivated);
    }
}
