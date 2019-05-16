package sample.controllers;

import org.glassfish.tyrus.client.ClientManager;
import sample.client.WebSocketClientEndpoint;
import sample.game_proc.GameTable;
import sample.game_proc.Pixel;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainController {
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String SERVER_CONTEXT_PATH = "/websocket";
    public static final String SERVER_ADDRESS =
            "ws://" + SERVER_HOSTNAME + ":" + SERVER_PORT + SERVER_CONTEXT_PATH + "/hello";

    private Session session;
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public void onViewCreated() {
        try {
            session = ClientManager.createClient().connectToServer(WebSocketClientEndpoint.class, new URI(SERVER_ADDRESS));
            session.addMessageHandler((MessageHandler.Whole<Pixel>) message -> {
                mainView.drawPixel(message);
                GameTable.getInstance().table[message.getX()][message.getY()] = message.getColor();
            });
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void onPixelClick(Pixel pixel) {
        if (session != null) {
            try {
                session.getBasicRemote().sendObject(pixel);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (EncodeException e) {
                e.printStackTrace();
            }
        }
    }
}
