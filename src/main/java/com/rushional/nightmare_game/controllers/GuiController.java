package com.rushional.nightmare_game.controllers;

import com.rushional.nightmare_game.exceptions.*;
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

//    TODO: Obviously not perfect
    public void handleException(Exception e) {
        if (e instanceof CoordinatesNullException) {
            System.out.println("Come on, click the squares");
        }
        else if (e instanceof CoordsOutOfBoundsException) {
            System.out.println("I honestly have no idea how you've even managed that.");
            e.printStackTrace();
        }
        else if (e instanceof MovingIntoItselfException) {
            System.out.println("Don't actually click at the squares! Drag them instead...");
        }
        else if (e instanceof OriginIsEmptyException) {
            System.out.println("Drag those colored ones. Red, Green and Blue. Don't drag an empty one");
        }
        else if (e instanceof SquareImmovableException) {
            System.out.println("This one can't be moved.");
        }
        else if (e instanceof SquaresNotNeighboursException) {
            System.out.println("You can only swap neighbours. Diagonals don't work either.");
        }
        else if (e instanceof TargetIsFilledException) {
            System.out.println("You can only move a Square into an empty spot");
        }
    }
}
