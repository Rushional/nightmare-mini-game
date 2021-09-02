package com.rushional.nightmare_game.views.gui;

import com.rushional.nightmare_game.controllers.InputController;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.services.DrawMap;
import com.rushional.nightmare_game.controllers.GuiController;
import com.rushional.nightmare_game.views.MapView;

import java.awt.*;

public class MapPanel extends DrawPanel {
    private GuiController guiController;
    private InputController inputController;
    private MapModel mapModel;
    private MapView mapView;

    private MapListener mapListener;

    public MapPanel(GuiController guiController, InputController inputController, MapModel mapModel) {
        this.guiController = guiController;
        this.inputController = inputController;
        this.mapModel = mapModel;
        this.mapView = new MapView(mapModel);
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
    }

    public void initMapListener() {
        mapListener = new MapListener(mapView, mapModel, inputController);
        addMouseListener(mapListener);
    }

    public void removeMapListener() {
        removeMouseListener(mapListener);
    }
}
