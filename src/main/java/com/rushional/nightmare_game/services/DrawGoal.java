package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.views.GoalView;
import com.rushional.nightmare_game.views.MapView;

import java.awt.*;

public class DrawGoal {
    public static void call(GoalView goal, Graphics2D g2d) {
        for (int i = 0; i < 3; i++) {
            DrawSquare.call(goal.getSquareView(i), g2d);
        }
    }
}
