package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.models.squares.FreeSquare;
import com.rushional.nightmare_game.models.squares.Square;
import com.rushional.nightmare_game.models.squares.SquareColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveSquareTest {

    @Test
    void call() {
        MapModel map = new MapModel();
        SquareCoordinates fromCoordinates = new SquareCoordinates(1, 0);
        SquareColor color = ((FilledSquare) map.getSquare(fromCoordinates)).getColor();
        try {
            MoveSquare.call(map, fromCoordinates, new SquareCoordinates(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        Square moved = map.getSquare(new SquareCoordinates(1, 1));
        assertTrue(moved instanceof FilledSquare);
        assertTrue(map.getSquare(new SquareCoordinates(1, 0)) instanceof FreeSquare);
        assertEquals(color, ((FilledSquare) moved).getColor());
    }
}