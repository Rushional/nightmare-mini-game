package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.Square;
import lombok.Getter;

public class SquareSlot {
    @Getter
    private Square square;

    public void putSquare(Square square) {
        this.square = square;
    }
}
