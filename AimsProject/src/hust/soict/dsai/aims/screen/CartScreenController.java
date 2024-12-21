package hust.soict.dsai.aims.screen;

import java.awt.event.ActionEvent;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML
    private MenuItem AddBook;

    @FXML
    private MenuItem AddCD;

    @FXML
    private MenuItem AddDVD;

    @FXML
    private Menu Options;

    @FXML
    private Menu UpdateStore;

    @FXML
    private MenuItem ViewCart;

    @FXML
    private MenuItem ViewStore;
    
    

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

   

    private void showFilteredMedia(String newValue) {
        
        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), media -> {
            
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            String lowerCaseFilter = newValue.toLowerCase();

            
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false; 
        });

        
        tblMedia.setItems(filteredList);
    }
    
    void btnPlaceOrderPressed(ActionEvent event) {
        tblMedia.setItems(cart.getItemsOrdered()); // Refresh the TableView
        lblTotalCost.setText(String.format("Total Cost: $%.2f", cart.totalCost()));
        new Alert(Alert.AlertType.INFORMATION, "Order placed successfully!").showAndWait();
    }
    
    private void updateTotalCost() {
        lblTotalCost.setText(String.format("Total Cost: $%.2f", cart.totalCost()));
    }
    
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }
    
    void btnAddToCartPressed(Media media) {
        cart.addMedia(media);
        new Alert(Alert.AlertType.INFORMATION, "Item added to cart!").showAndWait();
    }



    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        );

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });


        ListChangeListener<Media> listener = change -> updateTotalCost();
        cart.getItemsOrdered().addListener(listener);


        updateTotalCost(); 
    }
}
