package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.SquareColor;

import java.util.ArrayList;
import java.util.List;

public class GoalModel {
    private final List<SquareColor> listColors;

    public GoalModel(List<SquareColor> listColors) {
        if (listColors.size() > 3)
            throw new RuntimeException();
        this.listColors = new ArrayList<>(listColors);
    }

    public SquareColor getColor(int i) {
        return listColors.get(i);
    }

    public static GoalModel createDefaultGoal() {
        List<SquareColor> defaultColors = new ArrayList<>();
        defaultColors.add(SquareColor.GREEN);
        defaultColors.add(SquareColor.BLUE);
        defaultColors.add(SquareColor.RED);
        return new GoalModel(defaultColors);
    }
}
