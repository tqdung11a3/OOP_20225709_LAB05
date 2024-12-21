package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private TextField tfDirector;
    private TextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store); 
        tfDirector = new TextField();
        tfDirector.setPromptText("Enter Director");

        tfLength = new TextField();
        tfLength.setPromptText("Enter Length");

        VBox layout = (VBox) this.getScene().getRoot();
        layout.getChildren().addAll(tfDirector, tfLength);

        btnAdd.setOnAction(e -> {
            try {
            	int id;
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());

                DigitalVideoDisc dvd = new DigitalVideoDisc(1, title, category, cost);

                // Add DVD to the store
                store.addMedia(dvd);

                new Alert(Alert.AlertType.INFORMATION, "DVD added to store!").showAndWait();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Invalid input! Please enter valid numbers for cost and length.").showAndWait();
            }
        });
    }
}
