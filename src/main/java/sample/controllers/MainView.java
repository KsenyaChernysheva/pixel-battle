package sample.controllers;

import sample.game_proc.GameTable;
import sample.game_proc.Pixel;

public interface MainView {
    void drawAll(GameTable table);

    void drawPixel(Pixel pixel);
}
