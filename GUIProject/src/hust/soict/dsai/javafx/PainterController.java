package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private AnchorPane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawAreaMouseDragged(MouseEvent event) {
        Color color = penRadioButton.isSelected() ? Color.BLACK : Color.WHITE; 
        Circle circle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(circle);
    }
}
