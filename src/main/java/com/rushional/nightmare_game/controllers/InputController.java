package com.rushional.nightmare_game.controllers;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.services.MoveSquare;

public class InputController {
    private GuiController guiController;
    private MapModel mapModel;

    public InputController(GuiController guiController, MapModel mapModel) {
        this.guiController = guiController;
        this.mapModel = mapModel;
    }

    public void resolveMoveAttempt(SquareCoordinates from, SquareCoordinates to) {
        try {
            MoveSquare.call(mapModel, from, to);
            System.out.println("Successfully moved");
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }
        guiController.update();
    }
}
