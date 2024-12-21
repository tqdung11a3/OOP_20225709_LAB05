package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        ArrayList<Track> track = new ArrayList<>();
        track.add(new Track("Bohemian Rhapsody", 500));
        track.add(new Track("Stairway to Heaven", 142));
        track.add(new Track("Hotel California", 346));

        CompactDisc cd = new CompactDisc(101, "Thriller", "Pop", 14.99f, 500, "John Landis", "Michael Jackson", track);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(201, "The Godfather", "Drama", 19.99f, 0, "Coppola"); // Length 0 to test exception

        Store store = new Store();
        store.addMedia(cd);
        store.addMedia(dvd1);

        Cart cart = new Cart();

        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.print("Enter number: ");
            int option = sc.nextInt();

            if (option == 0) {
                System.out.println("Exiting program...");
                sc.close();
                System.exit(0);
            } else if (option == 1) {
                storeMenu();
                System.out.print("Enter option: ");
                int storeOption = sc.nextInt();

                if (storeOption == 3) {
                    System.out.println("Select media to play:");
                    System.out.println("1. CD: Thriller");
                    System.out.println("2. DVD: The Godfather");
                    int playOption = sc.nextInt();

                    try {
                        if (playOption == 1) {
                            cd.play();
                        } else if (playOption == 2) {
                            dvd1.play();
                        }
                    } catch (PlayerException e) {
                        System.err.println("Error playing media: " + e.getMessage());
                        e.printStackTrace();

                        JOptionPane.showMessageDialog(null,
                                "Exception occurred while playing media:\n" + e.getMessage(),
                                "PlayerException",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (option == 3) {
                cartMenu();
                System.out.println("Cart cannot be developed");
            }
        }
    }
}
