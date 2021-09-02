package com.rushional.nightmare_game.controllers;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.services.CheckVictory;
import com.rushional.nightmare_game.services.MoveSquare;

public class InputController {
    private GuiController guiController;
    private MapModel mapModel;
    private GoalModel goalModel;

    public InputController(GuiController guiController, MapModel mapModel, GoalModel goalModel) {
        this.guiController = guiController;
        this.mapModel = mapModel;
        this.goalModel = goalModel;
    }

    public void resolveMoveAttempt(SquareCoordinates from, SquareCoordinates to) {
        try {
            MoveSquare.call(mapModel, from, to);
            System.out.println("Successfully moved");
        } catch (Exception ex) {
//            TODO: Make an exception handler
            System.out.println(ex.getClass());
        }
        guiController.update();
        if (CheckVictory.call(mapModel, goalModel)) {
            guiController.showVictory();
        }
    }
}
