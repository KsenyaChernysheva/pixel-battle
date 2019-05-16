package sample.game_proc;

public class GameTable {
    private static GameTable instance;

    public Color[][] table = new Color[100][100];

    private GameTable() {
    }

    public static GameTable getInstance() {
        if (instance == null) {
            instance = new GameTable();
        }
        return instance;
    }
}
