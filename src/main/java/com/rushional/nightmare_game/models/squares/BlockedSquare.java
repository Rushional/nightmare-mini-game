package com.rushional.nightmare_game.models.squares;

import com.rushional.nightmare_game.models.SquareCoordinates;

public class BlockedSquare extends Square {
    public BlockedSquare(SquareCoordinates coordinates) {
        super(coordinates, false, true);
    }
}
