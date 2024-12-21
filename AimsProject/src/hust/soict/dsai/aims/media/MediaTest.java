package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        Book book = new Book(1, "One piece", "Action", 25.50f);
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "Available", "Comedy", 110.05f, 300, "TQDUNG");
        CompactDisc cd = new CompactDisc(3, "Lovica", "Music", 20.10f, 130, "Famousist");

        mediaList.add(book);
        mediaList.add(dvd);
        mediaList.add(cd);

        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
