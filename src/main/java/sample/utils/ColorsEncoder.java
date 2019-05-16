package sample.utils;

import com.google.gson.Gson;
import javafx.scene.paint.Color;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ColorsEncoder implements Encoder.Text<Color> {

    private static Gson gson = new Gson();

    @Override
    public String encode(Color color) throws EncodeException {
        return gson.toJson(color);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}