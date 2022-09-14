package com.randomPersonPickerOOP;

import java.io.IOException;
import java.util.ArrayList;

public class GroupFromFile {
    //TODO query data from external file
    private final ArrayList<Person> persons;
    private final DataSourceFromFile dataSourceFromFile;

    public GroupFromFile(String filePath) throws IOException {

        dataSourceFromFile = new DataSourceFromFile(filePath);
        persons=dataSourceFromFile.getAllRecords();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public boolean checkAvailableChances() {
        for (Person person : persons) {
            if (person.getAvailableChances() != 0) {
                return true;
            }
        }
        return false;
    }

    public void printPersons() {
        int count = 1;
        for (Person person : persons) {
            System.out.println(count + ") " + person.getName() + " " + person.getSurname() + " " + person.getEmail());
            count++;
        }
    }

    public void printTimesActivated() {
        int count = 1;
        for (Person person : persons) {
            System.out.println(count + ") " + person.getName() + " " + person.getSurname() + " is Activated: " + person.getTimesActivated() + " in Total");
            count++;
        }
    }

    public void printTimesActivated(String email) {
        for (Person person : persons) {
            if (person.getEmail().equals(email)) {
                System.out.println("1)" + person.getName() + " " + person.getSurname() + " is Activated: " + person.getTimesActivated() + " in Total");
            }
        }
    }

    public void fillChances() {
        for (Person person : persons) {
            person.increaseChances();
        }
    }


}
