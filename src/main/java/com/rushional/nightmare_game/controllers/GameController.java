package com.rushional.nightmare_game.controllers;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.GameView;
import lombok.Getter;

@Getter
public class GameController {
//    TODO: if needed, create a GameModel to simplify this class
    private MapModel mapModel;
    private GoalModel goalModel;
    private GameView gameView;

//    TODO: if making an init randomizer, create an Enum RANDOM, DEFAULT and have it here as an argument
//     in order to determine how to init the models
    public GameController() {
        initDefault();
    }

    private void initDefault() {
        mapModel = MapModel.createDefaultMap();
        goalModel = GoalModel.createDefaultGoal();
        gameView = new GameView(mapModel, goalModel);
    }

    public void startGame() {
        gameView.initiateGraphics();
    }
}
