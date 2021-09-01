package com.rushional.nightmare_game.views.gui;

import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.services.GetSquareCoordsFromGraphics;
import lombok.Getter;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MapListener extends MouseInputAdapter {
    @Getter
    private ClickCoordinates clickCoordinates = null;
    private Point pressedPoint;

    public void mousePressed(MouseEvent e)
    {
        pressedPoint = e.getPoint();
    }

    public void mouseReleased(MouseEvent e)
    {
        Point releasedPoint = e.getPoint();
        clickCoordinates = new ClickCoordinates(pressedPoint, releasedPoint);
//        SquareCoordinates sqCoords = GetSquareCoordsFromGraphics
    }
}
