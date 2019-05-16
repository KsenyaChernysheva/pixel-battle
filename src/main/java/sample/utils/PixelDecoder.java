package sample.utils;

import com.google.gson.Gson;
import sample.game_proc.Pixel;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class PixelDecoder implements Decoder.Text<Pixel> {

    private static Gson gson = new Gson();

    @Override
    public Pixel decode(String s) throws DecodeException {
        return gson.fromJson(s, Pixel.class);
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

