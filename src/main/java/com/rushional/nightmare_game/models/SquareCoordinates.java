package com.rushional.nightmare_game.models;

import lombok.Getter;

@Getter
public class SquareCoordinates {
    private final int row;
    private final int column;

    public SquareCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
