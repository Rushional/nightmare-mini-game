package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.FreeSquare;
import com.rushional.nightmare_game.models.squares.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapModelTest {
    private MapModel mapModel;

    @BeforeEach
    void init() {
        mapModel = MapModel.createDefaultMap();
    }


    @Test
    void putSquare() {
        Square freeSquare = new FreeSquare();
        SquareCoordinates coords = new SquareCoordinates(0, 0);
        mapModel.putSquare(coords, freeSquare);
        Square queriedSquare = mapModel.getSquare(coords);
        assertFalse(queriedSquare.isFilled());
        assertFalse(queriedSquare.isMovable());
        assertTrue(queriedSquare instanceof FreeSquare);
    }

    @Test
    void isSquareInBounds() {
        SquareCoordinates goodCoords0 = new SquareCoordinates(0,0);
        assertFalse(mapModel.isSquareOutOfBounds(goodCoords0));
        SquareCoordinates goodCoords1 = new SquareCoordinates(2,3);
        assertFalse(mapModel.isSquareOutOfBounds(goodCoords1));
        SquareCoordinates goodCoords2 = new SquareCoordinates(5,5);
        assertFalse(mapModel.isSquareOutOfBounds(goodCoords2));

        SquareCoordinates badCoords0 = new SquareCoordinates(-1, 1);
        assertTrue(mapModel.isSquareOutOfBounds(badCoords0));
        SquareCoordinates badCoords1 = new SquareCoordinates(-2, 1);
        assertTrue(mapModel.isSquareOutOfBounds(badCoords1));
        SquareCoordinates badCoords2 = new SquareCoordinates(-2, -3);
        assertTrue(mapModel.isSquareOutOfBounds(badCoords2));
        SquareCoordinates badCoords3 = new SquareCoordinates(6, 1);
        assertTrue(mapModel.isSquareOutOfBounds(badCoords3));
        SquareCoordinates badCoords4 = new SquareCoordinates(7, 6);
        assertTrue(mapModel.isSquareOutOfBounds(badCoords4));
    }

    @Test
    void areNeighbours() {
        SquareCoordinates coords00 = new SquareCoordinates(0,0);
        SquareCoordinates coords01 = new SquareCoordinates(0,1);
        SquareCoordinates coords10 = new SquareCoordinates(1,0);
        SquareCoordinates coords20 = new SquareCoordinates(2,0);
        SquareCoordinates coords02 = new SquareCoordinates(0,2);
        SquareCoordinates coords11 = new SquareCoordinates(1,1);
        assertTrue(MapModel.areNeighbours(coords00, coords01));
        assertTrue(MapModel.areNeighbours(coords00, coords10));
        assertTrue(MapModel.areNeighbours(coords10, coords20));
        assertTrue(MapModel.areNeighbours(coords01, coords02));
        assertTrue(MapModel.areNeighbours(coords01, coords11));
        assertTrue(MapModel.areNeighbours(coords10, coords11));

        assertFalse(MapModel.areNeighbours(coords00, coords11));
        assertFalse(MapModel.areNeighbours(coords00, coords02));
        assertFalse(MapModel.areNeighbours(coords00, coords20));
        assertFalse(MapModel.areNeighbours(coords01, coords20));
        assertFalse(MapModel.areNeighbours(coords02, coords10));
    }
}