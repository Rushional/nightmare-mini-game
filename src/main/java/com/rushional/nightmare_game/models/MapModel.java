package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.exceptions.CoordsOutOfBoundsException;
import com.rushional.nightmare_game.models.squares.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;

// TODO: move that "5" elsewhere to make this extendable
public class MapModel {
    private List<RowSlots> listRows;

    public MapModel() {
        createSlotsMap();
        initiateSquares();
    }

    public void putSquare(SquareCoordinates coords, Square square) {
        if (isSquareOutOfBounds(coords)) throw new CoordsOutOfBoundsException();
        getSlot(coords).putSquare(square);
    }

    public void putSquare(int row, int column, Square square) {
        putSquare(new SquareCoordinates(row, column), square);
    }

    public Square getSquare(SquareCoordinates coords) {
        if (isSquareOutOfBounds(coords)) throw new CoordsOutOfBoundsException();
        return getSlot(coords).getSquare();
    }

    public boolean isSquareOutOfBounds(SquareCoordinates coords) {
        if (coords.getRow() < 0 || coords.getRow() > 5) return true;
        if (coords.getColumn() < 0 || coords.getColumn() > 5) return true;
        return false;
    }

    private SquareSlot getSlot(SquareCoordinates coordinates) {
        return listRows.get(coordinates.getRow()).getSlot(coordinates.getColumn());
    }

    public static boolean areNeighbours(SquareCoordinates from, SquareCoordinates to) {
        int row1 = from.getRow();
        int row2 = to.getRow();
        int col1 = from.getColumn();
        int col2 = to.getColumn();
        return (
                (row1 == row2 && oneApart(col1, col2)) ||
                (col1 == col2 && oneApart(row1, row2))
        );
    }

    private static boolean oneApart(int x, int y) {
        return abs(x - y) == 1;
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
