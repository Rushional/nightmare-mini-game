package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.Square;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final List<Square> listSquares;

    public Row() {
        listSquares = new ArrayList<>();
    }

    public void putSquare(int i, Square square) {
        listSquares.set(i, square);
    }

    void initSquare(int i, Square square) {
        listSquares.add(i, square);
    }

    public Square getSquare(int i) {
        return listSquares.get(i);
    }
}
