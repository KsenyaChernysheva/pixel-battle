package sample.server;

import sample.game_proc.GameTable;
import sample.game_proc.Message;
import sample.utils.MessageDecoder;
import sample.utils.MessageEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/hello", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class WebSocketServerEndpoint {
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(Message message) {
        GameTable.getInstance().table[message.getPixel().getX()][message.getPixel().getY()] = message.getPixel().getColor();
        System.out.println("server " + message);

        peers.forEach(peer -> {
            synchronized (peer) {
                try {
                    peer.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @OnOpen
    public void onOpen(Session peer) throws IOException, EncodeException {
        peers.add(peer);
        //  System.out.println("server connect");
        peer.getBasicRemote().sendObject(new Message(GameTable.getInstance()));
        //отправить при подключении
    }

    @OnClose
    public void onClose(Session peer) {
        peers.remove(peer);
    }
}