package sample.server;


import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;

public class WebSocketServer {

    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String SERVER_CONTEXT_PATH = "/websocket";
    public static final String SERVER_ADDRESS =
            "ws://" + SERVER_HOSTNAME + ":" + SERVER_PORT + SERVER_CONTEXT_PATH;
    private Server server;

    public void start() throws DeploymentException {
        try {
            server = new Server(
                    SERVER_HOSTNAME,
                    SERVER_PORT,
                    SERVER_CONTEXT_PATH,
                    null,
                    WebSocketServerEndpoint.class
            );

            server.start();
        } catch (DeploymentException e) {
            server = null;
            throw e;
        }
    }

    public void stop() {
        if (server != null) {
            server.stop();
        }
    }

}
