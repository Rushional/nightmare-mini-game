package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.squares.Square;
import com.rushional.nightmare_game.views.gui.GraphicsCoordinates;
import lombok.Getter;

import java.awt.*;

@Getter
public class SquareView {
    private final Square square;
    private final GraphicsCoordinates coordinates;
    private final Rectangle rectangle;

    public SquareView(Square square, GraphicsCoordinates coords) {
        this.square = square;
        this.coordinates = coords;
        rectangle = new Rectangle(coords.getX(), coords.getY(), getSide(), getSide());
    }

    private static int getSide() {
        return MapView.getSquareSidePx();
    }
}
