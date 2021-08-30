package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.Square;

public class SquareSlot {
    private Square square;

    public Square getSquare() {
        return square;
    }

    public void putSquare(Square square) {
        this.square = square;
    }
}
