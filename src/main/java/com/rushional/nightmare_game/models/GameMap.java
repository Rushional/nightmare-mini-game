package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.Square;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private final List<RowSlots> listRows;

    public GameMap() {
        listRows = new ArrayList<RowSlots>();
        for (int i = 0; i < 5; i++) {
            listRows.add(new RowSlots());
        }
    }

    public void putSquare(int row, int column, Square square) {
        getSlot(row, column).putSquare(square);
    }

    public SquareSlot getSlot(int row, int column) {
        return listRows.get(row).getSlot(column);
    }
}
