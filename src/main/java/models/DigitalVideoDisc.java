package models;

import java.util.ArrayList;
import java.util.List;

public class DigitalVideoDisc extends Media implements Playable {
    private final String director;
    private final int lengthInMinutes;

    public DigitalVideoDisc(String title, String category, int priceInDollars, String type, String director, int lengthInMinutes) {
        super(title, category, priceInDollars, type);
        this.director = director;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getDirector() {
        return director;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "director='" + director + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", priceInDollars=" + priceInDollars +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void play(String title, List<Media> cd) {
        System.out.println("Starting...");
        System.out.println("Now playing: " + title + " length:" + lengthInMinutes + " mins");
    }
}
