package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddItemToStoreScreen extends Stage {
    protected TextField tfTitle;
    protected TextField tfCategory;
    protected TextField tfCost;
    protected Button btnAdd;
    protected Store store; 

    public AddItemToStoreScreen(Store store) {
        this.store = store; 
        this.setTitle("Add Item to Store");
        VBox layout = new VBox(10);

        tfTitle = new TextField();
        tfTitle.setPromptText("Enter Title");

        tfCategory = new TextField();
        tfCategory.setPromptText("Enter Category");

        tfCost = new TextField();
        tfCost.setPromptText("Enter Cost");

        btnAdd = new Button("Add");

        layout.getChildren().addAll(tfTitle, tfCategory, tfCost, btnAdd);
        this.setScene(new Scene(layout, 400, 300));
    }
}
