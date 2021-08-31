package com.rushional.nightmare_game;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.MapView;
import com.rushional.nightmare_game.views.gui.MyWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MapView mapView = new MapView();
        MapModel mapModel = new MapModel();
        JFrame window = new MyWindow(mapView, mapModel);
    }
}
