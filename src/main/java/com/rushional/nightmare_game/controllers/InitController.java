package com.rushional.nightmare_game.controllers;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import lombok.Getter;

@Getter
public class InitController {
    private MapModel mapModel;
    private GoalModel goalModel;
    private GuiController guiController;

//    TODO: if making an init randomizer, create an Enum RANDOM, DEFAULT and have it here as an argument
//     in order to determine how to init the models
    public InitController() {
        initDefault();
    }

    private void initDefault() {
        mapModel = MapModel.createDefaultMap();
        goalModel = GoalModel.createDefaultGoal();
        guiController = new GuiController(mapModel, goalModel);
    }

    public void startGame() {
        guiController.initiateGraphics();
        guiController.turnOnInput();
    }
}
