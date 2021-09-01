package com.rushional.nightmare_game.models.squares;

import com.rushional.nightmare_game.models.SquareCoordinates;
import lombok.Getter;

@Getter
public abstract class Square {
    SquareCoordinates coordinates;
    boolean movable;
    boolean filled;

    public Square(SquareCoordinates coordinates, boolean movable, boolean filled) {
        this.coordinates = coordinates;
        this.movable = movable;
        this.filled = filled;
    }
}
