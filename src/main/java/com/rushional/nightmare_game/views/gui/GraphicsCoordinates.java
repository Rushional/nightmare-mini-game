package com.rushional.nightmare_game.views.gui;

import lombok.Getter;

@Getter
public class GraphicsCoordinates {
    private final int x;
    private final int y;

    public GraphicsCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
