package com.rushional.nightmare_game.controllers;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.GoalView;
import com.rushional.nightmare_game.views.gui.MyWindow;

public class GuiController {
    private GoalView goalView;
    private MyWindow window;
    private MapModel mapModel;
    private GoalModel goalModel;

    public GuiController(MapModel mapModel, GoalModel goalModel) {
        this.mapModel = mapModel;
        this.goalModel = goalModel;
        goalView = new GoalView(goalModel);
    }

    public void initiateGraphics() {
        InputController inputController = new InputController(this, mapModel, goalModel);
        window = new MyWindow(goalView, mapModel, this, inputController);
    }

    public void turnOnInput() {
        window.getMapPanel().initMapListener();
    }

    public void update() {
        window.getMapPanel().repaint();
    }

    public void showVictory() {
        window.getMapPanel().removeMapListener();
        System.out.println("You've won. Yay.");
    }
}
