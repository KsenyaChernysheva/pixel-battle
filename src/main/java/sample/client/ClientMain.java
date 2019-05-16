package sample.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.MainViewController;

public class ClientMain extends Application {

    private Stage primaryStage;
    private Parent root;
    private MainViewController mainViewController;

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
        root = loader.load(getClass().getResourceAsStream("/views/sample.fxml"));
        mainViewController = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
