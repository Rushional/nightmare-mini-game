package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.models.squares.Square;
import com.rushional.nightmare_game.models.squares.SquareColor;
import com.rushional.nightmare_game.views.MapView;
import com.rushional.nightmare_game.views.SquareView;
import com.rushional.nightmare_game.views.gui.GraphicsCoordinates;

import java.awt.*;

public class DrawMap {
    public static void call(MapView mapView, Graphics2D g2d) {
//        DrawSquare.call(mapView.getSquareView(new SquareCoordinates(0,0)), g2d);
//        TODO: this is temporary. It's used to test DrawSquare
        Square square = new FilledSquare(SquareColor.BLUE);
        SquareView squareView = new SquareView(square, new GraphicsCoordinates(50, 50));
        DrawSquare.call(squareView, g2d);
    }
}
