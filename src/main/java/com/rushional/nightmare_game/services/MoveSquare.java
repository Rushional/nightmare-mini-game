package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.exceptions.CoordinatesInvalidException;
import com.rushional.nightmare_game.exceptions.SquaresNotNeighboursException;
import com.rushional.nightmare_game.exceptions.WrongSquareTypeException;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.models.squares.FreeSquare;
import com.rushional.nightmare_game.models.squares.Square;
import com.rushional.nightmare_game.models.squares.SquareColor;

import static java.lang.StrictMath.abs;

public class MoveSquare {
    public static void call(MapModel map, SquareCoordinates fromCoordinates, SquareCoordinates toCoordinates)
            throws CoordinatesInvalidException, SquaresNotNeighboursException, WrongSquareTypeException {
        validateCoordinates(fromCoordinates, toCoordinates);
        validateNeighbours(fromCoordinates, toCoordinates);
        Square fromSq = map.getSquare(fromCoordinates);
        Square toSq = map.getSquare(toCoordinates);
        if (!(fromSq instanceof FilledSquare)) throw new WrongSquareTypeException();
        if (!(toSq instanceof FreeSquare)) throw new WrongSquareTypeException();
        SquareColor color = ((FilledSquare) fromSq).getColor();
        map.putSquare(toCoordinates, new FilledSquare(color));
        map.putSquare(fromCoordinates, new FreeSquare());
    }

    private static void validateNeighbours(SquareCoordinates from, SquareCoordinates to)
    throws SquaresNotNeighboursException {
        int row1 = from.getRow();
        int row2 = to.getRow();
        int column1 = from.getColumn();
        int column2 = to.getColumn();
        if (!(
                (row1 == row2 && oneApart(column1, column2)) ||
                (oneApart(row1, row2) && column1 == column2)
        ))
            throw new SquaresNotNeighboursException();
    }

    private static boolean oneApart(int x, int y) {
        return abs(x - y) == 1;
    }

    private static void validateCoordinates(SquareCoordinates from, SquareCoordinates to)
        throws CoordinatesInvalidException {
        if (checkIfCoordinatesInvalid(from)) throw new CoordinatesInvalidException();
        if (checkIfCoordinatesInvalid(to)) throw new CoordinatesInvalidException();
    }

    private static boolean checkIfCoordinatesInvalid(SquareCoordinates coordinates) {
        boolean flag = false;
        if (coordinates.getRow() < 0 || coordinates.getRow() > 5) flag = true;
        if (coordinates.getColumn() < 0 || coordinates.getColumn() > 5) flag = true;
        return flag;
    }
}
