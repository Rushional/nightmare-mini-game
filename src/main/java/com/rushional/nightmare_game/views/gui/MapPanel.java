package com.rushional.nightmare_game.views.gui;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.services.DrawMap;
import com.rushional.nightmare_game.views.MapView;

import java.awt.*;

public class MapPanel extends DrawPanel {
    private MapView mapView;
    private MapModel mapModel;

    public MapPanel(MapView mapView, MapModel mapModel) {
        this.mapView = mapView;
        this.mapModel = mapModel;
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(475, 435));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        mapView = new MapView(mapModel);
        DrawMap.call(mapView, g2d);
        System.out.println("Redrawn");
    }

    public void initMapListener() {
        addMouseListener(new MapListener(mapView, mapModel));
    }
}
