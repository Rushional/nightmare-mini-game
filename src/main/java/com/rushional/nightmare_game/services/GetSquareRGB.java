package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.models.squares.BlockedSquare;
import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.models.squares.FreeSquare;
import com.rushional.nightmare_game.models.squares.Square;

import java.awt.*;

public class GetSquareRGB {
    public static Color call(Square square) {
        if (square instanceof FreeSquare)
            return new Color(158, 182, 238);
        if (square instanceof BlockedSquare)
            return new Color(38, 11, 75);
        if (square instanceof FilledSquare) {
            switch (((FilledSquare) square).getColor()) {
                case RED:
                    return new Color(255, 0, 0);
                case GREEN:
                    return new Color(0, 255, 0);
                case BLUE:
                    return new Color(0, 0, 255);
                default:
                    throw new RuntimeException();
            }
        } else throw new RuntimeException();
    }
}
