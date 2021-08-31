package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.exceptions.*;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.models.squares.FreeSquare;
import com.rushional.nightmare_game.models.squares.Square;

public class MoveSquare {
    public static void call(MapModel map, SquareCoordinates from, SquareCoordinates to)
            throws SquaresNotNeighboursException,
            OriginIsEmptyException, TargetIsFilledException, SquareImmovableException {
        if (!MapModel.areNeighbours(from, to)) throw new SquaresNotNeighboursException();
        Square originSq = map.getSquare(from);
        Square targetSq = map.getSquare(to);
        if (!originSq.isFilled()) throw new OriginIsEmptyException();
        if (!originSq.isMovable()) throw new SquareImmovableException();
        if (targetSq.isFilled()) throw new TargetIsFilledException();
        map.putSquare(to, ((FilledSquare) originSq).copy());
        map.putSquare(from, new FreeSquare());
    }
}
