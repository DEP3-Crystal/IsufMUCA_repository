package models;

import java.util.List;

@FunctionalInterface
public interface Playable {

    void play(String title, List<Media> cd);
}
