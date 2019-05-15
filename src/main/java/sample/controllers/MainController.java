package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class MainController {
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker picker;

    @FXML
    public void initialize() {
        canvas.setOnMouseClicked(event -> {
            long numberHeightRect = (int) Math.floor(event.getX() / (canvas.getHeight() / 100));
            long numberWidthRect = (int) Math.floor(event.getY() / (canvas.getWidth() / 100));

            getGraphicsContext().beginPath();
            getGraphicsContext().moveTo(event.getX(), event.getY());
            getGraphicsContext().setFill(picker.getValue());
            getGraphicsContext().setStroke(picker.getValue());
            getGraphicsContext().stroke();

            canvas.getGraphicsContext2D().fillRect(numberHeightRect * 10.0, numberWidthRect * 10.0, 10.0, 10.0);

        });

    }

    private GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }
}
