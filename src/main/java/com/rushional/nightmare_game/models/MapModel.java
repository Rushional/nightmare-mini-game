package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.exceptions.CoordsOutOfBoundsException;
import com.rushional.nightmare_game.models.squares.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;

// TODO: move that "5" elsewhere to make this extendable
public class MapModel {
    private List<Row> listRows;

//    TODO: Make a randomizer and probably move to a separate class
    public MapModel() {
        createEmptyRows();
    }

    public void putSquare(Square square, SquareCoordinates where) {
        if (isSquareOutOfBounds(where)) throw new CoordsOutOfBoundsException();
        listRows.get(where.getRow()).putSquare(where.getColumn(), square);
    }
    public Square getSquare(SquareCoordinates coords) {
        if (isSquareOutOfBounds(coords)) throw new CoordsOutOfBoundsException();
        return listRows.get(coords.getRow()).getSquare(coords.getColumn());
    }

    public Row getRow(int i) {
        return listRows.get(i);
    }

    public boolean isSquareOutOfBounds(SquareCoordinates coords) {
        if (coords.getRow() < 0 || coords.getRow() > 5) return true;
        if (coords.getColumn() < 0 || coords.getColumn() > 5) return true;
        return false;
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

    private void createEmptyRows() {
        listRows = new ArrayList<Row>();
        for (int i = 0; i < 5; i++) {
            listRows.add(new Row());
        }
    }


//    TODO: move default initiation somewhere static
    public static MapModel createDefaultMap() {
        MapModel mapModel = new MapModel();
        if (mapModel.listRows == null) throw new RuntimeException();
        SquareCoordinates c00 = new SquareCoordinates(0, 0);
        mapModel.initSquare(c00, new FilledSquare(c00, SquareColor.BLUE));
        SquareCoordinates c10 = new SquareCoordinates(1, 0);
        mapModel.initSquare(c10, new FilledSquare(c10, SquareColor.RED));
        SquareCoordinates c20 = new SquareCoordinates(2, 0);
        mapModel.initSquare(c20, new FilledSquare(c20, SquareColor.GREEN));
        SquareCoordinates c30 = new SquareCoordinates(3, 0);
        mapModel.initSquare(c30, new FilledSquare(c30, SquareColor.BLUE));
        SquareCoordinates c40 = new SquareCoordinates(4, 0);
        mapModel.initSquare(c40, new FilledSquare(c40, SquareColor.RED));

        SquareCoordinates c01 = new SquareCoordinates(0, 1);
        mapModel.initSquare(c01, new BlockedSquare(c01));
        SquareCoordinates c11 = new SquareCoordinates(1, 1);
        mapModel.initSquare(c11, new FreeSquare(c11));
        SquareCoordinates c21 = new SquareCoordinates(2, 1);
        mapModel.initSquare(c21, new BlockedSquare(c21));
        SquareCoordinates c31 = new SquareCoordinates(3, 1);
        mapModel.initSquare(c31, new FreeSquare(c31));
        SquareCoordinates c41 = new SquareCoordinates(4, 1);
        mapModel.initSquare(c41, new BlockedSquare(c41));

        SquareCoordinates c02 = new SquareCoordinates(0, 2);
        mapModel.initSquare(c02, new FilledSquare(c02, SquareColor.GREEN));
        SquareCoordinates c12 = new SquareCoordinates(1, 2);
        mapModel.initSquare(c12, new FilledSquare(c12, SquareColor.GREEN));
        SquareCoordinates c22 = new SquareCoordinates(2, 2);
        mapModel.initSquare(c22, new FilledSquare(c22, SquareColor.RED));
        SquareCoordinates c32 = new SquareCoordinates(3, 2);
        mapModel.initSquare(c32, new FilledSquare(c32, SquareColor.BLUE));
        SquareCoordinates c42 = new SquareCoordinates(4, 2);
        mapModel.initSquare(c42, new FilledSquare(c42, SquareColor.RED));

        SquareCoordinates c03 = new SquareCoordinates(0, 3);
        mapModel.initSquare(c03, new BlockedSquare(c03));
        SquareCoordinates c13 = new SquareCoordinates(1, 3);
        mapModel.initSquare(c13, new FreeSquare(c13));
        SquareCoordinates c23 = new SquareCoordinates(2, 3);
        mapModel.initSquare(c23, new BlockedSquare(c23));
        SquareCoordinates c33 = new SquareCoordinates(3, 3);
        mapModel.initSquare(c33, new FreeSquare(c33));
        SquareCoordinates c43 = new SquareCoordinates(4, 3);
        mapModel.initSquare(c43, new BlockedSquare(c43));

        SquareCoordinates c04 = new SquareCoordinates(0, 4);
        mapModel.initSquare(c04, new FilledSquare(c04, SquareColor.BLUE));
        SquareCoordinates c14 = new SquareCoordinates(1, 4);
        mapModel.initSquare(c14, new FilledSquare(c14, SquareColor.BLUE));
        SquareCoordinates c24 = new SquareCoordinates(2, 4);
        mapModel.initSquare(c24, new FilledSquare(c24, SquareColor.RED));
        SquareCoordinates c34 = new SquareCoordinates(3, 4);
        mapModel.initSquare(c34, new FilledSquare(c34, SquareColor.GREEN));
        SquareCoordinates c44 = new SquareCoordinates(4, 4);
        mapModel.initSquare(c44, new FilledSquare(c44, SquareColor.GREEN));
        return mapModel;
    }

    private void initSquare(SquareCoordinates coords, Square square) {
        if (isSquareOutOfBounds(coords)) throw new CoordsOutOfBoundsException();
        listRows.get(coords.getRow()).initSquare(coords.getColumn(), square);
    }
}
