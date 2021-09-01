package com.rushional.nightmare_game.views.gui;

import lombok.Getter;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MapListener extends MouseInputAdapter {
    @Getter
    private ClickCoordinates clickCoordinates = null;
    private Point pressedPoint;
    Object monitor;

    public MapListener(Object monitor) {
        super();
        this.monitor = monitor;
    }

    public void mousePressed(MouseEvent e)
    {
        pressedPoint = e.getPoint();
    }

    public void mouseReleased(MouseEvent e)
    {
        Point releasedPoint = e.getPoint();
        clickCoordinates = new ClickCoordinates(pressedPoint, releasedPoint);
        synchronized (monitor) {
            monitor.notify();
        }
    }
}
