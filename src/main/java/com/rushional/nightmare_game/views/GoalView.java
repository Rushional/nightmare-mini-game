package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.views.gui.GraphicsCoordinates;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GoalView {
    private final List<SquareView> goalRowList;
    @Getter
    private static final GraphicsCoordinates goalInceptionPoint = new GraphicsCoordinates(50, 50);

    public GoalView(GoalModel model) {
        goalRowList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            GraphicsCoordinates coords = goalShift(i);
            SquareView squareView = new SquareView(new FilledSquare(model.getColor(i)), null, coords);
            goalRowList.add(i, squareView);
        }
    }

    private GraphicsCoordinates goalShift(int i) {
        return GraphicsCoordinates.shift(goalInceptionPoint,
                i * (2 * MapView.getSquareSidePx() + 2 * MapView.getHorizontalGap()),
                0
        );
    }

    public SquareView getSquareView(int i) {
        return goalRowList.get(i);
    }
}
