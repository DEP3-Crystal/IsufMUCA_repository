package com.io;

import com.models.Book;
import com.models.DigitalVideoDisc;
import com.models.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Gui {

    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<DigitalVideoDisc> loadedDiscs;
    private static ArrayList<Book> loadedBooks;


    public void greet() {
        System.out.println("Hello !");
    }

    public Order promptUserData() {

        String name, surname, phoneNumber, email;

        System.out.println("Please fill the form below to continue with the order !\n");

        System.out.println("Your name: ");
        name = input.next();

        System.out.println("Your surname: ");
        surname = input.next();

        System.out.println("Your email: ");
        email = input.next();

        System.out.println("Your phone number: ");
        phoneNumber = input.next();

        return new Order(name, surname, email, phoneNumber);
    }




}
