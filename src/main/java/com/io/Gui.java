package com.io;

import com.models.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Gui {
    private static final Scanner input = new Scanner(System.in);

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

    public String menu() {
        System.out.println("Select an option from below please !");
        System.out.println("1. View all products.");
        System.out.println("2. View books.");
        System.out.println("3. View compact disks.");
        System.out.println("4. View digital video disks.");
        System.out.println("5. View your order.");
        String answer = input.next();
        if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
            return answer;
        }
        return null;
    }

    public void displayYourOrder(Map<Media, Integer> orders) {
        System.out.println();
        for (Map.Entry<Media, Integer> order : orders.entrySet()) {
            System.out.println(order.getKey().getTitle() + ", " + order.getKey().getType() + ", count: " + order.getValue());
        }
    }

    public void display(List<Media> mediaList, MediaType mediaType) {
        if (mediaType.equals(MediaType.BOOK)) {
            for (Media media : mediaList) {
                if (media instanceof Book) {
                    Book book = (Book) media;
                    System.out.println("<===============================================================>");
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Category: " + book.getCategory());
                    System.out.println("Price: $" + book.getPriceInDollars());
                    System.out.println("Type: " + book.getType());
                    System.out.println("Authors: ");
                    for (String author : book.getAuthors()) {
                        System.out.println("-" + author);
                    }
                    System.out.println();
                    System.out.println("<===============================================================>");
                }
            }
        } else if (mediaType.equals(MediaType.COMPACT_DISK)) {
            for (Media media : mediaList) {
                if (media instanceof CompactDisk) {
                    CompactDisk compactDisk = (CompactDisk) media;
                    System.out.println("<===============================================================>");
                    System.out.println("Title: " + compactDisk.getTitle());
                    System.out.println("Category: " + compactDisk.getCategory());
                    System.out.println("Price: $" + compactDisk.getPriceInDollars());
                    System.out.println("Type: " + compactDisk.getType());
                    System.out.println("Artist: " + compactDisk.getArtist());
                    System.out.println("Tracks: ");
                    for (Track track : compactDisk.getTracks()) {
                        System.out.println("Name: " + track.getName());
                        System.out.println("Length: " + track.getLength());
                    }
                    System.out.println();
                    System.out.println("<===============================================================>");
                }
            }
        } else {
            for (Media media : mediaList) {
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc digitalVideoDisk = (DigitalVideoDisc) media;
                    System.out.println("<===============================================================>");
                    System.out.println("Title: " + digitalVideoDisk.getTitle());
                    System.out.println("Category: " + digitalVideoDisk.getCategory());
                    System.out.println("Price: $" + digitalVideoDisk.getPriceInDollars());
                    System.out.println("Type: " + digitalVideoDisk.getType());
                    System.out.println("Director: " + digitalVideoDisk.getDirector());
                    System.out.println("Length: " + digitalVideoDisk.getLengthInMinutes() + " minutes");
                    System.out.println();
                    System.out.println("<===============================================================>");
                }
            }
        }
    }

    public String order() {
        System.out.println("Enter title of product you want to order: ");
        String title = input.next();
        return title;
    }

    public boolean quit() {
        System.out.println("You want to order something else or quit ?");
        System.out.println("1. Order something else !");
        System.out.println("2. Quit !");
        System.out.println("Answer: ");
        String ans = input.next();

        if (ans.equals("2")) {
            return true;
        }
        return false;
    }

    public void warnInvalidInput() {
        System.out.println("You inserted some invalid input !");
    }

    public void salute() {
        System.out.println("Good Bye !");
    }

}
