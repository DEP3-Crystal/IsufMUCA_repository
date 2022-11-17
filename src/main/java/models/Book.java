package models;

import java.util.ArrayList;

public class Book extends Media {
    private final ArrayList<String> authors;

    public Book(String title, String category, int priceInDollars, String type, ArrayList<String> authors) {
        super(title, category, priceInDollars, type);
        this.authors = authors;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", priceInDollars=" + priceInDollars +
                ", type='" + type + '\'' +
                '}';
    }
}
