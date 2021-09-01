package com.rushional.nightmare_game.controllers;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.GoalView;
import com.rushional.nightmare_game.views.gui.MyWindow;
import lombok.Getter;

public class GuiController {
    private GoalView goalView;
    private MyWindow window;
    private MapModel mapModel;

    public GuiController(MapModel mapModel, GoalModel goalModel) {
        this.mapModel = mapModel;
        goalView = new GoalView(goalModel);
    }

    public void initiateGraphics() {
        window = new MyWindow(this, goalView, mapModel);
    }

    public void turnOnInput() {
        window.getMapPanel().initMapListener();
    }

    public void update() {
        window.getMapPanel().repaint();
    }
}
