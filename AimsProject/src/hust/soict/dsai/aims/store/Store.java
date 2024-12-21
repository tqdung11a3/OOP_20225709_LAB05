package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    
    
    
    public Store() {
		super();
	}
    
    

	public Store(ArrayList<Media> itemsInStore) {
		super();
		this.itemsInStore = itemsInStore;
	}



	public boolean checkMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
                System.out.println("The media " + title + " has been available in the store.");
                return true;
            }
        }
        System.out.println("The media " + title + " has been not available in the store.");
        return false;
    }

    public void addMedia(Media m) {
        if (!checkMedia(m.getTitle())) {
        	itemsInStore.add(m);
            System.out.println("Added: " + m.getTitle() + " to the store.");
        }
        else {
        	System.out.println("The media has already been in the store");
        }
    }

    public void removeMedia(Media m) {
        if (itemsInStore.contains(m)) {
            itemsInStore.remove(m);
            System.out.println("Removed: " + m.getTitle() + " from the store.");
        } else {
            System.out.println("The media " + m.getTitle() + " is not found in the store.");
        }
    }

    public ArrayList<Media> getItemsInStore() { 
    	return itemsInStore; 
    }

    public void print() {
        System.out.println("Items in the store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". Title: " + media.getTitle() +
                               ", Category: " + media.getCategory() +
                               ", Cost: $" + media.getCost());
        }
    }
}
