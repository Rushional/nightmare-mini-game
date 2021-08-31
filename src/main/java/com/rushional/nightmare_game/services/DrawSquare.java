package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.views.SquareView;

import java.awt.*;

public class DrawSquare {
    public static void call(SquareView squareView, Graphics2D g2d) {
        colorSquare(squareView, g2d);
        g2d.setColor(Color.BLACK);
        g2d.draw(squareView.getRectangle());
    }

    private static void colorSquare(SquareView squareView, Graphics2D g2d) {
        Color color = GetSquareRGB.call(squareView.getSquare());
        g2d.setColor(color);
        g2d.fill(squareView.getRectangle());
    }
}
