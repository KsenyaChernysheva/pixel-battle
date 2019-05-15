package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;
import sample.controllers.MainController;

public class Main extends Application {
    private Stage primaryStage;
    private Parent root;
    private MainController mainController;
    private ColorPicker colorPicker;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PixelBattle");

        primaryStage.setResizable(false);
        primaryStage.setMinHeight(1030);
        primaryStage.setMaxHeight(1030);
        primaryStage.setMinWidth(1000);
        primaryStage.setMaxWidth(1000);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/views/sample.fxml"));
        root = loader.load();
        mainController = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
