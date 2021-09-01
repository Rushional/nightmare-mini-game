package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.views.MapView;
import com.rushional.nightmare_game.views.SquareView;
import com.rushional.nightmare_game.views.gui.GraphicsCoordinates;

import java.util.List;

public class GetSquareCoordsFromGraphics {
    public SquareCoordinates call(GraphicsCoordinates grCoords, MapView mapView) {
        List<SquareView> allSquares = mapView.getAllSquareViews();
        for (SquareView view : allSquares) {
            if (view.getRectangle().contains(grCoords.getX(), grCoords.getY()))
                return view.getSquare().getCoordinates();
        }
        return null;
    }
}
