package com.models;

import java.util.ArrayList;

public class CompactDisk extends Media {

    private String artist;

    private ArrayList<Track> tracks;

    public CompactDisk(String artist, ArrayList<Track> tracks, String title, String category, int priceInDollars, String type) {
        super(title, category, priceInDollars, type);
        this.artist=artist;
        this.tracks=tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
}
