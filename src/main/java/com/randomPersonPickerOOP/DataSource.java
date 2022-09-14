package com.randomPersonPickerOOP;

import java.io.IOException;
import java.util.ArrayList;

public interface DataSource {
    ArrayList<Person> getAllRecords() throws IOException;

    void addRecord(String email, Integer number);

    Integer getRecord(String email);
}
