package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.server.WebSocketServer;

import javax.websocket.DeploymentException;

public class Main extends Application {

    private WebSocketServer server;

    public void init() throws DeploymentException {
        server = new WebSocketServer();
        server.start();
    }

    public void stop() {
        server.stop();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        while (true) {
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
