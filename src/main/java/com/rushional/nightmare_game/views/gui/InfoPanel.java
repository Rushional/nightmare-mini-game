package com.rushional.nightmare_game.views.gui;

import com.rushional.nightmare_game.services.DrawGoal;
import com.rushional.nightmare_game.views.GoalView;

import java.awt.*;

public class InfoPanel extends DrawPanel {
    GoalView goalView;

    public InfoPanel(GoalView goalView) {
        this.goalView = goalView;
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(475, 140));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        DrawGoal.call(goalView, g2d);
//        call some fancy service to draw everything that has ever existed
    }
}
