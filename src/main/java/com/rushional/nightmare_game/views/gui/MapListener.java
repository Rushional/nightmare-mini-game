package com.rushional.nightmare_game.views.gui;

import com.rushional.nightmare_game.controllers.InputController;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.services.GetSquareCoordsFromGraphics;
import com.rushional.nightmare_game.services.MoveSquare;
import com.rushional.nightmare_game.views.MapView;
import lombok.Getter;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MapListener extends MouseInputAdapter {
    private MapView mapView;
    private MapModel mapModel;
    private InputController controller;

    @Getter
    private ClickCoordinates clickCoordinates = null;
    private Point pressedPoint;

    public MapListener(MapView mapView, MapModel mapModel, InputController controller) {
        this.mapView = mapView;
        this.mapModel = mapModel;
        this.controller = controller;
    }

    public void mousePressed(MouseEvent e)
    {
        pressedPoint = e.getPoint();
    }

    public void mouseReleased(MouseEvent e)
    {
        Point releasedPoint = e.getPoint();
        clickCoordinates = new ClickCoordinates(pressedPoint, releasedPoint);
        SquareCoordinates from = GetSquareCoordsFromGraphics.call(
                new GraphicsCoordinates(pressedPoint.x, pressedPoint.y), mapView);
        SquareCoordinates to = GetSquareCoordsFromGraphics.call(
                new GraphicsCoordinates(releasedPoint.x, releasedPoint.y), mapView);
        controller.resolveMoveAttempt(from, to);

    }
}