package com.randomPersonPickerOOP;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        GroupFromFile groupFromFile;
        UserInterfaceManager userInterfaceManager;

        try {

            groupFromFile =new GroupFromFile("src/main/resources/CrystalEmployees.properties");
            userInterfaceManager=new UserInterfaceManager(groupFromFile);
            userInterfaceManager.start();

        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }
}
