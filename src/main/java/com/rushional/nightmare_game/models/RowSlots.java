package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.Square;

import java.util.ArrayList;
import java.util.List;

public class RowSlots {
    private final List<SquareSlot> row;

    public RowSlots() {
        row = new ArrayList<SquareSlot>();
        for (int i = 0; i < 5; i++) {
            row.add(new SquareSlot());
        }
    }

    public void putSquare(int i, Square square) {
        row.get(i).putSquare(square);
    }

    public SquareSlot getSlot(int i) {
        return row.get(i);
    }
}
