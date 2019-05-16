package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import sample.game_proc.Color;
import sample.game_proc.GameTable;
import sample.game_proc.Pixel;

public class MainViewController implements MainView {
    private static final int COUNT_PIXELS = 100;
    private MainController controller;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker picker;

    @FXML
    public void initialize() {
        controller = new MainController(this);
        controller.onViewCreated();

        canvas.setOnMouseClicked(event -> {
            int numberWidthRect = (int) Math.floor(event.getX() / (canvas.getWidth() / COUNT_PIXELS));
            int numberHeightRect = (int) Math.floor(event.getY() / (canvas.getHeight() / COUNT_PIXELS));
            javafx.scene.paint.Color color = picker.getValue();
            Color color1 = new Color(color);
            controller.onPixelClick(new Pixel(numberWidthRect, numberHeightRect, color1));
//            getGraphicsContext().beginPath();
//            getGraphicsContext().moveTo(event.getX(), event.getY());
//            getGraphicsContext().setFill(picker.getValue());
//            getGraphicsContext().setStroke(picker.getValue());
//            getGraphicsContext().stroke();
//            canvas.getGraphicsContext2D().fillRect(numberWidthRect * 10.0, numberHeightRect * 10.0, 10.0, 10.0);

        });
    }

    private GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }

    @Override
    public void drawAll(GameTable table) {
        for (int i = 0; i < table.table.length; i++) {
            for (int j = 0; j < table.table[i].length; j++) {
                drawPixel(i, j, table.table[i][j]);
            }
        }
    }

    @Override
    public void drawPixel(Pixel pixel) {
        drawPixel(pixel.getX(), pixel.getY(), pixel.getColor());
    }

    private void drawPixel(int x, int y, Color color) {
        double pixelWidth = canvas.getWidth() / COUNT_PIXELS;
        double pixelHeight = canvas.getHeight() / COUNT_PIXELS;
        javafx.scene.paint.Color paintColor;
        if (color != null) {
            paintColor = color.toPaintColor();
        } else {
            paintColor = javafx.scene.paint.Color.WHITE;
        }
        getGraphicsContext().setFill(paintColor);
        getGraphicsContext().setStroke(paintColor);
        canvas.getGraphicsContext2D().fillRect(x * pixelWidth,
                y * pixelHeight,
                pixelWidth, pixelHeight);
    }
}
