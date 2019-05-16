package sample.game_proc;

import com.sun.istack.internal.Nullable;

public class Message {
    @Nullable
    private Pixel pixel;
    @Nullable
    private GameTable gameTable;

    public Message(Pixel pixel, GameTable gameTable) {
        this.pixel = pixel;
        this.gameTable = gameTable;
    }

    public Message(Pixel pixel) {
        this.pixel = pixel;
    }

    public Message(GameTable gameTable) {
        this.gameTable = gameTable;
    }

    public Pixel getPixel() {
        return pixel;
    }

    public void setPixel(Pixel pixel) {
        this.pixel = pixel;
    }

    public GameTable getGameTable() {
        return gameTable;
    }

    public void setGameTable(GameTable gameTable) {
        this.gameTable = gameTable;
    }
}
