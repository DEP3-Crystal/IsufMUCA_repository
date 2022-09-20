package com.randomPersonPickerOOP.managers;

import com.randomPersonPickerOOP.GroupFromFile;
import com.randomPersonPickerOOP.pojo.Person;

import java.util.Random;

public class RandomPersonManager {
    private static final Random randomNumberGenerator = new Random();
    private final GroupFromFile groupFromFile;

    public RandomPersonManager(GroupFromFile groupFromFile) {
        this.groupFromFile = groupFromFile;
    }

    public Person getRandomPerson() {
        Person chosenPerson;
        int index = randomNumberGenerator.nextInt(groupFromFile.getPersons().size());
        while (true) {
            if (groupFromFile.getPersons().get(index).getAvailableChances() != 0) {
                chosenPerson = groupFromFile.getPersons().get(index);
                groupFromFile.getPersons().get(index).decreaseChances();
                groupFromFile.getPersons().get(index).increaseTimesActivated();
                break;
            }
        }
        return chosenPerson;
    }
}
