package com.rushional.nightmare_game.models.squares;

import lombok.Getter;

public class FilledSquare extends Square {
    @Getter
    private final SquareColor color;

    public FilledSquare(SquareColor color) {
        super(true, true);
        this.color = color;
    }

    public FilledSquare copy() {
        return new FilledSquare(color);
    }
}
