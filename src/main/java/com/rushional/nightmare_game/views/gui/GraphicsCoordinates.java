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

    public static GraphicsCoordinates shift(GraphicsCoordinates origin, int x, int y) {
        return new GraphicsCoordinates(origin.getX() + x, origin.getY() + y);
    }
}
