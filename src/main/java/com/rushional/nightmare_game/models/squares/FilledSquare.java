package com.rushional.nightmare_game.models.squares;

import com.rushional.nightmare_game.models.SquareCoordinates;
import lombok.Getter;

public class FilledSquare extends Square {
    @Getter
    private final SquareColor color;

    public FilledSquare(SquareCoordinates coordinates, SquareColor color) {
        super(coordinates, true, true);
        this.color = color;
    }

    public FilledSquare copy() {
        return new FilledSquare(coordinates, color);
    }
}
