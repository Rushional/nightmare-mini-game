package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.exceptions.CoordsOutOfBoundsException;
import com.rushional.nightmare_game.models.squares.*;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.lang.StrictMath.abs;

// TODO: move that "5" elsewhere to make this extendable
public class MapModel {
    private List<Row> listRows;

    public MapModel(boolean isRandom) {
        createEmptyRows();
        List<SquareColor> colorsList = getDefaultColorsOrder();
        if (isRandom) Collections.shuffle(colorsList);
        initMap(colorsList);
    }

    private void initMap(List<SquareColor> listColors) {
        if (listRows == null) throw new RuntimeException();
        if (listColors.size() != 15) throw new RuntimeException();
        Iterator<SquareColor> iterator = listColors.listIterator();
        initSquare(0,0, new FilledSquare(iterator.next()));
        initSquare(1,0, new FilledSquare(iterator.next()));
        initSquare(2,0, new FilledSquare(iterator.next()));
        initSquare(3,0, new FilledSquare(iterator.next()));
        initSquare(4,0, new FilledSquare(iterator.next()));

        initSquare(0, 1, new BlockedSquare());
        initSquare(1, 1, new FreeSquare());
        initSquare(2, 1, new BlockedSquare());
        initSquare(3, 1, new FreeSquare());
        initSquare(4, 1, new BlockedSquare());

        initSquare(0,2, new FilledSquare(iterator.next()));
        initSquare(1,2, new FilledSquare(iterator.next()));
        initSquare(2,2, new FilledSquare(iterator.next()));
        initSquare(3,2, new FilledSquare(iterator.next()));
        initSquare(4,2, new FilledSquare(iterator.next()));

        initSquare(0, 3, new BlockedSquare());
        initSquare(1, 3, new FreeSquare());
        initSquare(2, 3, new BlockedSquare());
        initSquare(3, 3, new FreeSquare());
        initSquare(4, 3, new BlockedSquare());

        initSquare(0,4, new FilledSquare(iterator.next()));
        initSquare(1,4, new FilledSquare(iterator.next()));
        initSquare(2,4, new FilledSquare(iterator.next()));
        initSquare(3,4, new FilledSquare(iterator.next()));
        initSquare(4,4, new FilledSquare(iterator.next()));
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

    public List<Square> getColumnList(int j) {
        List<Square> column = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            column.add(getSquare(new SquareCoordinates(i, j)));
        }
        return column;
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

    private void initSquare(int row, int col, Square square) {
        if (isSquareOutOfBounds(new SquareCoordinates(row, col))) throw new CoordsOutOfBoundsException();
        listRows.get(row).initSquare(col, square);
    }

    //    TODO: I don't like this solution. Maybe make a better one?
    private List<SquareColor> getDefaultColorsOrder() {
        List<SquareColor> defaultColors  = new ArrayList<>();
        defaultColors.add(SquareColor.BLUE);
        defaultColors.add(SquareColor.RED);
        defaultColors.add(SquareColor.GREEN);
        defaultColors.add(SquareColor.BLUE);
        defaultColors.add(SquareColor.RED);
        defaultColors.add(SquareColor.GREEN);
        defaultColors.add(SquareColor.GREEN);
        defaultColors.add(SquareColor.RED);
        defaultColors.add(SquareColor.BLUE);
        defaultColors.add(SquareColor.RED);
        defaultColors.add(SquareColor.BLUE);
        defaultColors.add(SquareColor.BLUE);
        defaultColors.add(SquareColor.RED);
        defaultColors.add(SquareColor.GREEN);
        defaultColors.add(SquareColor.GREEN);
        return defaultColors;
    }
}
