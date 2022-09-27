package com.randomPersonPickerOOP.data;

import com.randomPersonPickerOOP.pojo.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface DataSource {
    ArrayList<Person> getAllRecords() throws IOException;

    void addRecord(String email, Integer number);

    Integer getRecord(String email);
}
