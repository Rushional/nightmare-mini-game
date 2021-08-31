package com.rushional.nightmare_game.models.squares;

import lombok.Getter;

@Getter
public abstract class Square {
    boolean movable;
    boolean filled;

    public Square(boolean movable, boolean filled) {
        this.movable = movable;
        this.filled = filled;
    }
}
