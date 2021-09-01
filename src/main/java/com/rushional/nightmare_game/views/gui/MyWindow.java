package com.rushional.nightmare_game.views.gui;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.GoalView;
import com.rushional.nightmare_game.views.MapView;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow(MapView mapView, GoalView goalView) {
        super("Nightmare Realm's Mini Game");
        InfoPanel infoPanel = new InfoPanel(goalView);
        MapPanel mapPanel = new MapPanel(mapView);
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
        GridBagConstraints infoConstraints = new GridBagConstraints();
        infoConstraints.fill = GridBagConstraints.NONE;
        infoConstraints.weightx = 0;
        infoConstraints.weighty = 0;
        infoConstraints.gridx = 0;
        infoConstraints.gridy = 0;
        add(infoPanel, infoConstraints);

        GridBagConstraints mapConstraints = new GridBagConstraints();
        mapConstraints.fill = GridBagConstraints.NONE;
        mapConstraints.weightx = 0;
        mapConstraints.weighty = 0;
        mapConstraints.gridx = 0;
        mapConstraints.gridy = 1;
        add(mapPanel, mapConstraints);
    }
}
