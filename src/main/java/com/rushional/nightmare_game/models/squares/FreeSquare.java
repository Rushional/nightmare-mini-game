package com.rushional.nightmare_game.models.squares;

import com.rushional.nightmare_game.models.SquareCoordinates;

public class FreeSquare extends Square {
    public FreeSquare(SquareCoordinates coordinates) {
        super(coordinates, false, false);
    }
}
