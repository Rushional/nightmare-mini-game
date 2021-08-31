package com.rushional.nightmare_game;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.MapView;
import com.rushional.nightmare_game.views.gui.MyWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MapModel mapModel = new MapModel();
        MapView mapView = new MapView(mapModel);
        JFrame window = new MyWindow(mapView, mapModel);
    }
}
