package sample.utils;

import com.google.gson.Gson;
import sample.game_proc.Pixel;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class PixelEncoder implements Encoder.Text<Pixel> {

    private static Gson gson = new Gson();

    @Override
    public String encode(Pixel pixel) throws EncodeException {
        return gson.toJson(pixel);
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

