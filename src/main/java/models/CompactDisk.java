package models;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompactDisk extends Media implements Playable {

    private String artist;

    private ArrayList<Track> tracks;

    public CompactDisk(String artist, ArrayList<Track> tracks, String title, String category, int priceInDollars, String type) {
        super(title, category, priceInDollars, type);
        this.artist = artist;
        this.tracks = tracks;
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

    @Override
    public void play(String title, List<Media> cd) {

        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");

        String songPath = null;

        for (Media element : cd) {

            if (element instanceof CompactDisk) {
                CompactDisk newElement = (CompactDisk) element;
                if (newElement.getTitle().contains(title)) {
                    for (Track tr : tracks) {
                        if (!tr.getPath().isEmpty() || !tr.getPath().isBlank()) {
                            songPath = tr.getPath();
                            break;
                        }
                    }
                }
            }
        }
        assert songPath != null;
        String songFullPath = new File(songPath).getAbsolutePath();
        try {

            if (isWindows) {
                Runtime.getRuntime()
                        .exec(String.format("cmd.exe /c start wmplayer %s", songFullPath));

            } else {
                System.out.println("Your operating system is not supported !");
            }
        } catch (Exception commandException) {
            commandException.printStackTrace();
        }

        System.out.println("Starting...");
        System.out.println("Now playing the playlist: " + title + " by " + artist);

    }
}
