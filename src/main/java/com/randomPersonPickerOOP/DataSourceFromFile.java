package com.randomPersonPickerOOP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class DataSourceFromFile implements DataSource {

    private final String filePath;
    private final Properties fileProperties = new Properties();

    public DataSourceFromFile(String filePath) throws IOException {
        this.filePath = filePath;
        fileProperties.load(new FileInputStream(filePath));
    }

    @Override
    public ArrayList<Person> getAllRecords() throws IOException {
        ArrayList<Person> allRecords = new ArrayList<>();
        for (Object email : fileProperties.values()) {
            Person person = new Person(email.toString());
            allRecords.add(person);
        }
        return allRecords;
    }


    @Override
    public void addRecord(String email, Integer number) {
        fileProperties.setProperty(email, number.toString());
        try {
            fileProperties.store(new FileOutputStream(filePath), "");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Integer getRecord(String email) {
        return Integer.parseInt(fileProperties.getProperty(email));
    }

}
