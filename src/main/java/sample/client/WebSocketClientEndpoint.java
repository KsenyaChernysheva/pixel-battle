package sample.client;

import sample.utils.PixelDecoder;
import sample.utils.PixelEncoder;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnOpen;

@ClientEndpoint(decoders = PixelDecoder.class, encoders = PixelEncoder.class)
public class WebSocketClientEndpoint {

    @OnOpen
    public void onOpen() {
//        GameTable.getInstance().table = colors.table;
        System.out.println("client open");
    }
//
//    @OnMessage
//    public void onMessage(Pixel pixel) {
//        GameTable.getInstance().table[pixel.getX()][pixel.getY()] = pixel.getColor();
//        System.out.println(pixel);
//    }
}
