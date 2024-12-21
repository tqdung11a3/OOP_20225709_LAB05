package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    

	

	

	@Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("DVD length is non-positive!");
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }

    @Override
    public String toString() {
        return this.getId() + " DVD " + this.getTitle() + " " + this.getCategory() + " " +
               this.getDirector() + " " + this.getLength() + " " + this.getCost() + "$";
    }
}
