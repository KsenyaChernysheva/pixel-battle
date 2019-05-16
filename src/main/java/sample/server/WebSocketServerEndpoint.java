package sample.server;

import sample.game_proc.GameTable;
import sample.game_proc.Pixel;
import sample.utils.PixelDecoder;
import sample.utils.PixelEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/hello", decoders = PixelDecoder.class, encoders = PixelEncoder.class)
public class WebSocketServerEndpoint {
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(Pixel pixel) {
        GameTable.getInstance().table[pixel.getX()][pixel.getY()] = pixel.getColor();
        System.out.println("server " + pixel);

        peers.forEach(peer -> {
            synchronized (peer) {
                try {
                    peer.getBasicRemote().sendObject(pixel);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @OnOpen
    public void onOpen(Session peer) throws IOException, EncodeException {
        peers.add(peer);
        System.out.println("server connect");
//        peer.getBasicRemote().sendObject(GameTable.getInstance());
        //отправить при подключении
    }

    @OnClose
    public void onClose(Session peer) {
        peers.remove(peer);
    }
}