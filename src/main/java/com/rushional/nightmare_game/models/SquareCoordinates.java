package com.rushional.nightmare_game.models;

import lombok.Getter;

import java.util.Objects;

@Getter
public class SquareCoordinates {
    private final int row;
    private final int column;

    public SquareCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareCoordinates that = (SquareCoordinates) o;
        return row == that.row && column == that.column;
    }
}
