package models;

import java.util.ArrayList;
import java.util.List;

public class Track implements Playable {
    private String name;
    private int length;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Track(String name, int length, String path) {
        this.name = name;
        this.length = length;
        this.path = path;
    }

    @Override
    public void play(String title, List<Media> cd) {
        System.out.println("Starting...");
        System.out.println("Now playing: " + " " + title + " " + name + " length:" + length + " mins");
    }
}
