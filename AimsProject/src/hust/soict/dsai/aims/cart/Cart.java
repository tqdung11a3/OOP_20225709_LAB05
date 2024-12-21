package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    

	public Cart() {
		super();
	}

	public Cart(ObservableList<Media> itemsOrdered) {
		super();
		this.itemsOrdered = itemsOrdered;
	}

	public void addMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            System.out.println("The media has already been in the cart.");
        } else {
            itemsOrdered.add(m);
            System.out.println("Add: " + m.getTitle());
        }
    }

    public void removeMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
            System.out.println("Remove: " + m.getTitle());
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public void searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found media: " + m.getTitle() + " - $" + m.getCost());
                return;
            }
        }
        System.out.println("Media not found with ID: " + id);
    }

    public void searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equals(title)) {
                System.out.println("Found media: " + m.getTitle());
                return;
            }
        }
        System.out.println("Media not found with title: " + title);
    }

    public void searchByPriceRange(float minPrice, float maxPrice) { 
        for (Media m : itemsOrdered) {
            if (m.getCost() >= minPrice && m.getCost() <= maxPrice) {
                System.out.println(m.getTitle() + " " + m.getCost() + "$");
                return;
            }
        }
        System.out.println("Not found media");
      
    }
    
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    
    public void displayCart() {
        System.out.println("Items in the cart:");
        for (Media m : itemsOrdered) {
            System.out.println(m.getTitle() + " - $" + m.getCost());
        }
        System.out.println("Total cost: $" + totalCost());
    }
    
    
}
