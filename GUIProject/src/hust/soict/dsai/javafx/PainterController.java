package hust.soict.dsai.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private int mode = 0;
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4);
    	if (mode == 0) newCircle.setFill(Color.BLACK);
    	else if (mode == 1) newCircle.setFill(Color.WHITE);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void changeModePen(ActionEvent event) {
    	mode = 0;
    }
    
    @FXML
    void changeModeEraser(ActionEvent event) {
    	mode = 1;
    }

}
