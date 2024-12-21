package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();

        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                CartScreenController controller = new CartScreenController(cart);
                loader.setController(controller);
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        Cart cart = new Cart();


        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "DVD1's title", "category1", 7.87f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "DVD2's title", "category2", 7.87f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "DVD3's title", "category3", 7.87f);
        cart.addMedia(dvd);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);


        CartScreen cs = new CartScreen(cart);
        cs.setSize(1024, 788);
    }
}