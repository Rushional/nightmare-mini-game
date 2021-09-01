package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.exceptions.*;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.models.squares.FreeSquare;
import com.rushional.nightmare_game.models.squares.Square;
import com.rushional.nightmare_game.models.squares.SquareColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveSquareTest {
    private MapModel map;

    @BeforeEach
    void init() {
        map = MapModel.createDefaultMap();
    }

    @Test
    void movesCorrectly() {
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

//    TODO: assert that all the exceptions are thrown correctly!
    @Test
    void throwsOriginEmpty() {
        SquareCoordinates from0 = new SquareCoordinates(1, 2);
        SquareCoordinates to0 = new SquareCoordinates(1, 3);
        try {
            MoveSquare.call(map, from0, to0);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        SquareCoordinates from1 = new SquareCoordinates(1, 2);
        SquareCoordinates to1 = new SquareCoordinates(1, 1);
        assertThrows(OriginIsEmptyException.class, ()-> {
            MoveSquare.call(map, from1, to1);
        });
    }

    @Test
    void throwsSquareImmovable() {
        SquareCoordinates from = new SquareCoordinates(0, 1);
        SquareCoordinates to = new SquareCoordinates(1, 1);
        assertThrows(SquareImmovableException.class, ()-> {
            MoveSquare.call(map, from, to);
        });
    }

    @Test
    void throwsSquaresNotNeighbours() {
        SquareCoordinates from = new SquareCoordinates(0, 0);
        SquareCoordinates to = new SquareCoordinates(1, 1);
        assertThrows(SquaresNotNeighboursException.class, ()-> {
            MoveSquare.call(map, from, to);
        });
    }

    @Test
    void throwsTargetFilled() {
        SquareCoordinates from = new SquareCoordinates(0, 0);
        SquareCoordinates to = new SquareCoordinates(1, 0);
        assertThrows(TargetIsFilledException.class, ()-> {
            MoveSquare.call(map, from, to);
        });
    }
}