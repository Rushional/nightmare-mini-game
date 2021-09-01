package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.views.gui.MyWindow;

public class GameView {
    private MapView mapView;
    private GoalView goalView;
    private MyWindow window;

    public GameView(MapModel mapModel, GoalModel goalModel) {
        mapView = new MapView(mapModel);
        goalView = new GoalView(goalModel);
    }

    public void initiateGraphics() {
        window = new MyWindow(mapView, goalView);
    }
}
