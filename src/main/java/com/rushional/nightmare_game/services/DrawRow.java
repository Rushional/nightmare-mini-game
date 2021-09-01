package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.views.RowView;

import java.awt.*;

public class DrawRow {
    public static void call(RowView rowView, Graphics2D g2d) {
        for (int i = 0; i < 5; i++) {
            DrawSquare.call(rowView.getSquareView(i), g2d);
        }
    }
}
