package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.*;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private List<RowSlots> listRows;

    public GameMap() {
        createSlotsMap();
        initiateSquares();
    }

    public void putSquare(int row, int column, Square square) {
        getSlot(row, column).putSquare(square);
    }

    public SquareSlot getSlot(int row, int column) {
        return listRows.get(row).getSlot(column);
    }

    private void createSlotsMap() {
        listRows = new ArrayList<RowSlots>();
        for (int i = 0; i < 5; i++) {
            listRows.add(new RowSlots());
        }
    }

    //    TODO: Make a randomizer and probably move to a separate class
    private void initiateSquares() {
        if (listRows == null) throw new RuntimeException();
        putSquare(0,0, new FilledSquare(SquareColor.BLUE));
        putSquare(1,0, new FilledSquare(SquareColor.RED));
        putSquare(2,0, new FilledSquare(SquareColor.GREEN));
        putSquare(3,0, new FilledSquare(SquareColor.BLUE));
        putSquare(4,0, new FilledSquare(SquareColor.RED));

        putSquare(0, 1, new BlockedSquare());
        putSquare(1, 1, new FreeSquare());
        putSquare(2, 1, new BlockedSquare());
        putSquare(3, 1, new FreeSquare());
        putSquare(4, 1, new BlockedSquare());

        putSquare(0,2, new FilledSquare(SquareColor.GREEN));
        putSquare(1,2, new FilledSquare(SquareColor.GREEN));
        putSquare(2,2, new FilledSquare(SquareColor.RED));
        putSquare(3,2, new FilledSquare(SquareColor.BLUE));
        putSquare(4,2, new FilledSquare(SquareColor.RED));

        putSquare(0, 3, new BlockedSquare());
        putSquare(1, 3, new FreeSquare());
        putSquare(2, 3, new BlockedSquare());
        putSquare(3, 3, new FreeSquare());
        putSquare(4, 3, new BlockedSquare());

        putSquare(0,4, new FilledSquare(SquareColor.BLUE));
        putSquare(1,4, new FilledSquare(SquareColor.BLUE));
        putSquare(2,4, new FilledSquare(SquareColor.RED));
        putSquare(3,4, new FilledSquare(SquareColor.GREEN));
        putSquare(4,4, new FilledSquare(SquareColor.GREEN));
    }
}
