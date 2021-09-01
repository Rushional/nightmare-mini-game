package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.squares.Square;
import com.rushional.nightmare_game.views.gui.GraphicsCoordinates;
import lombok.Getter;

import java.awt.*;

@Getter
public class SquareView {
    private final Square square;
    private final GraphicsCoordinates inception;
    private final Rectangle rectangle;

    public SquareView(Square square, GraphicsCoordinates inception) {
        this.square = square;
        this.inception = inception;
        rectangle = new Rectangle(inception.getX(), inception.getY(), getSide(), getSide());
    }

    private static int getSide() {
        return MapView.getSquareSidePx();
    }
}
