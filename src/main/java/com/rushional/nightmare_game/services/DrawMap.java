package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.views.MapView;

import java.awt.*;

public class DrawMap {
    public static void call(MapView mapView, Graphics2D g2d) {
        for (int i = 0; i < 5; i++) {
            DrawRow.call(mapView.getRowView(i), g2d);
        }
    }
}
