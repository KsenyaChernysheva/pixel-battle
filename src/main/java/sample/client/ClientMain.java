package sample.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.glassfish.tyrus.client.ClientManager;
import sample.controllers.MainController;

import javax.websocket.Session;
import java.net.URI;

public class ClientMain extends Application {
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String SERVER_CONTEXT_PATH = "/websocket";
    public static final String SERVER_ADDRESS =
            "ws://" + SERVER_HOSTNAME + ":" + SERVER_PORT + SERVER_CONTEXT_PATH + "/hello";

    private Session session;
    private Stage primaryStage;
    private Parent root;
    private MainController mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        session = ClientManager.createClient().connectToServer(WebSocketClientEndpoint.class, new URI(SERVER_ADDRESS));
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PixelBattle");

        primaryStage.setResizable(false);
        primaryStage.setMinHeight(1030);
        primaryStage.setMaxHeight(1030);
        primaryStage.setMinWidth(1000);
        primaryStage.setMaxWidth(1000);

        FXMLLoader loader = new FXMLLoader();
        // loader.setLocation(Main.class.getResource("/views/sample.fxml"));
        root = loader.load(getClass().getResourceAsStream("/views/sample.fxml"));
        mainController = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
