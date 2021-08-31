package com.rushional.nightmare_game.views.gui;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.MapView;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow(MapView mapView, MapModel mapModel) {
        super("Nightmare Realm's Mini Game");
        MapPanel mapPanel = new MapPanel(mapView, mapModel);
        InfoPanel infoPanel = new InfoPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(mapPanel, infoPanel);
//        Needed to center the frame with setLocationRelativeTo(null)
        setSize(1000, 700);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void addComponentsToPane(MapPanel mapPanel, InfoPanel infoPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints mapConstraints = new GridBagConstraints();
        mapConstraints.fill = GridBagConstraints.NONE;
        mapConstraints.weightx = 0;
        mapConstraints.weighty = 0;
        mapConstraints.gridx = 0;
        mapConstraints.gridy = 0;
        add(mapPanel, mapConstraints);

        GridBagConstraints infoConstraints = new GridBagConstraints();
        infoConstraints.fill = GridBagConstraints.NONE;
        infoConstraints.weightx = 0;
        infoConstraints.weighty = 0;
        infoConstraints.gridx = 1;
        infoConstraints.gridy = 0;
        add(infoPanel, infoConstraints);
    }
}
