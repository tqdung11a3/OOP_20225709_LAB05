package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track t) {
        if (!tracks.contains(t)) {
            tracks.add(t);
            System.out.println("Track added: " + t.getTitle());
        } else {
            System.out.println("Track already exists: " + t.getTitle());
        }
    }

    public void removeTrack(Track t) {
        if (tracks.contains(t)) {
            tracks.remove(t);
            System.out.println("Track removed: " + t.getTitle());
        } else {
            System.out.println("Track not found: " + t.getTitle());
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track t : tracks) {
            totalLength += t.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Total Length: " + this.getLength() + " seconds");

        for (Track t : tracks) {
            try {
                t.play(); 
            } catch (PlayerException e) {
                System.err.println("Error playing track: " + t.getTitle());
                throw e; 
            }
        }
    }

    @Override
    public String toString() {
        return this.getId() + " CD " + this.getTitle() + " " + this.getCategory() + " " +
               this.getDirector() + " " + this.artist + " " + this.getLength() + " " + this.getCost() + "$";
    }
}
