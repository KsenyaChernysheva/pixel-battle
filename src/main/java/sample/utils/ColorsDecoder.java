package sample.utils;

import com.google.gson.Gson;
import javafx.scene.paint.Color;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ColorsDecoder implements Decoder.Text<Color> {

    private static Gson gson = new Gson();

    @Override
    public Color decode(String s) throws DecodeException {
        return gson.fromJson(s, Color.class);
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        //Custom initialization logic
    }

    @Override
    public void destroy() {
        //Close resources
    }
}